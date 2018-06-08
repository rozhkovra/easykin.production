package ru.rrozhkov.easykin.work.gui;

import ru.rrozhkov.easykin.model.person.util.PersonUtil;
import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.easykin.model.work.ReleaseType;
import ru.rrozhkov.easykin.model.work.TaskType;
import ru.rrozhkov.easykin.model.work.impl.WorkFactory;
import ru.rrozhkov.easykin.work.service.impl.ActivityService;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.gui.Form;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.util.DateUtil;

import javax.swing.*;
import java.awt.*;

public class ActivityForm extends Form {
	private static final long serialVersionUID = 1L;
	private static final WorkFactory workFactory = WorkFactory.instance();
	private static final ActivityService activityService = ActivityService.instance();

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

	public ActivityForm(IGUIEditor parent, IActivity activity) {
		super(parent);
		this.activity = activity;
		fill();
	}
	
	protected void fill(){
		setLayout(guiFactory.gridLayout(9, 2));
		add(guiFactory.labelEmpty());
		add(guiFactory.labelEmpty());
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
			releaseTypeComboBox = (JComboBox) guiFactory.comboBoxFilled(CollectionUtil.create(
					ReleaseType.R800,
					ReleaseType.R810,
					ReleaseType.R900,
					ReleaseType.R901,
					ReleaseType.R1000,
					ReleaseType.R1100,
					ReleaseType.R1200,
					ReleaseType.R1210,
					ReleaseType.R1400,
					ReleaseType.R1500,
					ReleaseType.NORELEASE,
					ReleaseType.ANOTHER
			));
			releaseTypeComboBox.setSelectedItem(activity.getReleaseType());
		}
		return releaseTypeComboBox;
	}

	private Component getReleaseTypeLabel() {
		if(releaseTypeLabel == null){
			releaseTypeLabel = guiFactory.label("Номер релиза");
		}
		return releaseTypeLabel;
	}

	private JComboBox getTaskTypeComboBox(){
		if(taskTypeComboBox == null){
			taskTypeComboBox = (JComboBox) guiFactory.comboBoxFilled(CollectionUtil.create(
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
			));
			taskTypeComboBox.setSelectedItem(activity.getTaskType());
		}
		return taskTypeComboBox;
	}

	private Component getTaskTypeLabel() {
		if(taskTypeLabel == null){
			taskTypeLabel = guiFactory.label("Тип задачи");
		}
		return taskTypeLabel;
	}

	private JTextField getTimeField() {
		if(timeField == null){
			timeField = (JTextField) guiFactory.fieldEditable(2, String.valueOf(activity.getTime()));
		}
		return timeField;
	}

	private Component getTimeLabel() {
		if(timeLabel == null){
			timeLabel = guiFactory.label("Время");
		}
		return timeLabel;
	}

	private JTextField getPersonField() {
		if(personField == null){
			personField = (JTextField) guiFactory.fieldEditable(10, PersonUtil.fi(activity.getPerson()));
		}
		return personField;
	}

	private Component getPersonLabel() {
		if(personLabel == null){
			personLabel = guiFactory.label("Имя");
		}
		return personLabel;
	}

	private JTextField getDateField() {
		if(dateField == null){
			dateField = (JTextField) guiFactory.fieldEditable(10, DateUtil.format(activity.getDate()));
		}
		return dateField;
	}

	private Component getDateLabel() {
		if(dateLabel == null){
			dateLabel = guiFactory.label("Дата");
		}
		return dateLabel;
	}

	private JTextField getNameField(){
		if(nameField == null){
			nameField = (JTextField) guiFactory.fieldEditable(50, activity.getName());
		}
		return nameField;
	}

	private Component getNameLabel(){
		if(nameLabel == null)
			nameLabel = guiFactory.label("Имя");
		return nameLabel;
	}

	private JTextField getDescField(){
		if(descField == null){
			descField = (JTextField) guiFactory.fieldEditable(50, activity.getDesc());
		}
		return descField;
	}

	private Component getDescLabel(){
		if(descLabel == null)
			descLabel = guiFactory.label("Комментарий");
		return descLabel;
	}

	protected void update() {
		activity = workFactory.create(activity.getId(), DateUtil.parse(dateField.getText()), activity.getPerson()
				,Integer.valueOf(timeField.getText()), (TaskType)taskTypeComboBox.getSelectedItem(), nameField.getText()
				, (ReleaseType)releaseTypeComboBox.getSelectedItem(), descField.getText());
	}


	protected void ok() {
		update();
		if(!validateData())
			return;
		activityService.createOrUpdate(activity);
		parent.refresh();
	}
}