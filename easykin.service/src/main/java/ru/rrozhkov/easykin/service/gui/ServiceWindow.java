package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.impl.CalcFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.lib.gui.util.ImageUtil;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class ServiceWindow extends JFrame{
	private static final long serialVersionUID = 1L;

	public ServiceWindow(JPanel panel) throws HeadlessException {
		super("EasyKin Калькулятор - Коммунальные услуги");
		setIconImage(ImageUtil.imageByPath(this.getClass(), "/icon/service.png"));
		setContentPane(panel);
    	setExtendedState(ServiceWindow.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setVisible(true);
	}

	public static void main(String[] args){
		Locale.setDefault(new Locale("en"));
		ServiceCalc calc = (ServiceCalc) CalcFactory.createEmptyServiceCalc();

		final ru.rrozhkov.easykin.service.gui.Panel panel = PanelFactory.getPanel(null, calc);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ServiceWindow(panel);
			}
		});
	}
}