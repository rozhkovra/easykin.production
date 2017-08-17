package ru.rrozhkov.easykin.task.gui;

import ru.rrozhkov.easykin.task.db.impl.CommentHandler;
import ru.rrozhkov.lib.gui.Form;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;

import javax.swing.*;
import java.awt.*;

public class CommentForm extends Form {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private Component textLabel;
	private IComment comment;

	public CommentForm(IGUIEditor parent, int taskId) {
		this(parent, TaskFactory.newComment(taskId));
	}

	public CommentForm(IGUIEditor parent, IComment comment) {
		super(parent);
		this.comment = comment;
		fill();
	}
	
	protected void fill(){
		setLayout(new GridLayout(4, 2));
		add(GuiUtil.labelEmpty());
		add(GuiUtil.labelEmpty());
		add(getTextLabel());
		add(getTextField());
		add(getOkButton());
		add(getCancelButton());
	}

	private JTextField getTextField(){
		if(textField == null){
			textField = (JTextField)GuiUtil.fieldEditable(250, comment.getText());
		}
		return textField;
	}

	private Component getTextLabel(){
		if(textLabel == null)
			textLabel = GuiUtil.label("Текст");
		return textLabel;
	}

	protected void update() {
		comment = TaskFactory.createComment(comment.getId(), getTextField().getText(), comment.getDate(), comment.getTaskId());
	}

	protected void ok(){
		update();
		if(!validateData())
			return;
		try{
			if(comment.getId()==-1)
				CommentHandler.insert(comment);
			else
				CommentHandler.update(comment);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		parent.refresh();
	}

	protected boolean validateData() {
		return !"".equals(comment.getText());
	}

}