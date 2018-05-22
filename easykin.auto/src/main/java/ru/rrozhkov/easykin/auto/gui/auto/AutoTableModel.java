package ru.rrozhkov.easykin.auto.gui.auto;

import ru.rrozhkov.easykin.auto.gui.auto.style.impl.custom.ServiceTableStyle;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.lib.gui.TableModel;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.Collection;
import java.util.List;

/**
 * Created by rrozhkov on 22.05.2018.
 */
public class AutoTableModel extends TableModel {
    public AutoTableModel(Collection beans) {
        super(beans, new ServiceTableStyle());
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        IService entry = (IService)((List)beans).get(rowIndex);
        switch(columnIndex) {
            case 0:
                return 0;
            case 1:
                return entry.getName();
            case 2:
                return entry.getPrice().toString();
            case 3:
                return DateUtil.format(entry.getDate());
        }
        return "";
    }
}
