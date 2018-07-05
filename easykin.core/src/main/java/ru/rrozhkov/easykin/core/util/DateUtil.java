package ru.rrozhkov.easykin.core.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {
	private static final DateFormat SDF = new SimpleDateFormat("dd.MM.yyyy");
	private static final DateFormat SDFWEEKDAY = new SimpleDateFormat("dd MMMMM yyyy, EEEE ", new Locale("ru"));
	private static final DateFormat SDFSERVICE = new SimpleDateFormat("MMMMM yyyy", new Locale("ru"));
	private static final DateFormat SQLSDF = new SimpleDateFormat("yyyy-MM-dd");
	static {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+6:00"));
		SDF.setTimeZone(TimeZone.getTimeZone("GMT+6:00"));
		SDFWEEKDAY.setTimeZone(TimeZone.getTimeZone("GMT+6:00"));
		SDFSERVICE.setTimeZone(TimeZone.getTimeZone("GMT+6:00"));
		SQLSDF.setTimeZone(TimeZone.getTimeZone("GMT+6:00"));
	}
	
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
	public static String formatWeek(){
		return SDFWEEKDAY.format(today());
	}
	public static String formatSql(Date date){
		return SQLSDF.format(date);
	}
	public static String formatService(Date date){
		return SDFSERVICE.format(date);
	}
	public static Date today(){return new Date();}
	public static boolean isToday(Date date){
		Date today = today();
		return today.getDate() == date.getDate()
				&& today.getMonth() == date.getMonth()
				&& today.getYear() == date.getYear();
	}
	public static String todayWeek(){return formatWeek(today());}
	public static Date firstDayOfMonth(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DATE));
		return cal.getTime();
	}
	public static Date firstDayOfMonth(){
		return firstDayOfMonth(today());
	}
	public static Date lastDayOfMonth(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
		return cal.getTime();
	}
	public static Date lastDayOfMonth(){
		return lastDayOfMonth(today());
	}
	public static Date shiftDate(Date source, long shiftMillis) {
		return new Date(source.getTime() + shiftMillis);
	}
}