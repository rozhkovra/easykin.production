package ru.rrozhkov.easykin.task.impl.convert;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.impl.PaymentFactory;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.util.TaskUtil;
import ru.rrozhkov.lib.convert.IConverter;

/**
 * Created by rrozhkov on 8/25/2017.
 */
public class TaskPaymentConverter  implements IConverter<ITask, IPayment> {
    public IPayment convert(ITask entry) {
        return PaymentFactory.createTaskPayment(entry.getName(), TaskUtil.extractAmount(entry), entry.getStatus().isClose() ? entry.getCloseDate() : entry.getPlanDate(), entry.getStatus());
    }
}
