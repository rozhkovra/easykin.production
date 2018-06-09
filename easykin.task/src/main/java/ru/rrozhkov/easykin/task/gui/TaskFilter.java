package ru.rrozhkov.easykin.task.gui;

import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.task.impl.filter.TaskFilterFactory;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.filter.IFilter;
import ru.rrozhkov.easykin.core.gui.Form;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class TaskFilter extends Form {
	private static final long serialVersionUID = 1L;
	final private static TaskFilterFactory taskFilterFactory = TaskFilterFactory.instance();

	private JComboBox priorityComboBox;
	private JComboBox statusComboBox;
	private Component priorityLabel;
	private Component statusLabel;

	public TaskFilter(IGUIEditor parent){
		super(parent);
		fill();
	}
	
	protected void fill(){
		setLayout(guiFactory.gridLayout(3, 2));
		add(getPriorityLabel()); 
		add(getPriorityComboBox()); 
		add(getStatusLabel());
		add(getStatusComboBox());
		add(getOkButton());
		add(getCancelButton());
	}
	
	private Component getPriorityComboBox(){
		if(priorityComboBox == null){
			priorityComboBox = (JComboBox)guiFactory.comboBoxFilled(CollectionUtil.create(
					Priority.IMPOTANT_FAST,
					Priority.IMPOTANT_NOFAST,
					Priority.SIMPLE
			));
		}
		return priorityComboBox;
	}
	
	private Component getStatusComboBox(){
		if(statusComboBox == null){
			statusComboBox = (JComboBox)guiFactory.comboBoxFilled(CollectionUtil.create(
					Status.OPEN,
					Status.CLOSE
			));
		}
		return statusComboBox;
	}

	private Component getPriorityLabel(){
		if(priorityLabel == null)
			priorityLabel = guiFactory.label("Приоритет");
		return priorityLabel;
	}

	private Component getStatusLabel(){
		if(statusLabel == null)
			statusLabel = guiFactory.label("Статус");
		return statusLabel;
	}

	protected void ok() {
		Collection<IFilter> filters = CollectionUtil.create();
		if(statusComboBox.getSelectedIndex()!=0)
			filters.add(taskFilterFactory.status(Status.status(statusComboBox.getSelectedIndex())));
		if(priorityComboBox.getSelectedIndex()!=0)
			filters.add(taskFilterFactory.priority(Priority.priority(priorityComboBox.getSelectedIndex())));
		parent.closeEditor(IGUIEditor.CODE_OK);
		parent.refresh();
	}
}