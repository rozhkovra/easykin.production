package ru.rrozhkov.easykin.payment.impl.convert;

import ru.rrozhkov.lib.convert.IEntityConverter;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class PaymentConverterFactory {
    public static IEntityConverter payment(){return new PaymentConverter();}
}
