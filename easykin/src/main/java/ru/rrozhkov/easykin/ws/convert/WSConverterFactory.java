package ru.rrozhkov.easykin.ws.convert;

/**
 * Created by rrozhkov on 3/1/2017.
 */
public class WSConverterFactory {
    public static WSCategoryConverter category(){
        return new WSCategoryConverter();
    }
    public static WSPaymentConverter payment(){
        return new WSPaymentConverter();
    }
    public static WSPersonConverter person(){
        return new WSPersonConverter();
    }
    public static WSTaskConverter task(){
        return new WSTaskConverter();
    }
    public static TaskWSConverter taskws(){
        return new TaskWSConverter();
    }
}
