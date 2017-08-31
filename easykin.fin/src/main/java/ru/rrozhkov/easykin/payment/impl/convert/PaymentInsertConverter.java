package ru.rrozhkov.easykin.payment.impl.convert;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentCategory;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;
import ru.rrozhkov.lib.convert.IConverter;

/**
 * Created by rrozhkov on 6/19/2017.
 */

public class PaymentInsertConverter implements IConverter<IPayment, String> {
    private static int ID = 0;
    public String convert(IPayment payment) {
        return "INSERT INTO payment(id, comment, category, status, amount) VALUES("+(++ID)
                +", '"+payment.getComment()+"'"
                +", "+ PaymentCategory.category(payment.getCategory())
                +", "+ PaymentStatus.status(payment.getStatus())
                +", "+ payment.getAmount().getValue()+ ")";
    }
}
