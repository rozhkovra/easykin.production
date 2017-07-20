package ru.rrozhkov.easykin.model.fin.payment;

public enum PaymentCategory{
	TASK("Задача"),
	SERVICE("Ком. услуги"),
	AUTO("Машина"), 
	AUTOREPAIR("Ремонт машины"), 
	AUTODETAIL("Детали для машины");
	
    private final String name;       

    private PaymentCategory (String s) {
        name = s;
    }
    
    public String toString() {
        return this.name;
    }
}