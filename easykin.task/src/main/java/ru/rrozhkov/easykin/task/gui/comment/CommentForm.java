package ru.rrozhkov.easykin.task.gui.comment;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.task.service.impl.CommentService;
import ru.rrozhkov.easykin.core.gui.Form;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;

import javax.swing.JTextField;
import java.awt.Component;

public class CommentForm extends Form {
	private static final long serialVersionUID = 1L;
	private static final CommentService commentService = CommentService.instance();
	private static final TaskFactory taskFactory = TaskFactory.instance();

	private JTextField textField;
	private Component textLabel;
	private IComment comment;

	public static Form create(final IGUIEditor parent, final IComment comment) {
		Form form = new CommentForm(parent, comment);
		form.fill();
		return form;
	}

	private CommentForm(IGUIEditor parent, IComment comment) {
		super(parent);
		this.comment = comment;
	}
	
	public void fill(){
		setLayout(guiFactory.gridLayout(4, 2));
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
		commentService.createOrUpdate(comment);
		parent.refresh();
	}

	protected boolean validateData() {
		return !"".equals(comment.getText());
	}
}