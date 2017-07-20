package ru.rrozhkov.easykin.gui;

import ru.rrozhkov.easykin.context.EasyKinContext;
import ru.rrozhkov.easykin.context.IContext;
import ru.rrozhkov.easykin.gui.task.TaskFilter;
import ru.rrozhkov.easykin.model.category.ICategory;

import javax.swing.*;

/**
 * Created by rrozhkov on 3/21/2017.
 */
public class FilterFormFactory {

    public static JPanel task(IContext context, IGUIEditor parent) {
        return new TaskFilter(context, parent);
    }
    public static JPanel getFilterFormPanel(IContext context, IGUIEditor parent) {
        ICategory category = ((EasyKinContext)context).masterData().currentCategory();
        if(category.getId()==1){
            return task(context, parent);
        }else if(category.getId()==2){
            return person(context, parent);
        }else if(category.getId()==3){
            return person(context, parent);
        }else if(category.getId()==4){
            return autoService(context, parent);
        }else if(category.getId()==5){
            return payment(context, parent);
        }else if(category.getId()==6){
            return payment(context, parent);
        }else if(category.getId()==7){
            return doc(context, parent);
        }else if(category.getId()==8){
            return task(context, parent);
        }else if(category.getId()==9){
            return task(context, parent);
        }else if(category.getId()==10){
            return serviceCalc(context, parent);
        }
        return new JPanel();
    }

    private static JPanel serviceCalc(IContext context, IGUIEditor parent) {
        return new JPanel();
    }

    private static JPanel doc(IContext context, IGUIEditor parent) {
        return new JPanel();
    }

    private static JPanel payment(IContext context, IGUIEditor parent) {
        return new JPanel();
    }

    private static JPanel autoService(IContext context, IGUIEditor parent) {
        return new JPanel();
    }

    private static JPanel person(IContext context, IGUIEditor parent) {
        return new JPanel();
    }

}
