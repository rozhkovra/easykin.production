package ru.rrozhkov.easykin.gui.service.util;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;

public class CalcUtil {
	public static double doubleNUllOrEmpty(String text){
		return !"".equals(text)?Double.valueOf(text):0.0;
	}
	public static Money moneyNUllOrEmpty(String text){
		return !"".equals(text)? MoneyFactory.create(text):MoneyFactory.create();
	}
}