package ru.rrozhkov.easykin.gui;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.gui.style.impl.custom.DocStyle;
import ru.rrozhkov.easykin.gui.style.impl.custom.PaymentStyle;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.module.Module;
import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.Table;
import ru.rrozhkov.lib.gui.TablePanel;

import javax.swing.*;
import java.util.Collection;

public class PanelFactory {
	private static JPanel createPaymentPanel(IGUIEditor parent, Collection collection) {
		return new TablePanel(parent, new Table(collection, new PaymentStyle()));
	}
	private static JPanel createDocPanel(IGUIEditor parent, Collection collection) {
		return new TablePanel(parent, new Table(collection, new DocStyle()));
	}

	public static JPanel createPanel(String module, IGUIEditor parent){
		if(ModuleManager.exist(module)){
			JPanel panel = (JPanel)ModuleManager.invoke(module, "createPanel", parent);
			if(panel==null)
				panel = new JPanel();
			return panel;
		}
		return new JPanel();
	}
	public static JPanel createPanel(IGUIEditor parent, MasterDataContext context, ICategory category){
		IPerson person = AuthManager.instance().signedPerson();
		if(category.getId()==1
				|| category.getId()==8){
			if(ModuleManager.exist(Module.TASK)){
				return (JPanel)ModuleManager.invoke(Module.TASK, "createPanelForCategory", parent, person, category);
			}
		}else if(category.getId()==2){
			if(ModuleManager.exist(Module.FAMILY)){
				return (JPanel)ModuleManager.invoke(Module.FAMILY, "createKidsPanel", parent);
			}
		}else if(category.getId()==3){
			if(ModuleManager.exist(Module.FAMILY)){
				return (JPanel)ModuleManager.invoke(Module.FAMILY, "createPanel", parent);
			}
		}else if(category.getId()==4){
			if(ModuleManager.exist(Module.AUTO))
				return (JPanel)ModuleManager.invoke(Module.AUTO, "createPanel", parent);
		}else if(category.getId()==5){
			if(ModuleManager.exist(Module.FIN))
				return createPaymentPanel(parent, context.dataForCategory(category.getId()));
		}else if(category.getId()==6){
			if(ModuleManager.exist(Module.FIN))
				return createPaymentPanel(parent, context.dataForCategory(category.getId()));
		}else if(category.getId()==7){
			return createDocPanel(parent, context.docs());
		}else if(category.getId()==9){
			if(ModuleManager.exist(Module.TASK)) {
				return (JPanel)ModuleManager.invoke(Module.TASK, "createPanel", parent);
			}
		}else if(category.getId()==10){
			if(ModuleManager.exist(Module.SERVICE)){
				return (JPanel)ModuleManager.invoke(Module.SERVICE, "createPanel", parent);
			}
		}
        return new JPanel();
	}
}