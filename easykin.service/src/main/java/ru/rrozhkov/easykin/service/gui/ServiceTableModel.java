package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.service.CalculatorFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.calc.impl.util.ServiceCalcUtil;
import ru.rrozhkov.easykin.core.gui.TableModel;
import ru.rrozhkov.easykin.core.util.DateUtil;

import java.util.Collection;
import java.util.List;

/**
 * Created by rrozhkov on 22.05.2018.
 */
public class ServiceTableModel extends TableModel{
    private static final CalculatorFactory calculatorFactory = CalculatorFactory.instance();

    protected ServiceTableModel(Collection beans) {
        super(beans, new ServiceCalcTableStyle());
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        ServiceCalc calc = (ServiceCalc)((List)beans).get(rowIndex);
        switch(columnIndex) {
            case 0:
                return calc.getName();
            case 1:
                return DateUtil.format(calc.getDate());
            case 2:
                return calculatorFactory.getCalculator(ServiceCalcUtil.getCalcByType(calc, CalculationType.WATER)).calculate().toString();
            case 3:
                return calculatorFactory.getCalculator(ServiceCalcUtil.getCalcByType(calc, CalculationType.HOTWATER)).calculate().toString();
            case 4:
                return calculatorFactory.getCalculator(ServiceCalcUtil.getCalcByType(calc, CalculationType.ELECTRICITY)).calculate().toString();
            case 5:
                return calculatorFactory.getCalculator(ServiceCalcUtil.getCalcByType(calc, CalculationType.GAZ)).calculate().toString();
            case 6:
                return calculatorFactory.getCalculator(ServiceCalcUtil.getCalcByType(calc, CalculationType.HEATING)).calculate().toString();
            case 7:
                return calculatorFactory.getCalculator(ServiceCalcUtil.getCalcByType(calc, CalculationType.ANTENNA)).calculate().toString();
            case 8:
                return calculatorFactory.getCalculator(ServiceCalcUtil.getCalcByType(calc, CalculationType.INTERCOM)).calculate().toString();
            case 9:
                return calculatorFactory.getCalculator(ServiceCalcUtil.getCalcByType(calc, CalculationType.HOUSE)).calculate().toString();
            case 10:
                return calculatorFactory.getCalculator(ServiceCalcUtil.getCalcByType(calc, CalculationType.REPAIR)).calculate().toString();
            case 11:
                return calculatorFactory.getCalculator(calc).calculate().toString()+(!ServiceCalcUtil.getNoPaidSum(calc).free()?" ("+ServiceCalcUtil.getNoPaidSum(calc)+")":"");
        }
        return "";
    }
}
