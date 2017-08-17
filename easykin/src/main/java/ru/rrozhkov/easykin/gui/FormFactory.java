package ru.rrozhkov.easykin.gui;

import ru.rrozhkov.easykin.Module;
import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.gui.doc.DocForm;
import ru.rrozhkov.easykin.gui.payment.PaymentForm;
import ru.rrozhkov.easykin.gui.person.PersonForm;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.doc.IDoc;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.lib.gui.IGUIEditor;

import javax.swing.*;

public class FormFactory {
	public static JPanel createPaymentForm(IGUIEditor parent, Object obj){
		if(obj!=null && obj instanceof IPayment)
			return new PaymentForm(parent,(IPayment)obj);
		return new PaymentForm(parent);
	}

	private static JPanel createPersonForm(IGUIEditor parent, Object obj) {
		if(obj!=null && obj instanceof IPerson)
			return new PersonForm(parent,(IPerson)obj);
		return new JPanel();
	}

	private static JPanel createDocForm(IGUIEditor parent, Object obj) {
		if(obj!=null && obj instanceof IDoc)
			return new DocForm(parent,(IDoc)obj);
		return new JPanel();
	}

	public static JPanel getFormPanel(MasterDataContext context, IGUIEditor parent, Object obj) {
		ICategory category = context.currentCategory();
		if(category.getId()==1
				|| category.getId()==8
				|| category.getId()==9){
			if(ModuleManager.exist(Module.TASK)) {
				if(obj!=null)
					return (JPanel)ModuleManager.invoke(Module.TASK, "createEditor", parent, obj);
				else
					return (JPanel)ModuleManager.invoke(Module.TASK, "createEditor", parent);
			}
		}else if(category.getId()==2){
			return createPersonForm(parent, obj);
		}else if(category.getId()==3){
			return createPersonForm(parent,obj);
		}else if(category.getId()==4){
			if(ModuleManager.exist(Module.AUTO)) {
				if(obj!=null)
					return (JPanel)ModuleManager.invoke(Module.AUTO, "createEditor", parent, obj);
			}
		}else if(category.getId()==5){
			return createPaymentForm(parent, obj);
		}else if(category.getId()==6){
			return createPaymentForm(parent, obj);
		}else if(category.getId()==7){
			return createDocForm(parent, obj);
		}else if(category.getId()==10){
			if(ModuleManager.exist(Module.SERVICE)) {
				if(obj!=null)
					return (JPanel)ModuleManager.invoke(Module.SERVICE, "createEditor", obj);
			}
		}
		return new JPanel();
	}
}
