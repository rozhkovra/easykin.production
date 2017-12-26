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
}