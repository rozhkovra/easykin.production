package ru.rrozhkov.easykin.task.gui;


import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.task.gui.comment.CommentGUIFactory;
import ru.rrozhkov.easykin.task.impl.TaskBuilder;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;
import ru.rrozhkov.lib.gui.util.SwingGuiFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskEditor extends JPanel implements IGUIEditor{
	private ITask task;
	private IGUIEditor parent;
	private Component addButton;
	private static TaskBuilder taskBuilder = new TaskBuilder();
	private final static IGUIFactory guiFactory = new SwingGuiFactory();

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
		add(new TaskGUIFactory().createTaskForm(parent, task));
		add(getAddButton());
		getAddButton().setEnabled(true);
		if(task!=null)
			add(new CommentGUIFactory().createTablePanel(this, task.comments()));
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
		add(new CommentGUIFactory().createEditor(this, comment, task.getId()));
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
			task = taskBuilder.buildTask(task.getId());
			fill();
		}
	}

	private Component getAddButton(){
		if(addButton==null){
			addButton = guiFactory.button("Добавить", new ActionListener() {
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
