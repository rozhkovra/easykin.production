package ru.rrozhkov.easykin.payment.impl.convert;

import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentCategory;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;
import ru.rrozhkov.easykin.model.fin.payment.impl.PaymentFactory;
import ru.rrozhkov.lib.convert.IConverter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBPaymentConverter implements IConverter<ResultSet,IPayment> {

	public IPayment convert(ResultSet result){
		try{
			return PaymentFactory.createPayment(result.getInt("id"), PaymentCategory.category(result.getInt("categoryid"))
					, result.getString("comment"), MoneyFactory.create(result.getDouble("amount"))
					, result.getDate("createdate"), PaymentStatus.status(result.getInt("statusid")));
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}