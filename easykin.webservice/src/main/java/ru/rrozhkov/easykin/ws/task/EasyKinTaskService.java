package ru.rrozhkov.easykin.ws.task;

import ru.rrozhkov.easykin.core.db.impl.EntityHandler;
import ru.rrozhkov.easykin.task.db.impl.TaskHandlerFactory;
import ru.rrozhkov.easykin.ws.bean.TaskBean;
import ru.rrozhkov.easykin.ws.convert.WSConverterFactory;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.SQLException;

/**
 * Created by rrozhkov on 2/28/2017.
 */
@WebService(serviceName="EasyKinTask", portName="EasyKinTaskPort", targetNamespace="http://rrozhkov.ru/easykin/task")
public class EasyKinTaskService {
    private static final EntityHandler taskHandler = TaskHandlerFactory.instance().task();
    @WebMethod
    public int add(TaskBean bean) {
        try {
            return taskHandler.insert(WSConverterFactory.taskws().convert(bean));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

}
