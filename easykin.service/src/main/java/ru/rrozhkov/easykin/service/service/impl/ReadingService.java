package ru.rrozhkov.easykin.service.service.impl;

import ru.rrozhkov.easykin.core.db.impl.EntityHandler;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.impl.ServiceFactory;
import ru.rrozhkov.easykin.service.db.impl.calc2.ServiceCalc2HandlerFactory;

/**
 * Created by rrozhkov on 19.06.2018.
 */
public class ReadingService {
    private static final ServiceFactory serviceFactory = ServiceFactory.instance();
    private static final EntityHandler measureHandler = ServiceCalc2HandlerFactory.instance().measure();
    private static final EntityHandler readingHandler = ServiceCalc2HandlerFactory.instance().reading();
    private static final EntityHandler calcHandler = ServiceCalc2HandlerFactory.instance().calc();

    public static class Holder {
        public static final ReadingService INSTANCE = new ReadingService();
    }

    public static ReadingService instance(){
        return Holder.INSTANCE;
    }

    private ReadingService() {
    }

    public int createOrUpdate(IReading reading){
        int id = reading.getId();
        try{
            if(reading.getId()==-1) {
                id = readingHandler.insert(reading);
                for(IMeasure measure : reading.getMeasures()) {
                    IMeasure newMeasure = serviceFactory.createMeasure(-1, id, measure.getType(), measure.getValue());
                    measureHandler.insert(newMeasure);
                }
                for(ICalculation calculation : reading.getCalcs()) {
                    calcHandler.insert(calculation);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return id;
    }
}
