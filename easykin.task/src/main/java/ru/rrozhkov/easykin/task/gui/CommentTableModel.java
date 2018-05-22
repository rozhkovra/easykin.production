package ru.rrozhkov.easykin.task.gui;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.task.gui.style.impl.custom.CommentTableStyle;
import ru.rrozhkov.lib.gui.TableModel;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.Collection;
import java.util.List;

/**
 * Created by rrozhkov on 22.05.2018.
 */
public class CommentTableModel extends TableModel {
    public CommentTableModel(Collection beans) {
        super(beans, new CommentTableStyle());
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        IComment comment = (IComment)((List)beans).get(rowIndex);
        switch(columnIndex) {
            case 0:
                return comment.getId();
            case 1:
                return comment.getText();
            case 2:
                return DateUtil.format(comment.getDate());
        }
        return "";
    }
}
