package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;

public abstract class Calculator implements ICalculator {
	protected ICalculation calc;
	public Calculator(ICalculation calc) {this.calc = calc;}
	public ICalculation getCalc(){return calc;}
}