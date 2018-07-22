package ru.rrozhkov.easykin.service.calc.impl.util;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.service.CalculatorFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.calc.impl.filter.ServiceCalcFilterFactory;
import ru.rrozhkov.easykin.core.filter.util.FilterUtil;

import java.util.Collection;

public class ServiceCalcUtil {
	private static final ServiceCalcFilterFactory filterFactory = ServiceCalcFilterFactory.instance();
	private static final CalculatorFactory calculatorFactory = CalculatorFactory.instance();

	public static ICalculation getCalcByType(ServiceCalc entry, CalculationType type){
		return getCalcByType(entry.calcs(), type);
	}

	public static ICalculation getCalcByType(Collection<ICalculation> calcs, CalculationType type){
		Collection<ICalculation> calcsByType = FilterUtil.filter(calcs
				, filterFactory.createCalcTypeFilter(type));
		return CollectionUtil.get(calcsByType, 0);
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