package ru.rrozhkov.easykin.service.calculator;

import ru.rrozhkov.easykin.core.calculation.IResult;

/**
 * Created by rrozhkov on 15.08.2018.
 */
public class CalcResult implements IResult {
    private Object value;

    public CalcResult(Object value) {
        this.value = value;
    }

    public Object getResult() {
        return value;
    }
}
