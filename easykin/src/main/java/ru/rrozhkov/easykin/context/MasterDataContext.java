package ru.rrozhkov.easykin.context;

public class MasterDataContext{
	private String module;

	public MasterDataContext() {
	}
	
	public void chooseModule(String module) {
		this.module = module;
	}

	public String currentModule(){
		return this.module;
	}
}