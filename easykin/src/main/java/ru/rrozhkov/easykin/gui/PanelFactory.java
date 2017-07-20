package ru.rrozhkov.easykin.gui;

import java.util.Collection;

import javax.swing.JPanel;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.gui.auto.AutoPanel;
import ru.rrozhkov.easykin.gui.auto.CarForm;
import ru.rrozhkov.easykin.gui.style.impl.custom.*;
import ru.rrozhkov.easykin.gui.task.TaskEditor;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.doc.IDoc;
import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.ITask;

public class PanelFactory {
	private static JPanel createFamilyPanel(EasyKinWindow parent, Collection<IKinPerson> collection){		
		return new TablePanel(parent, new Table(collection, new FamilyStyle()));
	}
	private static JPanel createChildPanel(EasyKinWindow parent, Collection<IKinPerson> collection){
		return new TablePanel(parent, new Table(collection, new FamilyStyle()));
	}
	public static JPanel createAutoServicePanel(EasyKinWindow parent, Collection<IService> services){
		return new TablePanel(parent, new Table(services, new ServiceStyle()));
	}
	private static JPanel createHomePanel(EasyKinWindow parent, Collection<ITask> tasks) {
		return new TablePanel(parent, new Table(tasks, new TaskStyle()));
	}
	private static JPanel createFinPanel(EasyKinWindow parent, Collection<IPayment> collection) {
		return new TablePanel(parent, new Table(collection, new PaymentStyle()));
	}
	private static JPanel createWorkPanel(EasyKinWindow parent, Collection<ITask> collection) {
		return new TablePanel(parent, new Table(collection, new TaskStyle()));
	}
	private static JPanel createPaymentPanel(EasyKinWindow parent, Collection<IPayment> collection) {
		return new TablePanel(parent, new Table(collection, new PaymentStyle()));
	}
	private static JPanel createTaskPanel(EasyKinWindow parent, Collection<ITask> collection){
		return new TablePanel(parent, new Table(collection, new TaskStyle()));
	}
	public static JPanel createServicePanel(EasyKinWindow parent, MasterDataContext context){
		return new TablePanel(parent, new Table(context.calcs(), new ServiceCalcStyle()));
	}
	private static JPanel createDocPanel(EasyKinWindow parent, Collection<IDoc> collection) {
		return new TablePanel(parent, new Table(collection, new DocStyle()));
	}
	public static JPanel createCarPanel(MasterDataContext context) {
		return new CarForm(context.car());
	}
	private static JPanel createAutoPanel(EasyKinWindow parent, MasterDataContext context) {
		return new AutoPanel(parent, context);
	}
	public static JPanel createTaskCommentPanel(TaskEditor taskEditor, Collection<IComment> comments){
		return new TablePanel(taskEditor, new Table(comments, new CommentStyle()));
	}	
	public static JPanel createPanel(EasyKinWindow parent, MasterDataContext context, ICategory category){
		if(category.getId()==1){
			 return createHomePanel(parent, context.dataForCategory(category.getId()));
		}else if(category.getId()==2){
			return createChildPanel(parent, context.dataForCategory(category.getId()));
		}else if(category.getId()==3){
			return createFamilyPanel(parent, context.dataForCategory(category.getId()));
		}else if(category.getId()==4){
			return createAutoPanel(parent, context);
		}else if(category.getId()==5){
			return createFinPanel(parent, context.dataForCategory(category.getId()));
		}else if(category.getId()==6){
			return createPaymentPanel(parent, context.dataForCategory(category.getId()));
		}else if(category.getId()==7){
			return createDocPanel(parent, context.docs());
		}else if(category.getId()==8){
			return createWorkPanel(parent, context.dataForCategory(category.getId()));
		}else if(category.getId()==9){
			return createTaskPanel(parent, context.dataForCategory(category.getId()));
		}else if(category.getId()==10){
			return createServicePanel(parent, context);
		}
        return new JPanel();
	}
}