package ru.rrozhkov.easykin.gui.task;

import ru.rrozhkov.easykin.context.EasyKinContext;
import ru.rrozhkov.easykin.context.IContext;
import ru.rrozhkov.easykin.gui.Form;
import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.filter.PriorityFilter;
import ru.rrozhkov.easykin.model.task.impl.filter.StatusFilter;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.filter.IFilter;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class TaskFilter extends Form {
	private static final long serialVersionUID = 1L;
	private JComboBox priorityComboBox;
	private JComboBox statusComboBox;
	private Component priorityLabel;
	private Component statusLabel;
	private IContext context;

	public TaskFilter(IContext context, IGUIEditor parent){
		super(parent);
		this.context = context;
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
	
	private JComboBox getPriorityComboBox(){
		if(priorityComboBox == null){
			priorityComboBox = new JComboBox();
			priorityComboBox.addItem("----");
			for(Priority priority : ((EasyKinContext)context).masterData().priorities()){
				priorityComboBox.addItem(priority);
			}

		}
		return priorityComboBox;
	}
	
	private JComboBox getStatusComboBox(){
		if(statusComboBox == null){
			statusComboBox = new JComboBox();
			statusComboBox.addItem("----");
			for(Status status : ((EasyKinContext)context).masterData().statuses()){
				statusComboBox.addItem(status);
			}
		}
		return statusComboBox;
	}

	private Component getPriorityLabel(){
		if(priorityLabel == null)
			priorityLabel = GuiUtil.label("Приоритет");
		return priorityLabel;
	}

	private Component getStatusLabel(){
		if(statusLabel == null)
			statusLabel = GuiUtil.label("Статус");
		return statusLabel;
	}

	protected void ok() {
		if(context!=null) {
			EasyKinContext easyKinContext = (EasyKinContext) context;
			Collection<IFilter> filters = CollectionUtil.create();
			if(statusComboBox.getSelectedIndex()!=0)
				filters.add(new StatusFilter(Status.status(statusComboBox.getSelectedIndex())));
			if(priorityComboBox.getSelectedIndex()!=0)
				filters.add(new PriorityFilter(Priority.priority(priorityComboBox.getSelectedIndex())));
			easyKinContext.masterData().filter(filters);
		}
		parent.refresh();
		parent.closeEditor(IGUIEditor.CODE_OK);
	}
}