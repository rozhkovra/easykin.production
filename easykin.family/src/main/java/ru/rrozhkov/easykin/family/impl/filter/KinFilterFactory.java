package ru.rrozhkov.easykin.family.impl.filter;

import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.family.KinType;
import ru.rrozhkov.lib.filter.IFilter;

public class KinFilterFactory {
	public IFilter<IKinPerson> create(KinType[] kinTypes){
		return new KinTypeFilter(kinTypes); 
	}
}