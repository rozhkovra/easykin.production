package ru.rrozhkov.easykin.service.gui;


import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;
import ru.rrozhkov.easykin.service.db.impl.calc2.CalcHandler;

import javax.swing.JCheckBox;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ShortPanel extends Panel {
	private JCheckBox paidCheckBox;
	private CalcHandler calcHandler = CalcHandler.instance();

	protected ShortPanel(GUIPanel parent, Calculation calc) {
		super(parent, calc);
		fill();
	}

	public void fill() {
		refresh();
		setLayout(guiFactory.gridLayout(1, 3));
		add(getCalcTypeLabel());
		add(getItogoLabel());
		add(getPaidCheckBox());
	}

	private Component getPaidCheckBox() {
		if(paidCheckBox == null) {
			paidCheckBox = (JCheckBox) guiFactory.checkBox("Оплачено", calc.isPaid());
			if (calc.isPaid()) {
				paidCheckBox.setEnabled(false);
			}
			paidCheckBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					savePaid();
				}
			});
		}
		return paidCheckBox;
	}

	private void savePaid() {
		if (paidCheckBox.isSelected()) {
			((Calculation)calc).setPaid(true);
		}
		try {
			calcHandler.update(calc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		paidCheckBox.setEnabled(false);
	}

	@Override
	public void updateBean() {

	}
}