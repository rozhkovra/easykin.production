package ru.rrozhkov.easykin.gui.util;

import javax.swing.JTabbedPane;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.lib.util.DateUtil;

public class ContextUtil {
	public static ICategory getCurrentCategory(MasterDataContext context, JTabbedPane tabs){
		int index = tabs.getSelectedIndex();
		if(index==-1)return null;
		String categoryName = tabs.getTitleAt(index);
		for(ICategory category : context.categories()){
			if(categoryName.equals(category.getName()))
				return category;
		}
		return null;
	}
	public static int getCurrentTab(MasterDataContext context, JTabbedPane tabs){
		ICategory category = context.currentCategory();
		if(category==null)
			return -1;
		String categoryName = category.getName();
		for(int i = 0; i < tabs.getTabCount();i++){
			if(categoryName.equals(tabs.getTitleAt(i)))
				return i;
		}
		return -1;
	}

	public static String title(){
		return "EasyKin, " + DateUtil.todayWeek();
	}
	public static String authTitle() {
		return "Авторизация";
	}
	public static String serviceTitle() {
		return "EasyKin Калькулятор - Коммунальные услуги";
	}
}