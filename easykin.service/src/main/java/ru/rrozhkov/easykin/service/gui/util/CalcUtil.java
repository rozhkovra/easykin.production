package ru.rrozhkov.easykin.service.gui.util;

import ru.rrozhkov.easykin.model.fin.Money;

public class CalcUtil {
	public static double doubleNUllOrEmpty(String text){
		return !"".equals(text)?Double.valueOf(text):0.0;
	}
	public static Money moneyNUllOrEmpty(String text){
		return !"".equals(text)? Money.valueOf(text):Money.ZERO;
	}
}