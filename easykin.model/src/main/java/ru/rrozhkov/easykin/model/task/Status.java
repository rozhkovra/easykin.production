package ru.rrozhkov.easykin.model.task;

public enum Status {
	OPEN("Открыта"), 
	CLOSE("Закрыта");
	
    private final String name;       

    private Status (String s) {
        name = s;
    }
    
    public String toString() {
        return this.name;
    }

	public static Status status(int status) {
		Status stat = null;
		switch (status) {
			case 1 : stat = OPEN;break;
			case 2 : stat = CLOSE;break;
			default : stat = OPEN;
		}
    	return stat;
	}
	public static int status(Status status) {
		int stat = 1;
		switch (status) {
			case OPEN : stat = 1;break;
			case CLOSE : stat = 2;break;
			default : stat = 1;
		}
    	return stat;
	}

	public boolean isOpen() {
		return OPEN.equals(this);
	}
	
	public boolean isClose() {
		return CLOSE.equals(this);
	}
}