package ru.rrozhkov.easykin.work.gui;

import ru.rrozhkov.easykin.model.person.util.PersonUtil;
import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.easykin.model.work.ReleaseType;
import ru.rrozhkov.easykin.model.work.TaskType;
import ru.rrozhkov.easykin.model.work.impl.WorkFactory;
import ru.rrozhkov.easykin.work.db.impl.ActivityHandler;
import ru.rrozhkov.lib.gui.Form;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.util.GuiUtil;
import ru.rrozhkov.lib.util.DateUtil;

import javax.swing.*;
import java.awt.*;

public class ActivityForm extends Form {
	private static final long serialVersionUID = 1L;
	private JTextField dateField;
	private JTextField personField;
	private JTextField timeField;
	private JComboBox taskTypeComboBox;
	private JTextField nameField;
	private JComboBox releaseTypeComboBox;
	private JTextField descField;

	private Component dateLabel;
	private Component personLabel;
	private Component timeLabel;
	private Component taskTypeLabel;
	private Component nameLabel;
	private Component releaseTypeLabel;
	private Component descLabel;

	private IActivity activity;

	public ActivityForm(IGUIEditor parent) {
		this(parent, WorkFactory.newActivity());
	}

	public ActivityForm(IGUIEditor parent, IActivity activity) {
		super(parent);
		this.activity = activity;
		fill();
	}
	
	protected void fill(){
		setLayout(new GridLayout(9, 2));
		add(GuiUtil.labelEmpty());
		add(GuiUtil.labelEmpty());
		add(getDateLabel());
		add(getDateField());
		add(getPersonLabel());
		add(getPersonField());
		add(getTimeLabel());
		add(getTimeField());
		add(getTaskTypeLabel());
		add(getTaskTypeComboBox());
		add(getNameLabel());
		add(getNameField());
		add(getReleaseTypeLabel());
		add(getReleaseTypeComboBox());
		add(getDescLabel());
		add(getDescField());
		add(getOkButton());
		add(getCancelButton());
	}

	private JComboBox getReleaseTypeComboBox(){
		if(releaseTypeComboBox == null){
			releaseTypeComboBox = new JComboBox(new ReleaseType[]{
					ReleaseType.R800,
					ReleaseType.R810,
					ReleaseType.R900,
					ReleaseType.R901,
					ReleaseType.R1000,
					ReleaseType.R1100,
					ReleaseType.R1200,
					ReleaseType.R1400,
					ReleaseType.R1500,
					ReleaseType.NORELEASE,
					ReleaseType.ANOTHER
			});
			releaseTypeComboBox.setSelectedItem(activity.getReleaseType());
		}
		return releaseTypeComboBox;
	}

	private Component getReleaseTypeLabel() {
		if(releaseTypeLabel == null){
			releaseTypeLabel = GuiUtil.label("Номер релиза");
		}
		return releaseTypeLabel;
	}

	private JComboBox getTaskTypeComboBox(){
		if(taskTypeComboBox == null){
			taskTypeComboBox = new JComboBox(new TaskType[]{
					TaskType.BUGFIX,
					TaskType.ESTIMATECR,
					TaskType.WRITEIC,
					TaskType.DEVELOPCR,
					TaskType.PRESENTATION,
					TaskType.DISPETCHER,
					TaskType.HOTFIX,
					TaskType.TANDM,
					TaskType.LEADPM,
					TaskType.VACATION,
					TaskType.ANOTHER
			});
			taskTypeComboBox.setSelectedItem(activity.getTaskType());
		}
		return taskTypeComboBox;
	}

	private Component getTaskTypeLabel() {
		if(taskTypeLabel == null){
			taskTypeLabel = GuiUtil.label("Тип задачи");
		}
		return taskTypeLabel;
	}

	private JTextField getTimeField() {
		if(timeField == null){
			timeField = (JTextField)GuiUtil.fieldEditable(2, String.valueOf(activity.getTime()));
		}
		return timeField;
	}

	private Component getTimeLabel() {
		if(timeLabel == null){
			timeLabel = GuiUtil.label("Время");
		}
		return timeLabel;
	}

	private JTextField getPersonField() {
		if(personField == null){
			personField = (JTextField)GuiUtil.fieldEditable(10, PersonUtil.fi(activity.getPerson()));
		}
		return personField;
	}

	private Component getPersonLabel() {
		if(personLabel == null){
			personLabel = GuiUtil.label("Имя");
		}
		return personLabel;
	}

	private JTextField getDateField() {
		if(dateField == null){
			dateField = (JTextField)GuiUtil.fieldEditable(10, DateUtil.format(activity.getDate()));
		}
		return dateField;
	}

	private Component getDateLabel() {
		if(dateLabel == null){
			dateLabel = GuiUtil.label("Дата");
		}
		return dateLabel;
	}

	private JTextField getNameField(){
		if(nameField == null){
			nameField = (JTextField)GuiUtil.fieldEditable(50, activity.getName());
		}
		return nameField;
	}

	private Component getNameLabel(){
		if(nameLabel == null)
			nameLabel = GuiUtil.label("Имя");
		return nameLabel;
	}

	private JTextField getDescField(){
		if(descField == null){
			descField = (JTextField)GuiUtil.fieldEditable(50, activity.getDesc());
		}
		return descField;
	}

	private Component getDescLabel(){
		if(descLabel == null)
			descLabel = GuiUtil.label("Комментарий");
		return descLabel;
	}

	protected void update() {
		activity = WorkFactory.create(activity.getId(), DateUtil.parse(dateField.getText()), activity.getPerson()
				,Integer.valueOf(timeField.getText()), (TaskType)taskTypeComboBox.getSelectedItem(), nameField.getText()
				, (ReleaseType)releaseTypeComboBox.getSelectedItem(), descField.getText());
	}


	protected void ok() {
		update();
		if(!validateData())
			return;
		try{
			if(activity.getId()==-1) {
				ActivityHandler.insert(activity);
			}else {
				ActivityHandler.update(activity);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		parent.refresh();
	}
}