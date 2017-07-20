package ru.rrozhkov.easykin.gui;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.gui.auto.service.AutoServiceEditor;
import ru.rrozhkov.easykin.gui.auto.service.AutoServiceForm;
import ru.rrozhkov.easykin.gui.doc.DocForm;
import ru.rrozhkov.easykin.gui.payment.PaymentForm;
import ru.rrozhkov.easykin.gui.person.PersonForm;
import ru.rrozhkov.easykin.gui.service.ServiceCalcForm;
import ru.rrozhkov.easykin.gui.task.CommentForm;
import ru.rrozhkov.easykin.gui.task.TaskEditor;
import ru.rrozhkov.easykin.gui.task.TaskForm;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.doc.IDoc;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.ITask;

import javax.swing.*;

public class FormFactory {
	public static JPanel createServiceCalcForm( Object obj){
		if(obj!=null && obj instanceof ServiceCalc)
			return new ServiceCalcForm((ServiceCalc)obj);
		return new JPanel();
	}
	public static JPanel createTaskForm(MasterDataContext context,IGUIEditor parent, Object obj){
		if(obj!=null && obj instanceof ITask)
			return new TaskForm(context, parent,(ITask)obj);
		return new TaskForm(context, parent);
	}
	public static JPanel createTaskEditor(MasterDataContext context,IGUIEditor parent, Object obj){
		if(obj!=null && obj instanceof ITask)
			return new TaskEditor(context, (EasyKinWindow)parent,(ITask)obj);
		return new TaskEditor(context, (EasyKinWindow)parent);
	}
	public static JPanel createAutoServiceForm(IGUIEditor parent, Object obj){
		if(obj!=null && obj instanceof IService)
			return new AutoServiceForm(parent,(IService)obj);
		return new AutoServiceForm(parent);
	}
	public static JPanel createAutoServiceEditor(IGUIEditor parent, Object obj){
		if(obj!=null && obj instanceof IService)
			return new AutoServiceEditor((EasyKinWindow)parent,(IService)obj);
		return new AutoServiceEditor((EasyKinWindow)parent);
	}
	public static JPanel createPaymentForm(MasterDataContext context,IGUIEditor parent, Object obj){
		if(obj!=null && obj instanceof IPayment)
			return new PaymentForm(parent,(IPayment)obj);
		return new PaymentForm(parent);
	}

	private static JPanel createPersonForm(MasterDataContext context, IGUIEditor parent, Object obj) {
		if(obj!=null && obj instanceof IPerson)
			return new PersonForm(parent,(IPerson)obj);
		return new JPanel();
	}

	public static JPanel createCommentForm(MasterDataContext context, IGUIEditor parent, Object obj, int id){
		if(obj!=null && obj instanceof IComment)
			return new CommentForm(context, parent,(IComment)obj);
		return new CommentForm(context, parent, id);
	}

	private static JPanel createDocForm(MasterDataContext context, IGUIEditor parent, Object obj) {
		if(obj!=null && obj instanceof IDoc)
			return new DocForm(parent,(IDoc)obj);
		return new JPanel();
	}

	public static JPanel getFormPanel(MasterDataContext context, IGUIEditor parent, Object obj) {
		ICategory category = context.currentCategory();
		if(category.getId()==1){
			return createTaskEditor(context, parent,obj);
		}else if(category.getId()==2){
			return createPersonForm(context, parent, obj);
		}else if(category.getId()==3){
			return createPersonForm(context, parent,obj);
		}else if(category.getId()==4){
			return createAutoServiceEditor(parent,obj);
		}else if(category.getId()==5){
			return createPaymentForm(context, parent, obj);
		}else if(category.getId()==6){
			return createPaymentForm(context, parent, obj);
		}else if(category.getId()==7){
			return createDocForm(context, parent, obj);
		}else if(category.getId()==8){
			return createTaskEditor(context, parent, obj);
		}else if(category.getId()==9){
			return createTaskEditor(context, parent,obj);
		}else if(category.getId()==10){
			return createServiceCalcForm(obj);
		}
		return new JPanel();
	}
}
