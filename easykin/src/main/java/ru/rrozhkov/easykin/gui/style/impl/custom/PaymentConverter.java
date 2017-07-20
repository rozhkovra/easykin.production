package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.gui.style.impl.CollectionConverter;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.lib.util.DateUtil;

public class PaymentConverter extends CollectionConverter<IPayment> {
	public PaymentConverter(int colSize) {
		super(colSize);
	}

	public String[] convert(int i, IPayment entry) {
		return new String[]{String.valueOf(i), entry.getCategory().toString(), entry.getComment(), entry.getAmount().toString(), DateUtil.format(entry.getDate())};
	}
}