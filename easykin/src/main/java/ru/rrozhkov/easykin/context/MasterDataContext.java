package ru.rrozhkov.easykin.context;

import ru.rrozhkov.easykin.auth.AuthManager;
import ru.rrozhkov.easykin.data.impl.PaymentDataProvider;
import ru.rrozhkov.easykin.data.impl.stat.StaticServiceCalcDataProvider;
import ru.rrozhkov.easykin.data.impl.stat.StaticServiceHistoryDataProvider;
import ru.rrozhkov.easykin.db.impl.CategoryHandler;
import ru.rrozhkov.easykin.db.impl.KinPersonHandler;
import ru.rrozhkov.easykin.db.impl.PersonHandler;
import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.doc.IDoc;
import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.family.KinType;
import ru.rrozhkov.easykin.model.family.impl.filter.KinFilterFactory;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;
import ru.rrozhkov.easykin.model.fin.payment.impl.filter.PaymentFilterFactory;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.TaskBuilder;
import ru.rrozhkov.easykin.model.task.impl.filter.TaskFilterFactory;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.data.impl.SingleCollectionDataProvider;
import ru.rrozhkov.lib.filter.IFilter;
import ru.rrozhkov.lib.filter.util.FilterUtil;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MasterDataContext implements IContext{
	private Collection<ICategory> categories;
	private Collection<ITask> tasks;
	private Collection<IPerson> persons;
	private Collection<IKinPerson> kinPersons;
	private Collection<IPayment> payments;
	private Collection<IService> services;
	private Collection<ServiceCalc> calcServices;
	private Collection<IDoc> docs;
	private ICar car;
	private Map<Integer, Collection> categoryData = new HashMap<Integer, Collection>();
	private Collection<IFilter> filters = CollectionUtil.create();
	private ICategory currentCategory;

	public MasterDataContext() {
	}
	
	public void init(){
		IPerson person = AuthManager.instance().signedPerson();
		try{
			SingleCollectionDataProvider<IService, ICar> autoProvider = new StaticServiceHistoryDataProvider();
			this.categories = CategoryHandler.select();
			if(person!=null)
				this.tasks = TaskBuilder.build(person.getId());
			else
				this.tasks = TaskBuilder.build();
			this.persons = PersonHandler.select();
			this.kinPersons = KinPersonHandler.select();
			this.car = autoProvider.getSingleData();
			this.services = autoProvider.getData();
			this.calcServices = new StaticServiceCalcDataProvider().getData();
			this.payments = new PaymentDataProvider(this).getData();
			this.docs = CollectionUtil.create();
		}catch(SQLException e){
			e.printStackTrace();
		}
		initCategoryData();
	}

	public void chooseCategory(ICategory category) {
		this.currentCategory = category;
	}

	public ICategory currentCategory(){
		return this.currentCategory;
	}

	private void initCategoryData() {
		categoryData.clear();
		for(ICategory category : categories){
			Integer categoryId = category.getId();
			if(categoryId==1){
				categoryData.put(categoryId, FilterUtil.filter(FilterUtil.filter(tasks(), TaskFilterFactory.home()), filters));
			}else if(categoryId==2){
				categoryData.put(categoryId, kids());
			}else if(categoryId==3){
				categoryData.put(categoryId, kinPersons());
			}else if(categoryId==4){
				categoryData.put(categoryId, services());
			}else if(categoryId==5){
				categoryData.put(categoryId, finance());
			}else if(categoryId==6){
				categoryData.put(categoryId, factPayments());
			}else if(categoryId==7){
				categoryData.put(categoryId, docs());
			}else if(categoryId==8){
				categoryData.put(categoryId, FilterUtil.filter(FilterUtil.filter(tasks(), TaskFilterFactory.work()), filters));
			}else if(categoryId==9){
				categoryData.put(categoryId, FilterUtil.filter(tasks(), filters));
			}else if(categoryId==10){
				categoryData.put(categoryId, calcs());
			}
		}
	}

	public Collection docs() {
		return docs;
	}

	public Collection dataForCategory(int categoryId){
		return categoryData.get(Integer.valueOf(categoryId));
	}
	
	public Object getObjByIndex(int index){
		return CollectionUtil.<ICategory>get(categoryData.get(currentCategory().getId()),index);
	}


	public Collection<ICategory> categories() {
		return categories;
	}

	public Collection<ITask> tasks() {
		return tasks;
	}
	
	public Priority[] priorities(){
		return new Priority[]{
			Priority.IMPOTANT_FAST,
			Priority.IMPOTANT_NOFAST,
			Priority.SIMPLE
			};
	}

	public Status[] statuses(){
		return new Status[]{
				Status.OPEN,
				Status.CLOSE
			};
	}

	public Collection<IPerson> persons() {
		return persons;
	}

	public Collection<IKinPerson> kinPersons() {
		return kinPersons;
	}

	public Collection<IKinPerson> kids() {
		return FilterUtil.filter(kinPersons(), KinFilterFactory.create(new KinType[]{KinType.SUN, KinType.DAUGHTER}));
	}

	public Collection<IPayment> payments() {
		return payments;
	}

	public Collection<IPayment> finance() {
		return FilterUtil.filter(payments(), PaymentFilterFactory.status(PaymentStatus.PLAN), PaymentFilterFactory.noFree());
	}

	public Collection<IPayment> factPayments() {
		return FilterUtil.filter(payments(), PaymentFilterFactory.status(PaymentStatus.FACT), PaymentFilterFactory.noFree());
	}

	public Collection<IService> services() {
		return services;
	}

	public ICar car() {
		return car;
	}

	public Collection<ServiceCalc> calcs() {
		return calcServices;
	}

	public void filter(Collection<IFilter> filters){
		this.filters.clear();
		this.filters.addAll(filters);
	}
}