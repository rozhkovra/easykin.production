package ru.rrozhkov.easykin.work.gui;

import ru.rrozhkov.easykin.model.person.util.PersonUtil;
import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.lib.gui.TableModel;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.Collection;
import java.util.List;

/**
 * Created by rrozhkov on 22.05.2018.
 */
public class ActivityTableModel extends TableModel {
    public ActivityTableModel(Collection beans) {
        super(beans, new ActivityTableStyle());
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        IActivity activity = (IActivity)((List)beans).get(rowIndex);
        switch(columnIndex) {
            case 0:
                return activity.getId();
            case 1:
                return PersonUtil.fi(activity.getPerson());
            case 2:
                return DateUtil.format(activity.getDate());
            case 3:
                return String.valueOf(activity.getTime());
            case 4:
                return String.valueOf(activity.getTaskType());
            case 5:
                return activity.getName();
            case 6:
                return String.valueOf(activity.getReleaseType());
            case 7:
                return activity.getDesc();
        }
        return "";
    }
}
