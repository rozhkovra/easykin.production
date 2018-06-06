package ru.rrozhkov.easykin.context;

import ru.rrozhkov.lib.util.DateUtil;

public class EasyKinContext {
	private String module;

	public static String title(){
		return "EasyKin, " + DateUtil.todayWeek();
	}

	public void setCurrentModule(String module) {
		this.module = module;
	}

	public String getCurrentModule(){
		return this.module;
	}
}