package ru.rrozhkov.easykin.model.service.calc.impl.water;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.DoubleSimpleCalc;

public class WaterCalc extends DoubleSimpleCalc {
	private double hotPrevMeasure;
	private double hotCurrentMeasure;
	private double hotPrevMeasure2;
	private double hotCurrentMeasure2;
	private Money inRate;
	private Money outRate;
	
	public WaterCalc(double coldPrevMeasure, double coldCurrentMeasure,
					 double coldPrevMeasure2, double coldCurrentMeasure2,
					 double hotPrevMeasure, double hotCurrentMeasure,
					 double hotPrevMeasure2, double hotCurrentMeasure2,
					 Money inRate, Money outRate, boolean isPaid) {
		super(coldPrevMeasure, coldCurrentMeasure, coldPrevMeasure2, coldCurrentMeasure2, Money.valueOf(0.00), isPaid);
		this.hotPrevMeasure = hotPrevMeasure;
		this.hotCurrentMeasure = hotCurrentMeasure;
		this.hotPrevMeasure2 = hotPrevMeasure2;
		this.hotCurrentMeasure2 = hotCurrentMeasure2;
		this.inRate = inRate;
		this.outRate = outRate;
	}
	
	public double getColdPrevMeasure() {
		return getPrevMeasure();
	}
	public double getColdCurrentMeasure() {
		return getCurrentMeasure();
	}
	public double getColdPrevMeasure2() {
		return getPrevMeasure2();
	}
	public double getColdCurrentMeasure2() {
		return getCurrentMeasure2();
	}
	public double getHotPrevMeasure() {
		return hotPrevMeasure;
	}
	public double getHotCurrentMeasure() {
		return hotCurrentMeasure;
	}
	public double getHotPrevMeasure2() {
		return hotPrevMeasure2;
	}
	public double getHotCurrentMeasure2() {
		return hotCurrentMeasure2;
	}
	public Money getInRate() {
		return inRate;
	}
	public Money getOutRate() {
		return outRate;
	}
	public void setColdPrevMeasure(double coldPrevMeasure) {
		setPrevMeasure(coldPrevMeasure);
	}
	public void setColdCurrentMeasure(double coldCurrentMeasure) {
		setCurrentMeasure(coldCurrentMeasure);
	}
	public void setHotPrevMeasure(double hotPrevMeasure) {
		this.hotPrevMeasure = hotPrevMeasure;
	}
	public void setHotCurrentMeasure(double hotCurrentMeasure) {
		this.hotCurrentMeasure = hotCurrentMeasure;
	}
	public void setInRate(Money inRate) {
		this.inRate = inRate;
	}
	public void setOutRate(Money outRate) {
		this.outRate = outRate;
	}
	public void setHotPrevMeasure2(double hotPrevMeasure2) {
		this.hotPrevMeasure2 = hotPrevMeasure2;
	}
	public void setHotCurrentMeasure2(double hotCurrentMeasure2) {
		this.hotCurrentMeasure2 = hotCurrentMeasure2;
	}
	public void setColdPrevMeasure2(double coldPrevMeasure) {
		setPrevMeasure2(coldPrevMeasure);
	}
	public void setColdCurrentMeasure2(double coldCurrentMeasure) {
		setCurrentMeasure2(coldCurrentMeasure);
	}

	public CalculationType getType() {
		return CalculationType.WATER;
	}
}