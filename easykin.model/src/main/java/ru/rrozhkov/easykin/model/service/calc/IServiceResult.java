package ru.rrozhkov.easykin.model.service.calc;

import ru.rrozhkov.easykin.core.calculation.IResult;
import ru.rrozhkov.easykin.model.fin.Money;

/**
 * Created by rrozhkov on 15.08.2018.
 */
public interface IServiceResult extends IResult {
    Money getResult();
}
