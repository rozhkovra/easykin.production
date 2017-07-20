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
}