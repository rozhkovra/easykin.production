package ru.rrozhkov.easykin.auto.report.service;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.auto.service.IServiceHistory;
import ru.rrozhkov.easykin.model.auto.service.util.RepairUtil;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.lib.filter.util.FilterUtil;

public class RepairServiceReporter extends ServiceReporter {

	public RepairServiceReporter(IServiceHistory history) {
		super(history);
	}

	public Money getDetailsSum() {
		Money value = Money.valueOf(0.00);
		for(IService service : FilterUtil.<IService>filter(history.getServices(), filters)){
			value.add(RepairUtil.getDetailsPrice(service));
		}						
		return value;
	}
	
	protected String getReportHeader(){
		return "Отчет по услугам c деталями.";
	}

	protected String getReportFooter(){
		return "Итого услуг на: "+getSum()+"\nИтого запчастей на: "+getDetailsSum()+"\nИтого: "+getSum().add(getDetailsSum());
	}

}