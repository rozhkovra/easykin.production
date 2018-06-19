package ru.rrozhkov.easykin.auto.data.impl.stat;

import ru.rrozhkov.easykin.model.auto.Body;
import ru.rrozhkov.easykin.model.auto.Brend;
import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.easykin.model.auto.Model;
import ru.rrozhkov.easykin.model.auto.impl.CarFactory;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.core.data.impl.SingleCollectionDataProvider;

public class StaticServiceHistoryDataProvider extends SingleCollectionDataProvider<IService, ICar> {
	final static private CarFactory carFactory = CarFactory.instance();
	private static final StaticAutoServiceDataProvider dataProvider = StaticAutoServiceDataProvider.instance();
	public static class Holder {
		public static final StaticServiceHistoryDataProvider INSTANCE = new StaticServiceHistoryDataProvider();
	}

	public static StaticServiceHistoryDataProvider instance(){
		return Holder.INSTANCE;
	}

	private StaticServiceHistoryDataProvider() {
		super(dataProvider.getData(), carFactory.createCar(Brend.TOYOTA, Model.VISTA, Body.SEDAN, 1995, 1.8));
	}
}