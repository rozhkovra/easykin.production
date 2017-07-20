package ru.rrozhkov.easykin.model.service.calc.impl.convert;

import java.util.Collection;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.impl.PaymentFactory;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.CalculatorFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.convert.IConverter;

public class ServiceCalcConverter implements
		IConverter<Collection<ServiceCalc>, Collection<IPayment>> {

	public Collection<IPayment> convert(Collection<ServiceCalc> entries) {
		Collection<IPayment> payments = CollectionUtil.create();
		for(ServiceCalc calc : entries){
			for(ICalculation c : calc.calcs()){
				payments.add(
					PaymentFactory.createServiceCalcPayment(
							calc.getName()+" "+c.getType()
							, CalculatorFactory.getCalculator(c).calculate().getResult()
							, calc.getDate(), c.isPaid())
					);
			}
		}
		return payments;
	}

}
