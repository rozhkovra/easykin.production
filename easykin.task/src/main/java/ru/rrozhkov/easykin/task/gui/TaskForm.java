package ru.rrozhkov.easykin.task.gui;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.easykin.task.db.impl.CategoryHandler;
import ru.rrozhkov.easykin.task.db.impl.TaskHandler;
import ru.rrozhkov.easykin.task.impl.convert.ArrayCategoryConverter;
import ru.rrozhkov.easykin.task.service.impl.TaskService;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.gui.Form;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.util.GuiUtil;
import ru.rrozhkov.lib.util.DateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class TaskForm extends Form {
	private static final long serialVersionUID = 1L;
	private JTextField nameField;
	private JTextField planDateField;
	private JComboBox priorityComboBox;
	private JComboBox categoryComboBox;
	private Component nameLabel;
	private Component planDateLabel;
	private Component priorityLabel;
	private Component categoryLabel;
	private Component doneButton;
	
	private ITask task;
	
	public TaskForm(IGUIEditor parent) {
		this(parent, TaskFactory.newTask());
	}

	public TaskForm(IGUIEditor parent, ITask task) {
		super(parent);
		this.task = task;
		fill();
	}
	
	protected void fill(){
		setLayout(new GridLayout(7,2));
		add(GuiUtil.labelEmpty());
		if(!task.getStatus().isClose()){
			if(task.getId()!=-1){
				add(getDoneButton());
			}else
				add(GuiUtil.labelEmpty());
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
		if(!task.getStatus().isClose()){
			add(getOkButton());
		}else
			add(GuiUtil.labelEmpty());
		add(getCancelButton());
	}
	
	private Component getCloseDateLabel() {
 		return new JLabel(DateUtil.format(task.getCloseDate()));
	}

	private JTextField getNameField(){
		if(nameField == null){
			nameField = (JTextField) GuiUtil.fieldEditable(250, task.getName());
			if(task.getStatus().isClose())
				nameField.setEditable(false);
		}
		return nameField;
	}

	private JTextField getPlanDateField(){
		if(planDateField == null){
			planDateField = (JTextField) GuiUtil.fieldEditable(10, DateUtil.format(task.getPlanDate()));
			if(task.getStatus().isClose())
				planDateField.setEditable(false);
		}
		return planDateField;
	}
	
	private JComboBox getPriorityComboBox(){
		if(priorityComboBox == null){
			priorityComboBox = new JComboBox(new Priority[]{
					Priority.IMPOTANT_FAST,
					Priority.IMPOTANT_NOFAST,
					Priority.SIMPLE
			});
			priorityComboBox.setSelectedIndex(Priority.priority(task.getPriority()) - 1);
			if(task.getStatus().isClose())
				priorityComboBox.setEditable(false);
		}
		return priorityComboBox;
	}
	
	private JComboBox getCategoryComboBox(){
		if(categoryComboBox == null){
			categoryComboBox = new JComboBox(categories());
			categoryComboBox.setSelectedItem(task.getCategory().getName());
			if(task.getStatus().isClose())
				categoryComboBox.setEditable(false);
		}
		return categoryComboBox;
	}
	
	private String[] categories() {
		Collection<ICategory> collection = CollectionUtil.create();
		try {
			collection = CategoryHandler.select();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayCategoryConverter().convert(collection);
	}

	private Component getNameLabel(){
		if(nameLabel == null)
			nameLabel = GuiUtil.label("Описание");
		return nameLabel;
	}
	
	private Component getPlanDateLabel(){
		if(planDateLabel == null)
			planDateLabel = GuiUtil.label("Плановая дата");
		return planDateLabel;
	}

	private Component getPriorityLabel(){
		if(priorityLabel == null)
			priorityLabel = GuiUtil.label("Приоритет");
		return priorityLabel;
	}

	private Component getCategoryLabel(){
		if(categoryLabel == null)
			categoryLabel = GuiUtil.label("Категория");
		return categoryLabel;
	}

	protected void update() {
		task = TaskFactory.createTask(task.getId(), getNameField().getText(), task.getCreateDate()
				, DateUtil.parse(getPlanDateField().getText()), priorityComboBox.getSelectedIndex()+1
				, categoryComboBox.getSelectedIndex()+1, "", null, Status.status(Status.OPEN));
	}

	private Component getDoneButton() {
	    if(doneButton==null){
	    	doneButton = GuiUtil.button("Выполнить",new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					update();
					if(!validateTask())
						return;
					try{
						TaskHandler.close(task);
					}catch(Exception ex){
						ex.printStackTrace();
					}
					parent.refresh();
				}

				private boolean validateTask() {
					return !"".equals(task.getName());
				}
			});
	    }
		return doneButton;
	}

	protected void ok() {
		update();
		if(!validateData())
			return;
		try{
			AuthManager authManager = AuthManager.instance();
			if(task.getId()==-1) {
				TaskService.create(authManager.signedPerson().getId(), task);
			}else {
				TaskHandler.update(task);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		parent.refresh();
	}

	protected boolean validateData() {
		return !"".equals(task.getName());
	}
}