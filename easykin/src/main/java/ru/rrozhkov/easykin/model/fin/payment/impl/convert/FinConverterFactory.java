package ru.rrozhkov.easykin.model.fin.payment.impl.convert;

import java.util.Collection;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.auto.service.impl.convert.ServiceConverter;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.convert.ServiceCalcConverter;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.impl.convert.TaskPaymentConverter;
import ru.rrozhkov.lib.convert.IConverter;

public class FinConverterFactory {
	public static IConverter<Collection<IService>,Collection<IPayment>> createServiceConverter(){
		return new ServiceConverter();
	}
	public static IConverter<Collection<ServiceCalc>,Collection<IPayment>> createServiceCalcConverter(){
		return new ServiceCalcConverter();
	}
	public static IConverter<Collection<ITask>,Collection<IPayment>> createTaskConverter(){
		return new TaskPaymentConverter();
	}
}