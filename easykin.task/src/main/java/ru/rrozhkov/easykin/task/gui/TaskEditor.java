package ru.rrozhkov.easykin.task.gui;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.task.gui.comment.CommentGUIFactory;
import ru.rrozhkov.easykin.task.impl.TaskBuilder;
import ru.rrozhkov.easykin.core.gui.GUIFactory;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IGUIFactory;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskEditor extends JPanel implements IGUIEditor{
	private final static TaskBuilder taskBuilder = TaskBuilder.instance();
	private final static TaskFactory taskFactory = TaskFactory.instance();
	private final static IGUIFactory guiFactory = GUIFactory.create();
	private final static TaskGUIFactory taskGUIFactory = TaskGUIFactory.instance();
	private final static CommentGUIFactory commentGUIFactory = CommentGUIFactory.instance();

	private ITask task;
	private IGUIEditor parent;
	private Component addButton;

	public static JPanel create(final IGUIEditor parent, final ITask task) {
		TaskEditor editor = new TaskEditor(parent, task);
		editor.fill();
		return editor;
	}

	private TaskEditor(IGUIEditor parent, ITask task) {
		super();
		this.task = task;
		this.parent = parent;
	}

	private void fill(){
		removeAll();
		setLayout(guiFactory.boxLayout(this, BoxLayout.Y_AXIS));
		add(taskGUIFactory.createTaskForm(parent, task));
		add(getAddButton());
		getAddButton().setEnabled(true);
		add(commentGUIFactory.createTablePanel(this, task.comments()));
		validate();
	}

	public void edit(Object obj){
		if(getComponentCount()>3)
			return;
		if (obj==null) {
			obj =  taskFactory.newComment(task.getId());
		}
		IComment comment = (IComment)obj;
		add(commentGUIFactory.createEditor(this, comment));
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
