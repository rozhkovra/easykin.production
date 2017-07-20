package ru.rrozhkov.easykin.report.auto.service.impl;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.auto.service.IServiceHistory;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.lib.filter.util.FilterUtil;
import ru.rrozhkov.lib.report.impl.FilteredReporter;

public class ServiceReporter extends FilteredReporter {
	protected IServiceHistory history;

	public ServiceReporter(IServiceHistory history) {
		this.history = history;		
	}
	
	public Money getSum() {
		Money value = MoneyFactory.create();
		for(IService service : FilterUtil.<IService>filter(history.getServices(), filters)){
			value.add(service.getPrice());
		}						
		return value;
	}
	
	public String getReport(){
		return "\n"+getReportHeader()+"\n"+FilterUtil.filter(history.getServices(), filters)+"\n"+getReportFooter()+"\n";
	}
	
	protected String getReportHeader(){
		return "Отчет по у�?лугам.";
	}

	protected String getReportFooter(){
		return "Итого у�?луг на: "+getSum();
	}
}