package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.gui.style.ICollectionConverter;
import ru.rrozhkov.easykin.gui.style.IStyle;
import ru.rrozhkov.easykin.gui.style.ITableStyle;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;

public class PaymentStyle implements IStyle<IPayment> {

	public ITableStyle<IPayment> tableStyle() {
		return new PaymentTableStyle();
	}

	public ICollectionConverter<IPayment> dataConverter() {
		return new PaymentConverter(tableStyle().getColumnCount());
	}
}
