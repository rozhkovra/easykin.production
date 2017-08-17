package ru.rrozhkov.easykin.context;

import ru.rrozhkov.easykin.data.impl.PaymentDataProvider;
import ru.rrozhkov.easykin.fin.payment.impl.filter.PaymentFilterFactory;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.doc.IDoc;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;
import ru.rrozhkov.easykin.task.db.impl.CategoryHandler;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.filter.util.FilterUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MasterDataContext implements IContext{
	private Collection<ICategory> categories;
	private Collection<IPayment> payments;
	private Collection<IDoc> docs;
	private Map<Integer, Collection> categoryData = new HashMap<Integer, Collection>();
	private ICategory currentCategory;

	public MasterDataContext() {
	}
	
	public void init(){
		try{
			this.categories = CategoryHandler.select();
			this.payments = new PaymentDataProvider().getData();
			this.docs = CollectionUtil.create();
		}catch(Exception e){
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
			if(categoryId==5){
				categoryData.put(categoryId, finance());
			}else if(categoryId==6){
				categoryData.put(categoryId, factPayments());
			}else if(categoryId==7){
				categoryData.put(categoryId, docs());
			}
		}
	}

	public Collection docs() {
		return docs;
	}

	public Collection dataForCategory(int categoryId){
		return categoryData.get(Integer.valueOf(categoryId));
	}

	public Collection<ICategory> categories() {
		return categories;
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
}