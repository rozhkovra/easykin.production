package ru.rrozhkov.easykin.service.db.impl.calc2;

/**
 * Created by rrozhkov on 11.12.2018.
 */
public class ServiceCalc2HandlerFactory {
    private static class Holder {
        private static final ServiceCalc2HandlerFactory INSTANCE = new ServiceCalc2HandlerFactory();
    }

    public static ServiceCalc2HandlerFactory instance(){
        return Holder.INSTANCE;
    }

    private ServiceCalc2HandlerFactory() {
    }

    public CalcHandler calc() {return CalcHandler.instance();}
    public MeasureHandler measure() {return MeasureHandler.instance();}
    public RateHandler rate() {return RateHandler.instance();}
    public ReadingHandler reading() {return ReadingHandler.instance();}
}
