package ru.rrozhkov.easykin.task.gui;


import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.task.impl.TaskBuilder;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.util.GuiUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskEditor extends JPanel implements IGUIEditor{
	private ITask task;
	private IGUIEditor parent;
	private Component addButton;

	public TaskEditor(IGUIEditor parent, ITask task) {
		super();
		this.task = task;
		this.parent = parent;
		fill();
	}
	public TaskEditor(IGUIEditor parent) {
		this(parent, null);
	}

	private void fill(){
		removeAll();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(GUIFactory.createTaskForm(parent, task));
		add(getAddButton());
		getAddButton().setEnabled(true);
		if(task!=null)
			add(GUIFactory.createTaskCommentPanel(this, task.comments()));
		validate();
	}

	public void edit(Object obj){
		if(getComponentCount()>3)
			return;
		if(task==null)
			return;
		IComment comment = null;
		if (obj!=null)
			comment = (IComment)obj;
		add(GUIFactory.createCommentForm(this, comment, task.getId()));
		getAddButton().setEnabled(false);
		validate();
	}

	public void add() {
		edit(null);
	}

	public void closeEditor(int code) {
		if(getComponentCount()<4)
			return;
		Component form = getComponent(3);
		remove(form);
		getAddButton().setEnabled(true);
		validate();
	}

	public void refresh() {
		if(task!=null) {
			task = TaskBuilder.buildTask(task.getId());
			fill();
		}
	}

	private Component getAddButton(){
		if(addButton==null){
			addButton = GuiUtil.button("Добавить", new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					add();
				}
			});
			if(task!=null && task.getStatus().isClose())
				getAddButton().setEnabled(false);
		}
		return addButton;
	}
}
