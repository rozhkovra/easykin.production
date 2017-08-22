package ru.rrozhkov.easykin.context;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.task.db.impl.CategoryHandler;

import java.util.Collection;

public class MasterDataContext implements IContext{
	private Collection<ICategory> categories;
	private String module;

	public MasterDataContext() {
	}
	
	public void init(){
		try{
			this.categories = CategoryHandler.select();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void chooseModule(String module) {
		this.module = module;
	}

	public String currentModule(){
		return this.module;
	}

	public Collection<ICategory> categories() {
		return categories;
	}
}