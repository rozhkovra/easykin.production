package ru.rrozhkov.easykin.service.service.impl;

/**
 * Created by rrozhkov on 12.12.2018.
 */
public class ServiceCalc2ServiceFactory {
    private static class Holder {
        private static final ServiceCalc2ServiceFactory INSTANCE = new ServiceCalc2ServiceFactory();
    }

    public static ServiceCalc2ServiceFactory instance(){
        return Holder.INSTANCE;
    }

    private ServiceCalc2ServiceFactory() {
    }

    public CalculationService calc() {return CalculationService.instance();}
    public ReadingService reading() {return ReadingService.instance();}
}
