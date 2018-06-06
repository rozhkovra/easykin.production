package ru.rrozhkov.easykin.auto.data.impl.stat;

import ru.rrozhkov.easykin.model.auto.Body;
import ru.rrozhkov.easykin.model.auto.Brend;
import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.easykin.model.auto.Model;
import ru.rrozhkov.easykin.model.auto.impl.CarFactory;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.lib.data.impl.SingleCollectionDataProvider;

public class StaticServiceHistoryDataProvider extends SingleCollectionDataProvider<IService, ICar> {
	final static private CarFactory carFactory = new CarFactory();
	public StaticServiceHistoryDataProvider() {
		super(new StaticAutoServiceDataProvider().getData(), carFactory.createCar(Brend.TOYOTA, Model.VISTA, Body.SEDAN, 1995, 1.8));
	}
}