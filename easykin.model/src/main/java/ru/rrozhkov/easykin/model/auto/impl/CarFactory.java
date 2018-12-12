package ru.rrozhkov.easykin.model.auto.impl;

import ru.rrozhkov.easykin.model.auto.Body;
import ru.rrozhkov.easykin.model.auto.Brend;
import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.easykin.model.auto.Model;
import ru.rrozhkov.easykin.model.doc.IDoc;
import ru.rrozhkov.easykin.model.person.IPerson;

public class CarFactory {
	private static class Holder {
		private static final CarFactory INSTANCE = new CarFactory();
	}

	public static CarFactory instance(){
		return Holder.INSTANCE;
	}

	private CarFactory() {
	}

	public ICar createRegisteredCar(Brend brend, Model model, Body body, int year, double volume, IPerson owner, IDoc doc){
		return new RegisteredCar(brend, model, body, year, volume, owner, doc);
	}
	public ICar createCar(Brend brend, Model model, Body body, int year, double volume){
		return new Car(brend, model, body, year, volume);
	}
}