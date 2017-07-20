package ru.rrozhkov.easykin.model.family;

public enum KinType {
	FATHER("Папа"), 
	MOTHER("Мама"), 
	SUN("Сын"), 
	DAUGHTER("Дочь");
	
    private final String name;       

    private KinType (String s) {
        name = s;
    }
    
    public static KinType kin(String s){
    	if("F".equals(s))
    		return FATHER;
    	if("M".equals(s))
    		return MOTHER;
    	if("D".equals(s))
    		return DAUGHTER;
    	if("S".equals(s))
    		return SUN;
    	return null;
    }
    public String toString() {
        return this.name;
    }
}