package ru.rrozhkov.easykin.task.gui;

import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.task.impl.filter.TaskFilterFactory;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.filter.IFilter;
import ru.rrozhkov.lib.gui.Form;
import ru.rrozhkov.lib.gui.IGUIEditor;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class TaskFilter extends Form {
	private static final long serialVersionUID = 1L;
	private JComboBox priorityComboBox;
	private JComboBox statusComboBox;
	private Component priorityLabel;
	private Component statusLabel;

	public TaskFilter(IGUIEditor parent){
		super(parent);
		fill();
	}
	
	protected void fill(){
		setLayout(new GridLayout(3, 2));
		add(getPriorityLabel()); 
		add(getPriorityComboBox()); 
		add(getStatusLabel());
		add(getStatusComboBox());
		add(getOkButton());
		add(getCancelButton());
	}
	
	private Component getPriorityComboBox(){
		if(priorityComboBox == null){
			priorityComboBox = guiFactory.comboBoxFilled(CollectionUtil.create(
					Priority.IMPOTANT_FAST,
					Priority.IMPOTANT_NOFAST,
					Priority.SIMPLE
			));
		}
		return priorityComboBox;
	}
	
	private Component getStatusComboBox(){
		if(statusComboBox == null){
			statusComboBox = guiFactory.comboBoxFilled(CollectionUtil.create(
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
//		EasyKinContext easyKinContext = (EasyKinContext) context;
		Collection<IFilter> filters = CollectionUtil.create();
			if(statusComboBox.getSelectedIndex()!=0)
				filters.add(TaskFilterFactory.status(Status.status(statusComboBox.getSelectedIndex())));
			if(priorityComboBox.getSelectedIndex()!=0)
				filters.add(TaskFilterFactory.priority(Priority.priority(priorityComboBox.getSelectedIndex())));
//			easyKinContext.masterData().filter(filters);
		parent.refresh();
		parent.closeEditor(IGUIEditor.CODE_OK);
	}
}