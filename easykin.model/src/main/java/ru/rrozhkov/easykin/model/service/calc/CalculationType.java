package ru.rrozhkov.easykin.model.service.calc;

public enum CalculationType {
	HEATING("Отопление"),
	ANTENNA("Антенна"),
	INTERCOM("Домофон"),
	ELECTRICITY("Электричество"),
	GAZ("Газ"),
	WATER("Вода"),
	HOTWATER("Горячая вода"),
	HOUSE("Квартплата"),
	REPAIR("Кап.ремонт"),
	ALL("Все");
	
    private final String name;       

    private CalculationType (String s) {
        name = s;
    }
    
    public String toString() {
        return this.name;
    }

	public boolean isHeating() {
		return this.equals(HEATING);
	}
	public boolean isAntenna() {
		return this.equals(ANTENNA);
	}
	public boolean isIntercom() {
		return this.equals(INTERCOM);
	}
	public boolean isElectricity() {
		return this.equals(ELECTRICITY);
	}
	public boolean isGaz() {
		return this.equals(GAZ);
	}
	public boolean isWater() {
		return this.equals(WATER);
	}
	public boolean isHotWater() {
		return this.equals(HOTWATER);
	}
	public boolean isHouse() {
		return this.equals(HOUSE);
	}
	public boolean isRepair() {
		return this.equals(REPAIR);
	}

	public static CalculationType type(String type) {
		if(HEATING.toString().equals(type))
			return HEATING;
		else if(ANTENNA.toString().equals(type))
			return ANTENNA;
		else if(INTERCOM.toString().equals(type))
			return INTERCOM;
		else if(ELECTRICITY.toString().equals(type))
			return ELECTRICITY;
		else if(GAZ.toString().equals(type))
			return GAZ;
		else if(WATER.toString().equals(type))
			return WATER;
		else if(HOTWATER.toString().equals(type))
			return HOTWATER;
		else if(HOUSE.toString().equals(type))
			return HOUSE;
		else if(REPAIR.toString().equals(type))
			return REPAIR;

		return null;
	}
}