package ru.rrozhkov.easykin.task.gui;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.task.impl.period.Period;
import ru.rrozhkov.easykin.task.impl.period.PeriodTaskBuilder;
import ru.rrozhkov.easykin.task.service.impl.CategoryService;
import ru.rrozhkov.easykin.task.service.impl.TaskService;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.gui.Form;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.util.DateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Date;

public class TaskForm extends Form {
	private static final long serialVersionUID = 1L;
	private static final TaskFactory taskFactory = TaskFactory.instance();
	private static final TaskService taskService = TaskService.instance();
	private static final CategoryService categoryService = CategoryService.instance();
	private static final PeriodTaskBuilder periodTaskBuilder = PeriodTaskBuilder.instance();

	private JTextField nameField;
	private JTextField planDateField;
	private JComboBox priorityComboBox;
	private JComboBox categoryComboBox;
	private JCheckBox repeatCheckBox;
	private JComboBox periodComboBox;
	private JTextField untilDateField;
	private Component nameLabel;
	private Component planDateLabel;
	private Component priorityLabel;
	private Component categoryLabel;
	private Component periodLabel;
	private Component untilDateLabel;
	private Component doneButton;
	
	private ITask task;
	
	public TaskForm(IGUIEditor parent, ITask task) {
		super(parent);
		this.task = task;
		fill();
	}
	
	protected void fill(){
		setLayout(guiFactory.gridLayout(10, 2));
		add(guiFactory.labelEmpty());
		if(!task.getStatus().isClose()){
			if(task.getId()!=-1){
				add(getDoneButton());
			}else
				add(guiFactory.labelEmpty());
		}else{
			add(getCloseDateLabel());
		}
		add(getNameLabel()); 
		add(getNameField()); 
		add(getPlanDateLabel()); 
		add(getPlanDateField()); 
		add(getPriorityLabel()); 
		add(getPriorityComboBox()); 
		add(getCategoryLabel()); 
		add(getCategoryComboBox());
		add(getRepeatCheckBox());
		add(guiFactory.labelEmpty());
		add(getPeriodLabel());
		add(getPeriodComboBox());
		add(getUntilDateLabel());
		add(getUntilDateField());
		if(!task.getStatus().isClose()){
			add(getOkButton());
		}else
			add(guiFactory.labelEmpty());
		add(getCancelButton());
	}
	
	private Component getCloseDateLabel() {
 		return guiFactory.label(DateUtil.format(task.getCloseDate()));
	}

	private JTextField getNameField(){
		if(nameField == null){
			nameField = (JTextField) guiFactory.fieldEditable(250, task.getName());
			if(task.getStatus().isClose())
				nameField.setEditable(false);
		}
		return nameField;
	}

	private JTextField getPlanDateField(){
		if(planDateField == null){
			planDateField = (JTextField) guiFactory.fieldEditable(10, DateUtil.format(task.getPlanDate()));
			if(task.getStatus().isClose())
				planDateField.setEditable(false);
		}
		return planDateField;
	}
	
	private Component getPriorityComboBox(){
		if(priorityComboBox == null){
			priorityComboBox = (JComboBox)guiFactory.comboBoxFilled(CollectionUtil.create(
					Priority.IMPOTANT_FAST,
					Priority.IMPOTANT_NOFAST,
					Priority.SIMPLE
			));
			priorityComboBox.setSelectedIndex(Priority.priority(task.getPriority()));
			if(task.getStatus().isClose())
				priorityComboBox.setEditable(false);
		}
		return priorityComboBox;
	}
	
	private Component getCategoryComboBox(){
		if(categoryComboBox == null){
			Collection<ICategory> categories = categoryService.categories();
			categoryComboBox = (JComboBox)guiFactory.comboBoxFilled(categories);
			for (ICategory category : categories) {
				if (category.getId() == task.getCategory().getId()) {
					categoryComboBox.setSelectedItem(category);
				}
			}

			if(task.getStatus().isClose())
				categoryComboBox.setEditable(false);
		}
		return categoryComboBox;
	}

	private Component getPeriodComboBox(){
		if(periodComboBox == null){
			periodComboBox = (JComboBox)guiFactory.comboBoxFilled(CollectionUtil.create(
					Period.DAY,
					Period.WEEK,
					Period.MONTH,
					Period.YEAR
			));
			if(task.getStatus().isClose())
				periodComboBox.setEditable(false);
		}
		return periodComboBox;
	}

	private JCheckBox getRepeatCheckBox(){
		if (repeatCheckBox == null) {
			repeatCheckBox = (JCheckBox)guiFactory.checkBox("Повтор");
		}
		return repeatCheckBox;
	}
	private JTextField getUntilDateField(){
		if(untilDateField == null){
			untilDateField = (JTextField) guiFactory.fieldEditable(10, "");
			if(task.getStatus().isClose())
				untilDateField.setEditable(false);
		}
		return untilDateField;
	}

	private Component getNameLabel(){
		if(nameLabel == null)
			nameLabel = guiFactory.label("Описание");
		return nameLabel;
	}
	
	private Component getPlanDateLabel(){
		if(planDateLabel == null)
			planDateLabel = guiFactory.label("Плановая дата");
		return planDateLabel;
	}

	private Component getPriorityLabel(){
		if(priorityLabel == null)
			priorityLabel = guiFactory.label("Приоритет");
		return priorityLabel;
	}

	private Component getCategoryLabel(){
		if(categoryLabel == null)
			categoryLabel = guiFactory.label("Категория");
		return categoryLabel;
	}

	private Component getPeriodLabel(){
		if(periodLabel == null)
			periodLabel = guiFactory.label("Период");
		return periodLabel;
	}

	private Component getUntilDateLabel(){
		if(untilDateLabel == null)
			untilDateLabel = guiFactory.label("До даты");
		return untilDateLabel;
	}

	protected void update() {
		task = taskFactory.createTask(task.getId(), getNameField().getText(), task.getCreateDate()
				, DateUtil.parse(getPlanDateField().getText()), priorityComboBox.getSelectedIndex()
				, categoryComboBox.getSelectedIndex(), "", null, Status.status(Status.OPEN));
	}

	private Component getDoneButton() {
	    if(doneButton==null){
	    	doneButton = guiFactory.button("Выполнить", new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					done();
				}
			});
	    }
		return doneButton;
	}

	private void done() {
		update();
		if (!validateData())
            return;
		taskService.close(task);
		parent.refresh();
	}

	protected void ok() {
		update();
		if (!validateData()) {
			return;
		}
		if (getRepeatCheckBox().isSelected()) {
			if (!validatePeriodic()) {
				return;
			}
			Period period = (Period)periodComboBox.getSelectedItem();
			Date untilDate = DateUtil.parse(untilDateField.getText());
			periodTaskBuilder.create(period, untilDate, task);
		} else {
			taskService.createOrUpdate(task);
		}
		parent.refresh();
	}

	protected boolean validateData() {
		return !"".equals(task.getName()) && DateUtil.parse(getPlanDateField().getText())!=null;
	}

	protected boolean validatePeriodic() {
		return periodComboBox.getSelectedItem()!=null && DateUtil.parse(getUntilDateField().getText())!=null;
	}
}