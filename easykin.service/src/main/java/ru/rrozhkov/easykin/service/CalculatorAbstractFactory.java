package ru.rrozhkov.easykin.service;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public abstract class CalculatorAbstractFactory {
    public static CalculatorAbstractFactory instance() {
        return new Calculator2Factory();
    }
    public abstract ICalculator getCalculator(ICalculation bean);
}
