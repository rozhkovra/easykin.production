package ru.rrozhkov.easykin.family.gui;

import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.lib.gui.TableModel;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.Collection;
import java.util.List;

/**
 * Created by rrozhkov on 22.05.2018.
 */
public class FamilyTableModel extends TableModel {
    public FamilyTableModel(Collection beans) {
        super(beans, new FamilyTableStyle());
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        IKinPerson person = (IKinPerson)((List)beans).get(rowIndex);
        switch(columnIndex) {
            case 0:
                return person.getId();
            case 1:
                return person.getSurname();
            case 2:
                return person.getName();
            case 3:
                return person.getSecondName();
            case 4:
                return DateUtil.format(person.getBirthDate());
        }
        return "";
    }
}
