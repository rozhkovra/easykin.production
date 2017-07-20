package ru.rrozhkov.easykin.model.fin.payment;


public enum PaymentStatus {
	PLAN("План"), 
	FACT("Факт");
	
    private final String name;       

    private PaymentStatus (String s) {
        name = s;
    }
    
    public String toString() {
        return this.name;
    }

	public static PaymentStatus status(int status) {
		PaymentStatus stat = null;
		switch (status) {
			case 1 : stat = PLAN;break;
			case 2 : stat = FACT;break;
			default : stat = PLAN;
		}
    	return stat;
	}
	public static int status(PaymentStatus status) {
		int stat = 1;
		switch (status) {
			case PLAN : stat = 1;break;
			case FACT : stat = 2;break;
			default : stat = 1;
		}
    	return stat;
	}

	public boolean isPlan() {
		return PLAN.equals(this);
	}
	
	public boolean isFact() {
		return FACT.equals(this);
	}	
}