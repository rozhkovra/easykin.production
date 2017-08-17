package ru.rrozhkov.easykin.ws.bean;

import java.util.Date;

/**
 * Created by rrozhkov on 2/21/2017.
 */
public class PaymentBean {
    protected String category;
    protected String comment;
    protected double amount;
    protected Date date;
    protected int status;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
