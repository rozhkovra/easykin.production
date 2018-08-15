package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.core.gui.TableModel;
import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.calc.impl.util.ServiceCalcUtil;

import java.util.Collection;
import java.util.List;

/**
 * Created by rrozhkov on 22.05.2018.
 */
public class ServiceTableModel extends TableModel{
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
                return ServiceCalcUtil.getCalcByType(calc, CalculationType.WATER).getAmount().toString();
            case 3:
                return ServiceCalcUtil.getCalcByType(calc, CalculationType.HOTWATER).getAmount().toString();
            case 4:
                return ServiceCalcUtil.getCalcByType(calc, CalculationType.ELECTRICITY).getAmount().toString();
            case 5:
                return ServiceCalcUtil.getCalcByType(calc, CalculationType.GAZ).getAmount().toString();
            case 6:
                return ServiceCalcUtil.getCalcByType(calc, CalculationType.HEATING).getAmount().toString();
            case 7:
                return ServiceCalcUtil.getCalcByType(calc, CalculationType.ANTENNA).getAmount().toString();
            case 8:
                return ServiceCalcUtil.getCalcByType(calc, CalculationType.INTERCOM).getAmount().toString();
            case 9:
                return ServiceCalcUtil.getCalcByType(calc, CalculationType.HOUSE).getAmount().toString();
            case 10:
                return ServiceCalcUtil.getCalcByType(calc, CalculationType.REPAIR).getAmount().toString();
            case 11:
                return ServiceCalcUtil.getSum(calc)+(!ServiceCalcUtil.getNoPaidSum(calc).free()?" ("+ServiceCalcUtil.getNoPaidSum(calc)+")":"");
        }
        return "";
    }
}
