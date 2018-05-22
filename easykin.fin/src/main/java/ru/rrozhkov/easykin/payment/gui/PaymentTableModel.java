package ru.rrozhkov.easykin.payment.gui;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.payment.style.impl.custom.PaymentTableStyle;
import ru.rrozhkov.lib.gui.TableModel;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.Collection;
import java.util.List;

/**
 * Created by rrozhkov on 22.05.2018.
 */
public class PaymentTableModel extends TableModel {
    public PaymentTableModel(Collection beans) {
        super(beans, new PaymentTableStyle());
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        IPayment payment = (IPayment)((List)beans).get(rowIndex);
        switch(columnIndex) {
            case 0:
                return payment.getId();
            case 1:
                return String.valueOf(payment.getCategory());
            case 2:
                return payment.getComment();
            case 3:
                return String.valueOf(payment.getAmount());
            case 4:
                return DateUtil.format(payment.getDate());
        }
        return "";
    }
}
