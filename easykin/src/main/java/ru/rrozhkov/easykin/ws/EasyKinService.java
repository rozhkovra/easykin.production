package ru.rrozhkov.easykin.ws;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.task.ITask;
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
		MasterDataContext context = new MasterDataContext();
		context.init();
		Collection<CategoryBean> beans = CollectionUtil.create();
		for(ICategory category : context.categories()){
			beans.add(WSConverterFactory.category().convert(category));
		}
		return beans;
	}
	@WebMethod
	public Collection<PersonBean> persons() {
		MasterDataContext context = new MasterDataContext();
		context.init();
		Collection<PersonBean> beans = CollectionUtil.create();
		for(IPerson person : context.persons()){
			beans.add(WSConverterFactory.person().convert(person));
		}
		return beans;
	}
	@WebMethod
	public Collection<TaskBean> tasks() {
		MasterDataContext context = new MasterDataContext();
		context.init();
		Collection<TaskBean> beans = CollectionUtil.create();
		for(ITask task : context.tasks()){
			beans.add(WSConverterFactory.task().convert(task));
		}
		return beans;
	}
	@WebMethod
	public Collection<PaymentBean> payments() {
		MasterDataContext context = new MasterDataContext();
		context.init();
		Collection<PaymentBean> beans = CollectionUtil.create();
		for(IPayment payment : context.payments()){
			beans.add(WSConverterFactory.payment().convert(payment));
		}
		return beans;
	}

	@WebMethod
	public int ping(){
		return 1;
	}
}
