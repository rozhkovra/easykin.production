package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.gui.color.ColorManager;
import ru.rrozhkov.easykin.gui.style.impl.TableStyle;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceCalcTableStyle extends TableStyle<ServiceCalc>  {
	private static final Map<Integer, CalculationType> column2caclType = new HashMap<Integer, CalculationType>(){
		{
			put(2,CalculationType.WATER);
			put(3,CalculationType.HOTWATER);
			put(4,CalculationType.ELECTRICITY);
			put(5,CalculationType.GAZ);
			put(6,CalculationType.HEATING);
			put(7,CalculationType.ANTENNA);
			put(8,CalculationType.INTERCOM);
			put(9,CalculationType.HOUSE);
			put(10,CalculationType.REPAIR);
		}
	};
	public int[] getColumnAlignment() {
		return new int[]{JLabel.LEFT,JLabel.CENTER,JLabel.RIGHT
				,JLabel.RIGHT,JLabel.RIGHT,JLabel.RIGHT,JLabel.RIGHT,JLabel.RIGHT,JLabel.RIGHT,JLabel.RIGHT,JLabel.RIGHT,JLabel.RIGHT};
	}
	
	public String[] getColumnNames() {
		return new String[]{"Период","Дата", "Вода", "Гор.вода", "Свет", "Газ", "Отопление", "Антенна", "Домофон", "Квартплата", "Кап.ремонт", "Итого"};
	}
	
	public void setColumnStyles(JTable table){
	    super.setColumnStyles(table);
	    table.getColumnModel().getColumn(0).setMinWidth(150);
	    table.getColumnModel().getColumn(0).setMaxWidth(150);
	    table.getColumnModel().getColumn(1).setMinWidth(100);
	    table.getColumnModel().getColumn(1).setMaxWidth(100);
	    table.getColumnModel().getColumn(2).setMinWidth(70);
	    table.getColumnModel().getColumn(2).setMaxWidth(100);
	    table.getColumnModel().getColumn(3).setMinWidth(70);
	    table.getColumnModel().getColumn(3).setMaxWidth(100);
	    table.getColumnModel().getColumn(4).setMinWidth(70);
	    table.getColumnModel().getColumn(4).setMaxWidth(100);
	    table.getColumnModel().getColumn(5).setMinWidth(70);
	    table.getColumnModel().getColumn(5).setMaxWidth(100);
	    table.getColumnModel().getColumn(6).setMinWidth(70);
	    table.getColumnModel().getColumn(6).setMaxWidth(100);
	    table.getColumnModel().getColumn(7).setMinWidth(70);
	    table.getColumnModel().getColumn(7).setMaxWidth(100);
	    table.getColumnModel().getColumn(8).setMinWidth(70);
	    table.getColumnModel().getColumn(8).setMaxWidth(100);
	    table.getColumnModel().getColumn(9).setMinWidth(70);
	    table.getColumnModel().getColumn(9).setMaxWidth(100);
	    table.getColumnModel().getColumn(10).setMinWidth(70);
	    table.getColumnModel().getColumn(10).setMaxWidth(100);
	}
	
	@Override
	public void setCellRenderer(JTable table, final Collection<ServiceCalc> data) {
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
		{
		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		    {
		        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		        setHorizontalAlignment(getColumnAlignment()[column]);
		        ServiceCalc serviceCalc = ((List<ServiceCalc>)data).get(row); 
		        if(serviceCalc.isPaid()){
    				c.setBackground(ColorManager.done());
    				c.setFont(c.getFont().deriveFont(Font.BOLD,15));
    				return c;
    			}else
    				c.setBackground(ColorManager.open());
		        for(ICalculation calc : serviceCalc.calcs()){
		        	CalculationType type = column2caclType.get(column);
		        	if(type!= null && calc.isPaid() && type.equals(calc.getType())){
		        		c.setFont(c.getFont().deriveFont(Font.BOLD,15));
		        		c.setBackground(ColorManager.done());
		        	}
		        }
		        return c;
		    }		    
		});
	}
}
