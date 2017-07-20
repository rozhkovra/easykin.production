package ru.rrozhkov.easykin.report.auto.service.impl;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.auto.service.IServiceHistory;
import ru.rrozhkov.easykin.model.auto.service.util.RepairUtil;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.lib.filter.util.FilterUtil;

public class RepairServiceReporter extends ServiceReporter {

	public RepairServiceReporter(IServiceHistory history) {
		super(history);
	}

	public Money getDetailsSum() {
		Money value = MoneyFactory.create();
		for(IService service : FilterUtil.<IService>filter(history.getServices(), filters)){
			value.add(RepairUtil.getDetailsPrice(service));
		}						
		return value;
	}
	
	protected String getReportHeader(){
		return "Отчет по у�?лугам c детал�?ми.";
	}

	protected String getReportFooter(){
		return "Итого у�?луг на: "+getSum()+"\nИтого запча�?тей на: "+getDetailsSum()+"\nИтого: "+getSum().add(getDetailsSum());
	}

}