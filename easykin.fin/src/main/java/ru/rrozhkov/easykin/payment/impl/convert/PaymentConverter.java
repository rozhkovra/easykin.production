package ru.rrozhkov.easykin.payment.impl.convert;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentCategory;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;
import ru.rrozhkov.easykin.model.fin.payment.impl.PaymentFactory;
import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.core.util.DateUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class PaymentConverter implements IEntityConverter<IPayment> {
    final static private PaymentFactory paymentFactory = new PaymentFactory();
    protected PaymentConverter() {
    }

    public String sqlInsert(IPayment entity) {
        return new IConverter<IPayment, String>() {
            public String convert(IPayment payment) {
                return "INSERT INTO payment(id, comment, category, status, amount) VALUES("+payment.getId()
                        +", '"+payment.getComment()+"'"
                        +", "+ PaymentCategory.category(payment.getCategory())
                        +", "+ PaymentStatus.status(payment.getStatus())
                        +", "+ payment.getAmount().getValue()+ ")";
            }
        }.convert(entity);
    }

    public Map<String, Object> map(IPayment entity) {
        return new IConverter<IPayment, Map<String, Object>>() {
            public Map<String, Object> convert(IPayment payment) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", payment.getId());
                map.put("comment", payment.getComment());
                map.put("createdate", DateUtil.formatSql(payment.getDate()));
                map.put("categoryid", PaymentCategory.category(payment.getCategory()));
                map.put("statusid", PaymentStatus.status(payment.getStatus()));
                map.put("amount", payment.getAmount().getValue());
                return map;
            }
        }.convert(entity);
    }

    public String[] stringArr(Collection<IPayment> entries) {
        return new String[0];
    }

    public IPayment entity(ResultSet resultSet) {
        return new IConverter<ResultSet, IPayment>() {
            public IPayment convert(ResultSet result){
                try{
                    return paymentFactory.createPayment(result.getInt("id"), PaymentCategory.category(result.getInt("categoryid"))
                            , result.getString("comment"), Money.valueOf(result.getDouble("amount"))
                            , result.getDate("createdate"), PaymentStatus.status(result.getInt("statusid")));
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return null;
            }
        }.convert(resultSet);
    }
}
