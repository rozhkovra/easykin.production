package ru.rrozhkov.easykin.family.impl.filter;

import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.family.KinType;
import ru.rrozhkov.lib.filter.IFilter;

public class KinFilterFactory {
	public static class KinFilterFactoryHolder {
		public static final KinFilterFactory INSTANCE = new KinFilterFactory();
	}

	public static KinFilterFactory instance(){
		return KinFilterFactoryHolder.INSTANCE;
	}

	public IFilter<IKinPerson> create(KinType[] kinTypes){
		return new KinTypeFilter(kinTypes); 
	}
}