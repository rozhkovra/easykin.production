package ru.rrozhkov.easykin.ws;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.module.Module;
import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.easykin.task.db.impl.CategoryHandler;
import ru.rrozhkov.easykin.ws.bean.CategoryBean;
import ru.rrozhkov.easykin.ws.bean.PaymentBean;
import ru.rrozhkov.easykin.ws.bean.PersonBean;
import ru.rrozhkov.easykin.ws.bean.TaskBean;
import ru.rrozhkov.easykin.ws.convert.WSConverterFactory;
import ru.rrozhkov.lib.collection.CollectionUtil;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Collection;

@WebService(serviceName="EasyKin", portName="EasyKinPort", targetNamespace="http://rrozhkov.ru/easykin")
public class EasyKinService {

	@WebMethod
	public Collection<CategoryBean> categories() {
		Collection<CategoryBean> beans = CollectionUtil.create();
		try {
			for(ICategory category : CategoryHandler.select()){
                beans.add(WSConverterFactory.category().convert(category));
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beans;
	}
	@WebMethod
	public Collection<PersonBean> persons() {
		Collection<PersonBean> beans = CollectionUtil.create();
		for(IPerson person : (Collection<IPerson>)ModuleManager.invoke(Module.PERSON, "persons")){
			beans.add(WSConverterFactory.person().convert(person));
		}
		return beans;
	}
	@WebMethod
	public Collection<TaskBean> tasks(IPerson person) {
		Collection<TaskBean> beans = CollectionUtil.create();
		for(ITask task : (Collection<ITask>)ModuleManager.invoke(Module.TASK, "tasks", person)){
			beans.add(WSConverterFactory.task().convert(task));
		}
		return beans;
	}
	@WebMethod
	public Collection<PaymentBean> payments() {
		Collection<PaymentBean> beans = CollectionUtil.create();
		for(IPayment payment : (Collection<IPayment>)ModuleManager.invoke(Module.PAYMENT, "finance")){
			beans.add(WSConverterFactory.payment().convert(payment));
		}
		return beans;
	}

	@WebMethod
	public int ping(){
		return 1;
	}
}
