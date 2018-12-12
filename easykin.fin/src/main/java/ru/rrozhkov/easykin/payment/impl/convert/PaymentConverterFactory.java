package ru.rrozhkov.easykin.payment.impl.convert;

import ru.rrozhkov.easykin.core.convert.IEntityConverter;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class PaymentConverterFactory {
    private static class PaymentConverterFactoryHolder {
        private static final PaymentConverterFactory INSTANCE = new PaymentConverterFactory();
    }

    public static PaymentConverterFactory instance(){
        return PaymentConverterFactoryHolder.INSTANCE;
    }

    public IEntityConverter payment(){return new PaymentConverter();}
}
