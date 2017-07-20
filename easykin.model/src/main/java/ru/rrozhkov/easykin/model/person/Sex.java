package ru.rrozhkov.easykin.model.person;

public enum Sex {
	MALE("М"), 
	FEMALE("Ж");
	
    private final String name;       

    private Sex (String s) {
        name = s;
    }
    
    public static Sex sex(String s){
    	if("M".equals(s))
    		return MALE;
    	return FEMALE;
    }
    
    public String toString() {
        return this.name;
    }
}