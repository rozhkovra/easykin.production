package ru.rrozhkov.easykin.gui.util;

import ru.rrozhkov.easykin.module.Module;
import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.lib.util.DateUtil;

import javax.swing.*;

public class ContextUtil {
	public static String getCurrentModule(JTabbedPane tabs){
		int index = tabs.getSelectedIndex();
		if(index==-1)
			return "";
		return Module.mod(tabs.getTitleAt(index));
	}
	public static int getCurrentTab(String module){
		int i=0;
		for(String mod : ModuleManager.activeModules()){
			if(mod.equals(module))
				return i;
			i++;
		}
		return 0;
	}
	public static String title(){
		return "EasyKin, " + DateUtil.todayWeek();
	}
}