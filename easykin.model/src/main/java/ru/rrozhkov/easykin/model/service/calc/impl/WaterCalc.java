package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;

public class WaterCalc extends Calculation {
	private static final int VERSION = 1;
	private MeasureCalc coldCalc;
	private MeasureCalc hotCalc;
	private Money inRate;
	private Money outRate;

	public WaterCalc(double coldPrevMeasure, double coldCurrentMeasure,
						  double coldPrevMeasure2, double coldCurrentMeasure2,
						  double hotPrevMeasure, double hotCurrentMeasure,
						  double hotPrevMeasure2, double hotCurrentMeasure2,
						  Money inRate, Money outRate, boolean isPaid) {
		this(-1, -1, coldPrevMeasure, coldCurrentMeasure, coldPrevMeasure2, coldCurrentMeasure2, hotPrevMeasure,
				hotCurrentMeasure, hotPrevMeasure2, hotCurrentMeasure2, inRate, outRate, isPaid);
	}

	public WaterCalc(int id, int readingId,
					 double coldPrevMeasure, double coldCurrentMeasure,
					 double coldPrevMeasure2, double coldCurrentMeasure2,
					 double hotPrevMeasure, double hotCurrentMeasure,
					 double hotPrevMeasure2, double hotCurrentMeasure2,
					 Money inRate, Money outRate, boolean isPaid) {
		super(id, readingId, CalculationType.WATER, isPaid, Money.valueOf(0.00), VERSION);
		this.coldCalc = new MeasureCalc(CollectionUtil.create((int)coldPrevMeasure, (int)coldPrevMeasure2),
				CollectionUtil.create((int)coldCurrentMeasure, (int)coldCurrentMeasure2),
				MoneyFactory.create(inRate).add(outRate), isPaid, CalculationType.WATER);
		this.hotCalc = new MeasureCalc(CollectionUtil.create((int)hotPrevMeasure, (int)hotPrevMeasure2),
				CollectionUtil.create((int)hotCurrentMeasure, (int)hotCurrentMeasure2),
				outRate, isPaid, CalculationType.WATER);
		this.inRate = inRate;
		this.outRate = outRate;
	}


	public Money getInRate() {
		return inRate;
	}

	public Money getOutRate() {
		return outRate;
	}

	public int getColdCurrentMeasure(int i) {
		return coldCalc.getCurrentMeasure(i);
	}

	public int getHotCurrentMeasure(int i) {
		return hotCalc.getCurrentMeasure(i);
	}

	public int getColdPrevMeasure(int i) {
		return coldCalc.getPrevMeasure(i);
	}

	public int getHotPrevMeasure(int i) {
		return hotCalc.getPrevMeasure(i);
	}

	public int getColdCurrentMeasure() {
		return coldCalc.getCurrentMeasure();
	}

	public int getHotCurrentMeasure() {
		return hotCalc.getCurrentMeasure();
	}

	public int getColdPrevMeasure() {
		return coldCalc.getPrevMeasure();
	}

	public int getHotPrevMeasure() {
		return hotCalc.getPrevMeasure();
	}
}