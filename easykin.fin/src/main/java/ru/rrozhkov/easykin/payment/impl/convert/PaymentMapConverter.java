package ru.rrozhkov.easykin.payment.impl.convert;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentCategory;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;
import ru.rrozhkov.lib.convert.IConverter;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.HashMap;
import java.util.Map;

public class PaymentMapConverter implements IConverter<IPayment, Map<String, Object>> {

	public Map<String, Object> convert(IPayment payment) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", payment.getId());
		map.put("comment", payment.getComment());
		map.put("createdate", DateUtil.formatSql(payment.getDate()));
		map.put("categoryid", PaymentCategory.category(payment.getCategory()));
		map.put("statusid", PaymentStatus.status(payment.getStatus()));
		map.put("amount", payment.getAmount().getValue());
		return map;
	}

}
