package ru.rrozhkov.easykin.service.service.impl;

import ru.rrozhkov.easykin.core.db.impl.EntityHandler;
import ru.rrozhkov.easykin.core.service.impl.EntityService;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.impl.ServiceFactory;
import ru.rrozhkov.easykin.service.db.impl.calc2.ServiceCalc2HandlerFactory;

/**
 * Created by rrozhkov on 19.06.2018.
 */
public class ReadingService extends EntityService {
    private static final ServiceFactory serviceFactory = ServiceFactory.instance();
    private static final EntityHandler measureHandler = ServiceCalc2HandlerFactory.instance().measure();
    private static final EntityHandler calcHandler = ServiceCalc2HandlerFactory.instance().calc();

    private static class Holder {
        private static final ReadingService INSTANCE = new ReadingService();
    }

    static ReadingService instance(){
        return Holder.INSTANCE;
    }

    private ReadingService() {
        super(ServiceCalc2HandlerFactory.instance().reading());
    }

    public int createOrUpdate(IReading reading){
        int id = super.createOrUpdate(reading);
        try{
            if(reading.getId()==-1) {
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
