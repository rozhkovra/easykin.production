package ru.rrozhkov.easykin.model.service.calc.impl.water;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.DoubleSimpleCalc;

public class WaterCalc extends DoubleSimpleCalc {
	private double hotPrevMesure;
	private double hotCurrentMesure;
	private double hotPrevMesure2;
	private double hotCurrentMesure2;
	private Money inRate;
	private Money outRate;
	
	public WaterCalc(double coldPrevMesure, double coldCurrentMesure,
					 double coldPrevMesure2, double coldCurrentMesure2,
					 double hotPrevMesure, double hotCurrentMesure,
					 double hotPrevMesure2, double hotCurrentMesure2,
					 Money inRate, Money outRate, boolean isPaid) {
		super(coldPrevMesure, coldCurrentMesure, coldPrevMesure2, coldCurrentMesure2, Money.valueOf(0.00), isPaid);
		this.hotPrevMesure = hotPrevMesure;
		this.hotCurrentMesure = hotCurrentMesure;
		this.hotPrevMesure2 = hotPrevMesure2;
		this.hotCurrentMesure2 = hotCurrentMesure2;
		this.inRate = inRate;
		this.outRate = outRate;
	}
	
	public double getColdPrevMesure() {
		return getPrevMeasure();
	}
	public double getColdCurrentMesure() {
		return getCurrentMeasure();
	}
	public double getColdPrevMesure2() {
		return getPrevMesure2();
	}
	public double getColdCurrentMesure2() {
		return getCurrentMesure2();
	}
	public double getHotPrevMesure() {
		return hotPrevMesure;
	}
	public double getHotCurrentMesure() {
		return hotCurrentMesure;
	}
	public Money getInRate() {
		return inRate;
	}
	public Money getOutRate() {
		return outRate;
	}
	public void setColdPrevMesure(double coldPrevMesure) {
		setPrevMeasure(coldPrevMesure);
	}
	public void setColdCurrentMesure(double coldCurrentMesure) {
		setCurrentMeasure(coldCurrentMesure);
	}
	public void setHotPrevMesure(double hotPrevMesure) {
		this.hotPrevMesure = hotPrevMesure;
	}
	public void setHotCurrentMesure(double hotCurrentMesure) {
		this.hotCurrentMesure = hotCurrentMesure;
	}
	public void setInRate(Money inRate) {
		this.inRate = inRate;
	}
	public void setOutRate(Money outRate) {
		this.outRate = outRate;
	}
	public double getHotPrevMesure2() {
		return hotPrevMesure2;
	}
	public void setHotPrevMesure2(double hotPrevMesure2) {
		this.hotPrevMesure2 = hotPrevMesure2;
	}
	public double getHotCurrentMesure2() {
		return hotCurrentMesure2;
	}
	public void setHotCurrentMesure2(double hotCurrentMesure2) {
		this.hotCurrentMesure2 = hotCurrentMesure2;
	}
	public void setColdPrevMesure2(double coldPrevMesure) {
		setPrevMesure2(coldPrevMesure);
	}
	public void setColdCurrentMesure2(double coldCurrentMesure) {
		setCurrentMesure2(coldCurrentMesure);
	}

	public CalculationType getType() {
		return CalculationType.WATER;
	}
}