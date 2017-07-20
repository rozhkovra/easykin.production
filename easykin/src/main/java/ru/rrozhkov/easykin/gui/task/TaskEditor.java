package ru.rrozhkov.easykin.gui.task;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.gui.EasyKinWindow;
import ru.rrozhkov.easykin.gui.FormFactory;
import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.gui.PanelFactory;
import ru.rrozhkov.easykin.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.impl.TaskBuilder;
import ru.rrozhkov.lib.collection.CollectionUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskEditor extends JPanel implements IGUIEditor{
	private ITask task;
	private MasterDataContext context;
	private EasyKinWindow parent;
	private Component addButton;

	public TaskEditor(MasterDataContext context, EasyKinWindow parent, ITask task) {
		super();
		this.task = task;
		this.context = context;
		this.parent = parent;
		fill();
	}
	public TaskEditor(MasterDataContext context, EasyKinWindow parent) {
		this(context, parent, null);
	}

	private void fill(){
		removeAll();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(FormFactory.createTaskForm(context, parent, task));
		add(getAddButton());
		getAddButton().setEnabled(true);
		if(task!=null)
			add(PanelFactory.createTaskCommentPanel(this, task.comments()));
		validate();
	}

	public void edit(int index){
		if(getComponentCount()>3)
			return;
		if(task==null)
			return;
		IComment comment =  null;
		if (task.comments().size()>0 && index!=-1)
			comment = CollectionUtil.get(task.comments(), index);
		add(FormFactory.createCommentForm(context, this, comment, task.getId()));
		getAddButton().setEnabled(false);
		validate();
	}

	public void add() {
		edit(-1);
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
