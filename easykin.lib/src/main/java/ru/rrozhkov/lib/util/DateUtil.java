package ru.rrozhkov.lib.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	private static final DateFormat SDF = new SimpleDateFormat("dd.MM.yyyy");
	private static final DateFormat SDFWEEKDAY = new SimpleDateFormat("dd MMMMM yyyy, EEEE ", new Locale("ru"));
	private static final DateFormat SDFSERVICE = new SimpleDateFormat("MMMMM yyyy", new Locale("ru"));
	private static final DateFormat SQLSDF = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date parse(String date){
		try{
			return SDF.parse(date);
		}catch(Exception e){
			return null;
		}
	}
	
	public static String format(Date date){
		return SDF.format(date);
	}

	public static String formatWeek(Date date){
		return SDFWEEKDAY.format(date);
	}
	
	public static String formatSql(Date date){
		return SQLSDF.format(date);
	}
	public static String formatService(Date date){
		return SDFSERVICE.format(date);
	}
	public static Date today(){return new Date();}
	public static String todayWeek(){return formatWeek(today());}
}