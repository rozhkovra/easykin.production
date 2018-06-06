package ru.rrozhkov.easykin.task.gui.comment;

import ru.rrozhkov.easykin.task.db.impl.CommentHandler;
import ru.rrozhkov.lib.gui.Form;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;

import javax.swing.*;
import java.awt.*;

public class CommentForm extends Form {
	private static final long serialVersionUID = 1L;
	private static final CommentHandler handler = new CommentHandler();
	private static final TaskFactory taskFactory = new TaskFactory();

	private JTextField textField;
	private Component textLabel;
	private IComment comment;

	public CommentForm(IGUIEditor parent, int taskId) {
		this(parent, taskFactory.newComment(taskId));
	}

	public CommentForm(IGUIEditor parent, IComment comment) {
		super(parent);
		this.comment = comment;
		fill();
	}
	
	protected void fill(){
		setLayout(new GridLayout(4, 2));
		add(guiFactory.labelEmpty());
		add(guiFactory.labelEmpty());
		add(getTextLabel());
		add(getTextField());
		add(getOkButton());
		add(getCancelButton());
	}

	private JTextField getTextField(){
		if(textField == null){
			textField = (JTextField) guiFactory.fieldEditable(250, comment.getText());
		}
		return textField;
	}

	private Component getTextLabel(){
		if(textLabel == null)
			textLabel = guiFactory.label("Текст");
		return textLabel;
	}

	protected void update() {
		comment = taskFactory.createComment(comment.getId(), getTextField().getText(), comment.getDate(), comment.getTaskId());
	}

	protected void ok(){
		update();
		if(!validateData())
			return;
		try{
			if(comment.getId()==-1)
				handler.insert(comment);
			else
				handler.update(comment);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		parent.refresh();
	}

	protected boolean validateData() {
		return !"".equals(comment.getText());
	}

}