package ru.rrozhkov.easykin.model.family.impl.filter;

import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.family.KinType;
import ru.rrozhkov.lib.filter.IFilter;

public class KinTypeFilter implements IFilter<IKinPerson>{
	private KinType[] kinTypes;

	public KinTypeFilter(KinType[] kinTypes) {
		this.kinTypes = kinTypes;
	}
	
	public boolean filter(IKinPerson obj){
		for(KinType kinType : kinTypes){
			if(kinType.equals(obj.getKinType()))
				return true;
		}
		return false;
	}
}