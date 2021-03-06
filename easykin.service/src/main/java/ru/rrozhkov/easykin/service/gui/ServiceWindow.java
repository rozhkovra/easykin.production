package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.resources.ImageManager;
import ru.rrozhkov.easykin.service.calc.impl.CalcFactory;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.HeadlessException;
import java.util.Locale;

public class ServiceWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final PanelFactory panelFactory = PanelFactory.instance();
	final static private ImageManager imageManager = ImageManager.instance();

	public static JFrame create(JPanel panel) {
		return new ServiceWindow(panel);
	}

	private ServiceWindow(JPanel panel) throws HeadlessException {
		super("EasyKin Калькулятор - Коммунальные услуги");
		setIconImage(imageManager.serviceImg(this.getClass()));
		setContentPane(panel);
    	setExtendedState(ServiceWindow.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setVisible(true);
	}

	public static void main(String[] args){
		Locale.setDefault(new Locale("en"));
		ICalculation calc = CalcFactory.createEmptyServiceCalc();
		final GUIPanel panel = panelFactory.getPanel(null, calc);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				create(panel);
			}
		});
	}
}