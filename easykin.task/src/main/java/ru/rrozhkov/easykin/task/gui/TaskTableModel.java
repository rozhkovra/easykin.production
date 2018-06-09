package ru.rrozhkov.easykin.task.gui;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.core.gui.TableModel;
import ru.rrozhkov.easykin.core.util.DateUtil;

import java.util.Collection;
import java.util.List;

/**
 * Created by rrozhkov on 22.05.2018.
 */
public class TaskTableModel extends TableModel {
    public TaskTableModel(Collection beans) {
        super(beans, new TaskTableStyle());
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        ITask task = (ITask)((List)beans).get(rowIndex);
        switch(columnIndex) {
            case 0:
                return task.getId();
            case 1:
                return task.getName();
            case 2:
                return DateUtil.format(task.getPlanDate());
            case 3:
                return String.valueOf(task.getPriority());
            case 4:
                return task.getCategory().getName();
            case 5: {
                if (task.getStatus().isOpen()) {
                    return DateUtil.format(task.getCreateDate());
                } else
                    return DateUtil.format(task.getCloseDate());
            }
        }
        return "";
    }
}
