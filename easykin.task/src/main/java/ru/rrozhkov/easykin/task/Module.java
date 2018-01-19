package ru.rrozhkov.easykin.task;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.easykin.task.gui.GUIFactory;
import ru.rrozhkov.easykin.task.gui.style.impl.custom.TaskStyle;
import ru.rrozhkov.easykin.task.impl.TaskBuilder;
import ru.rrozhkov.easykin.task.impl.convert.TaskPaymentCollectionConverter;
import ru.rrozhkov.lib.filter.IFilter;
import ru.rrozhkov.lib.filter.util.FilterUtil;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.Table;
import ru.rrozhkov.lib.gui.TablePanel;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    public static JPanel createPanel(IGUIEditor parent){
        return new TablePanel(parent, new Table(tasks(), new TaskStyle()));
    }
    public static JPanel createEditor(IGUIEditor parent){
        return GUIFactory.createTaskEditor(parent, null);
    }
    public static JPanel createEditor(IGUIEditor parent, ITask task){
        return GUIFactory.createTaskEditor(parent, task);
    }
    public static JPanel createFilter(IGUIEditor parent){
        return GUIFactory.createTaskFilter(parent);
    }

    public static Collection tasks(){
        Collection collection;
        IPerson person = AuthManager.instance().signedPerson();
        if(person!=null)
            collection = tasks(person);
        else
            collection = TaskBuilder.build();
        return collection;
    }
    public static Collection tasks(IPerson person){
        return TaskBuilder.build(person.getId());
    }
    public static Collection tasks(IPerson person, IFilter filter){
        return FilterUtil.filter(tasks(person), filter);
    }
    public static Collection<IPayment> payments(){
        return new TaskPaymentCollectionConverter().convert(tasks());
    }
}
