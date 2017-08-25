package ru.rrozhkov.easykin.model.fin.payment;

public enum PaymentCategory{
    PAYMENT("Платеж"),
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

    public static PaymentCategory category(int id){
        PaymentCategory stat = null;
        switch (id) {
            case 1 : stat = TASK;break;
            case 2 : stat = SERVICE;break;
            case 3 : stat = AUTO;break;
            case 4 : stat = AUTOREPAIR;break;
            case 5 : stat = AUTODETAIL;break;
            default : stat = PAYMENT;
        }
        return stat;
    }
    public static int category(PaymentCategory category) {
        int stat = 0;
        switch (category) {
            case TASK : stat = 1;break;
            case SERVICE : stat = 2;break;
            case AUTO : stat = 3;break;
            case AUTOREPAIR : stat = 4;break;
            case AUTODETAIL : stat = 5;break;
            default : stat = 0;
        }
        return stat;
    }
}