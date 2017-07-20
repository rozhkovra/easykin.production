package ru.rrozhkov.easykin.db.impl;

import ru.rrozhkov.lib.db.IDBManager;
import ru.rrozhkov.lib.db.impl.DBManager;

public class EasyKinDBManager extends DBManager{

    private EasyKinDBManager(){    	
    }
    
    public static IDBManager instance(){
    	if(dbManager==null){
   	    	dbManager = new EasyKinDBManager();
    	}
    	return dbManager;
    }

	@Override
	protected String getConnectPath() {
		return "jdbc:hsqldb:hsql://localhost/easykin";
	}

	@Override
	protected String getUser() {
		return "SA";
	}

	@Override
	protected String getPass() {
		return "";
	}    
}