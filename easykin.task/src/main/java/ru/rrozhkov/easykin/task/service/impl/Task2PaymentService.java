package ru.rrozhkov.easykin.task.service.impl;

import ru.rrozhkov.easykin.core.service.impl.EntityService;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.task.ITask2Payment;
import ru.rrozhkov.easykin.payment.service.impl.PaymentService;
import ru.rrozhkov.easykin.task.db.impl.Task2PaymentHandler;
import ru.rrozhkov.easykin.task.db.impl.TaskHandlerFactory;

import java.sql.SQLException;

/**
 * Created by rrozhkov on 20.12.2018.
 */
public class Task2PaymentService extends EntityService {
    private static final Task2PaymentHandler t2paymentHandler = TaskHandlerFactory.instance().task2Payment();
    private static final PaymentService paymentService = PaymentService.instance();
    private static class Holder {
        private static final Task2PaymentService INSTANCE = new Task2PaymentService();
    }

    static Task2PaymentService instance(){
        return Holder.INSTANCE;
    }

    private Task2PaymentService() {
        super(t2paymentHandler);
    }

    public IPayment paymentForTask(int taskId) {
        ITask2Payment t2p = null;
        try {
            t2p = t2paymentHandler.selectForTask(taskId);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        if (t2p == null) {
            return null;
        }
        int paymentId = t2p.getPaymentId();
        return paymentService.payment(paymentId);
    }
}
