package ru.rrozhkov.easykin.model.fin;

import ru.rrozhkov.easykin.model.fin.util.FormatUtil;

public class Money {
	double value;
	
	public Money() {
		this.value = 0.0;
	}

	public Money(double value) {
		this.value = value;
	}
	
	public Money(Money money) {
		this.value = money.value;
	}

	@Override
	public String toString() {
		return FormatUtil.formatMoney(this);
	}
	
	public Money add(Money money){
		this.value+=money.value;
		return this;
	}

	public Money substract(Money money){
		this.value-=money.value;
		return this;
	}

	public Money multiply(Money money){
		this.value=this.value*money.value;
		return this;
	}
	
	public Money multiply(double money){		
		this.value=this.value*money;
		return this;
	}

	public double getValue() {
		return this.value;
	}
	
	public boolean free(){
		return value==0.0;
	}
}