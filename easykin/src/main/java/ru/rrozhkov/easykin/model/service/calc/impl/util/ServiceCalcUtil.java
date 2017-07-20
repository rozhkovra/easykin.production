package ru.rrozhkov.easykin.model.service.calc.impl.util;

import static ru.rrozhkov.easykin.model.service.calc.impl.CalculatorFactory.getCalculator;

import java.util.Collection;
import java.util.List;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.filter.ServiceCalcFilterFactory;
import ru.rrozhkov.lib.filter.util.FilterUtil;

public class ServiceCalcUtil {
	public static ICalculation getCalcByType(ServiceCalc entry, CalculationType type){
		Collection<ICalculation> calcs = FilterUtil.filter(entry.calcs()
				, ServiceCalcFilterFactory.createCalcTypeFilter(type));
		if(calcs.size()==0)
			return null;
		return ((List<ICalculation>)calcs).get(0);
	}
	
	public static Money getPaidSum(ServiceCalc entry){
		Money sum = MoneyFactory.create();
		for(ICalculation calc : entry.calcs()){
			if(calc.isPaid())
				sum.add(getCalculator(calc).calculate().getResult());
		}
		return sum;
	}
	
	public static Money getNoPaidSum(ServiceCalc entry){
		Money sum = MoneyFactory.create();
		for(ICalculation calc : entry.calcs()){
			if(!calc.isPaid())
				sum.add(getCalculator(calc).calculate().getResult());
		}
		return sum;
	}
}