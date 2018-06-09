package ru.rrozhkov.easykin.service.calc.impl.convert;

import java.util.Collection;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.impl.PaymentFactory;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.CalculatorFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.convert.IConverter;

public class ServiceCalcConverter implements
		IConverter<Collection<ServiceCalc>, Collection<IPayment>> {
	private static final CalculatorFactory calculatorFactory = new CalculatorFactory();
	final private static PaymentFactory paymentFactory = new PaymentFactory();
	public Collection<IPayment> convert(Collection<ServiceCalc> entries) {
		Collection<IPayment> payments = CollectionUtil.create();
		for(ServiceCalc calc : entries){
			for(ICalculation c : calc.calcs()){
				payments.add(
						paymentFactory.createServiceCalcPayment(
							calc.getName()+" "+c.getType()
							, calculatorFactory.getCalculator(c).calculate().getResult()
							, calc.getDate(), c.isPaid())
					);
			}
		}
		return payments;
	}

}
