package ru.rrozhkov.easykin.auto.report.service;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.auto.service.IServiceHistory;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.core.filter.util.FilterUtil;
import ru.rrozhkov.easykin.core.report.impl.FilteredReporter;

public class ServiceReporter extends FilteredReporter {
	protected IServiceHistory history;

	public ServiceReporter(IServiceHistory history) {
		this.history = history;		
	}
	
	public Money getSum() {
		Money value = Money.valueOf(0.00);
		for(IService service : FilterUtil.<IService>filter(history.getServices(), filters)){
			value.add(service.getPrice());
		}						
		return value;
	}
	
	public String getReport(){
		return "\n"+getReportHeader()+"\n"+FilterUtil.filter(history.getServices(), filters)+"\n"+getReportFooter()+"\n";
	}
	
	protected String getReportHeader(){
		return "Отчет по услугам.";
	}

	protected String getReportFooter(){
		return "Итого услуг на: "+getSum();
	}
}