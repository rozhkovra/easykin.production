package ru.rrozhkov.easykin.model.task.impl.convert;

import java.util.Collection;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.impl.PaymentFactory;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.impl.filter.TaskFilterFactory;
import ru.rrozhkov.easykin.model.task.util.TaskUtil;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.convert.IConverter;
import ru.rrozhkov.lib.filter.util.FilterUtil;

public class TaskPaymentConverter implements IConverter<Collection<ITask>,Collection<IPayment>> {
	public Collection<IPayment> convert(Collection<ITask> entries) {
		Collection<IPayment> collection = CollectionUtil.<IPayment>create();
		entries = FilterUtil.<ITask>filter(entries, TaskFilterFactory.withPayment());
		for(ITask task : entries){
			collection.add(new SingleConverter().convert(task));
		}
		return collection;
	}
	
	class SingleConverter implements IConverter<ITask, IPayment> {
		public IPayment convert(ITask entry) {
			return PaymentFactory.createTaskPayment(entry.getName(),TaskUtil.extractAmount(entry),entry.getStatus().isClose()?entry.getCloseDate():entry.getPlanDate(),entry.getStatus());
		}
	}
}