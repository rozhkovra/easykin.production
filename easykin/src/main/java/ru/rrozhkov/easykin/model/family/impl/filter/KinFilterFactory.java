package ru.rrozhkov.easykin.model.family.impl.filter;

import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.family.KinType;
import ru.rrozhkov.lib.filter.IFilter;

public class KinFilterFactory {
	public static IFilter<IKinPerson> create(KinType[] kinTypes){
		return new KinTypeFilter(kinTypes); 
	}
}