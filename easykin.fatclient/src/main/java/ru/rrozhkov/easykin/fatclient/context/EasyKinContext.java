package ru.rrozhkov.easykin.fatclient.context;

import ru.rrozhkov.easykin.core.util.DateUtil;

public class EasyKinContext {
	public static class EasyKinContextHolder {
		public static final EasyKinContext INSTANCE = new EasyKinContext();
	}

	public static EasyKinContext instance(){
		return EasyKinContextHolder.INSTANCE;
	}

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