package ru.rrozhkov.easykin.context;

public class EasyKinContext {
	private String module;

	public EasyKinContext() {
	}
	
	public void setCurrentModule(String module) {
		this.module = module;
	}

	public String getCurrentModule(){
		return this.module;
	}
}