package ru.rrozhkov.easykin.gui.task;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.db.impl.CommentHandler;
import ru.rrozhkov.easykin.gui.Form;
import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;

import javax.swing.*;
import java.awt.*;

public class CommentForm extends Form {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private Component textLabel;
	private IComment comment;
	private MasterDataContext context;

	public CommentForm(MasterDataContext context, IGUIEditor parent, int taskId) {
		this(context, parent, TaskFactory.newComment(taskId));
	}

	public CommentForm(MasterDataContext context, IGUIEditor parent, IComment comment) {
		super(parent);
		this.context = context;
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
		context.init();
		parent.refresh();
	}

	protected boolean validateData() {
		return !"".equals(comment.getText());
	}

}