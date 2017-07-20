package ru.rrozhkov.easykin.data.impl.stat;

import ru.rrozhkov.easykin.model.auto.Body;
import ru.rrozhkov.easykin.model.auto.Brend;
import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.easykin.model.auto.Model;
import ru.rrozhkov.easykin.model.auto.impl.CarFactory;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.lib.data.impl.SingleCollectionDataProvider;

public class StaticServiceHistoryDataProvider extends SingleCollectionDataProvider<IService, ICar> {
	public StaticServiceHistoryDataProvider() {
		super(new StaticAutoServiceDataProvider().getData(), CarFactory.createCar(Brend.TOYOTA, Model.VISTA, Body.SEDAN, 1995, 1.8));
	}
}