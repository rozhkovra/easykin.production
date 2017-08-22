package ru.rrozhkov.easykin.gui.util;

import ru.rrozhkov.lib.util.DateUtil;

import javax.swing.*;

public class ContextUtil {
	public static String getCurrentModule(JTabbedPane tabs){
		int index = tabs.getSelectedIndex();
		if(index==-1)
			return null;
		return tabs.getTitleAt(index);
	}

	public static String title(){
		return "EasyKin, " + DateUtil.todayWeek();
	}
}