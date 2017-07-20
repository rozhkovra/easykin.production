package ru.rrozhkov.easykin.model.task;

public enum Priority {
	IMPOTANT_FAST("Важно и срочно"), 
	IMPOTANT_NOFAST("Важно и не срочно"), 
	SIMPLE("Обычный");
	
    private final String name;       

    private Priority (String s) {
        name = s;
    }
    
    public String toString() {
        return this.name;
    }
    
    public static Priority priority(int i){
		Priority prio = null;
		switch (i) {
			case 1 : prio = IMPOTANT_FAST;break;
			case 2 : prio = IMPOTANT_NOFAST;break;
			default : prio = SIMPLE;
		}
    	return prio;
    }
    
    public static int priority(Priority i){
		int prio = 3;
		switch (i) {
			case IMPOTANT_FAST : prio = 1;break;
			case IMPOTANT_NOFAST : prio = 2;break;
			default : prio = 3;
		}
    	return prio;
    }
}