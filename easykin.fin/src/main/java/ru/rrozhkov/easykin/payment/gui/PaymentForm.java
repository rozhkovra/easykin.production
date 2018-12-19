package ru.rrozhkov.easykin.payment.gui;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.gui.Form;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.service.IEntityService;
import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentCategory;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;
import ru.rrozhkov.easykin.model.fin.payment.impl.PaymentFactory;
import ru.rrozhkov.easykin.payment.db.impl.PaymentHandler;
import ru.rrozhkov.easykin.payment.service.impl.PaymentService;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Component;
import java.sql.SQLException;


public class PaymentForm extends Form {
	private static final long serialVersionUID = 1L;
	private static final PaymentFactory paymentFactory = PaymentFactory.instance();
	private static final IEntityService paymentService = PaymentService.instance();
	private JTextField commentField;
	private JTextField amountField;
	private JTextField dateField;
	private Component nameLabel;
	private Component priceLabel;
	private Component dateLabel;
	private IPayment payment;
	private JComboBox categoryComboBox;
	private Component categoryLabel;
	private JComboBox statusComboBox;
	private Component statusLabel;

	public static Form create(final IGUIEditor parent, final IPayment payment) {
		Form form = new PaymentForm(parent, payment);
		form.fill();
		return form;
	}

	private PaymentForm(IGUIEditor parent, IPayment payment) {
		super(parent);
		this.payment = payment;
	}
	
	public void fill(){
		setLayout(guiFactory.gridLayout(7,2));
		add(guiFactory.labelEmpty());
		add(guiFactory.labelEmpty());
		add(getCommentLabel()); 
		add(getCommentField()); 
		add(getAmountLabel()); 
		add(getAmountField()); 
		add(getDateLabel()); 
		add(getDateField());
		add(getCategoryLabel());
		add(getCategoryComboBox());
		add(getStatusLabel());
		add(getStatusComboBox());
		add(getOkButton());
		add(getCancelButton());
	}

	private JTextField getCommentField(){
		if(commentField == null){
			commentField = (JTextField)guiFactory.fieldEditable(50, payment.getComment());
		}
		return commentField;
	}

	private JTextField getAmountField(){
		if(amountField == null){
			amountField = (JTextField)guiFactory.fieldEditable(10, payment.getAmount().toString());
		}
		return amountField;
	}
	
	private JTextField getDateField(){
		if(dateField == null){
			dateField = (JTextField)guiFactory.fieldEditable(10, DateUtil.format(payment.getDate()));
		}
		return dateField;
	}
	
	private JComboBox getCategoryComboBox(){
		if(categoryComboBox == null){
			categoryComboBox = (JComboBox)guiFactory.comboBoxFilled(CollectionUtil.create(
					PaymentCategory.AUTO,
					PaymentCategory.SERVICE,
					PaymentCategory.PAYMENT,
					PaymentCategory.TASK
			));
			categoryComboBox.setSelectedItem(payment.getCategory());
		}
		return categoryComboBox;
	}

	private JComboBox getStatusComboBox(){
		if(statusComboBox == null){
			statusComboBox = (JComboBox)guiFactory.comboBoxFilled(CollectionUtil.create(
					PaymentStatus.PLAN,
					PaymentStatus.FACT
			));
			statusComboBox.setSelectedItem(payment.getStatus());
		}
		return statusComboBox;
	}
	
	private Component getCommentLabel(){
		if(nameLabel == null)
			nameLabel = guiFactory.label("Описание");
		return nameLabel;
	}
	
	private Component getAmountLabel(){
		if(priceLabel == null)
			priceLabel = guiFactory.label("Цена");
		return priceLabel;
	}
	
	private Component getDateLabel(){
		if(dateLabel == null)
			dateLabel = guiFactory.label("Дата");
		return dateLabel;
	}
	
	private Component getCategoryLabel(){
		if(categoryLabel == null)
			categoryLabel = guiFactory.label("Категория");
		return categoryLabel;
	}

	private Component getStatusLabel(){
		if(statusLabel == null)
			statusLabel = guiFactory.label("Статус");
		return statusLabel;
	}

	protected void update() {
		payment = paymentFactory.createPayment(payment.getId(), (PaymentCategory)getCategoryComboBox().getSelectedItem(),
				getCommentField().getText(), Money.valueOf(getAmountField().getText().replace(" ","")),
				DateUtil.parse(getDateField().getText()), (PaymentStatus)getStatusComboBox().getSelectedItem());
	}

	protected void ok() {
		update();
		if (!validateData()) {
			return;
		}
		paymentService.createOrUpdate(payment);
		parent.refresh();
	}
}