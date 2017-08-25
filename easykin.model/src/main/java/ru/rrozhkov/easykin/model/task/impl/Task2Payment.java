package ru.rrozhkov.easykin.model.task.impl;

import ru.rrozhkov.easykin.model.task.ITask2Payment;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class Task2Payment implements ITask2Payment {
    protected int id;
    protected int paymentId;
    protected int taskId;

    public Task2Payment(int id, int paymentId, int taskId) {
        this.id = id;
        this.paymentId = paymentId;
        this.taskId = taskId;
    }

    public int getId() {
        return id;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public int getTaskId() {
        return taskId;
    }
}