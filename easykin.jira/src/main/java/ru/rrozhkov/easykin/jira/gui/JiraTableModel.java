package ru.rrozhkov.easykin.jira.gui;

import ru.rrozhkov.easykin.core.gui.TableModel;
import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.jira.JiraTask;
import ru.rrozhkov.easykin.model.task.ITask;

import java.util.Collection;
import java.util.List;

/**
 * Created by rrozhkov on 22.05.2018.
 */
public class JiraTableModel extends TableModel {
    public JiraTableModel(Collection beans) {
        super(beans, new JiraTableStyle());
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        JiraTask task = (JiraTask)((List)beans).get(rowIndex);
        switch(columnIndex) {
            case 0:
                return "#";
            case 1:
                return task.getName();
            case 2:
                return task.getStatus();
        }
        return "";
    }
}
