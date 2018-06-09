package ru.rrozhkov.easykin.service.calc.impl.util;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.CalculatorFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.calc.impl.filter.ServiceCalcFilterFactory;
import ru.rrozhkov.easykin.core.filter.util.FilterUtil;

import java.util.List;

public class ServiceCalcUtil {
	private static final ServiceCalcFilterFactory filterFactory = new ServiceCalcFilterFactory();
	private static final CalculatorFactory calculatorFactory = new CalculatorFactory();

	public static ICalculation getCalcByType(ServiceCalc entry, CalculationType type){
		List<ICalculation> calcs = (List)FilterUtil.filter(entry.calcs()
				, filterFactory.createCalcTypeFilter(type));
		if(calcs.size()==0)
			return null;
		return calcs.get(0);
	}
	
	public static Money getPaidSum(ServiceCalc entry){
		Money sum = Money.valueOf(0.00);
		for(ICalculation calc : entry.calcs()){
			if(calc.isPaid())
				sum.add(calculatorFactory.getCalculator(calc).calculate().getResult());
		}
		return sum;
	}
	
	public static Money getNoPaidSum(ServiceCalc entry){
		Money sum = Money.valueOf(0.00);
		for(ICalculation calc : entry.calcs()){
			if(!calc.isPaid())
				sum.add(calculatorFactory.getCalculator(calc).calculate().getResult());
		}
		return sum;
	}
}