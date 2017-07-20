package ru.rrozhkov.easykin.model.service.calc.impl.water;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.OdnSimpleCalc;

public class WaterCalc extends OdnSimpleCalc {
	private double hotPrevMesure;
	private double hotCurrentMesure;
	private Money inRate;
	private Money outRate;
	
	public WaterCalc(double coldPrevMesure, double coldCurrentMesure,
			double hotPrevMesure, double hotCurrentMesure, Money inRate,
			Money outRate, Money odn, boolean isPaid) {
		super(coldPrevMesure, coldCurrentMesure, MoneyFactory.create(), odn, isPaid);
		this.hotPrevMesure = hotPrevMesure;
		this.hotCurrentMesure = hotCurrentMesure;
		this.inRate = inRate;
		this.outRate = outRate;
	}
	
	public double getColdPrevMesure() {
		return getPrevMesure();
	}
	public double getColdCurrentMesure() {
		return getCurrentMesure();
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
		setPrevMesure(coldPrevMesure);
	}
	public void setColdCurrentMesure(double coldCurrentMesure) {
		setCurrentMesure(coldCurrentMesure);
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

	public CalculationType getType() {
		return CalculationType.WATER;
	}
}