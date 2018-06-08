package ru.rrozhkov.easykin.payment.impl.convert;

import ru.rrozhkov.lib.convert.IEntityConverter;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class PaymentConverterFactory {
    public static class PaymentConverterFactoryHolder {
        public static final PaymentConverterFactory INSTANCE = new PaymentConverterFactory();
    }

    public static PaymentConverterFactory instance(){
        return PaymentConverterFactoryHolder.INSTANCE;
    }

    public IEntityConverter payment(){return new PaymentConverter();}
}
