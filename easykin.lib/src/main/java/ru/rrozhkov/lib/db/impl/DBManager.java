package ru.rrozhkov.lib.db.impl;

import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.convert.IConverter;
import ru.rrozhkov.lib.convert.IEntityConverter;
import ru.rrozhkov.lib.db.IDBManager;
import ru.rrozhkov.lib.db.impl.exception.NotFoundDBPropertiesException;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

public class DBManager implements IDBManager<ResultSet,Map<String,Object>> {
	protected static IDBManager dbManager;
    private Connection connection;
	private static final String jdbcProperties = "jdbc.properties";
	private static String nextId = "SELECT MAX(ID)+1 AS ID FROM #table#";
	private static String deleteAll = "DELETE FROM #table#";
	private String connectDriver;
	private String connectPath;
	private String user;
	private String pass;

	public DBManager(String connectDriver, String connectPath, String user, String pass) {
		this.connectDriver = connectDriver;
		this.connectPath = connectPath;
		this.user = user;
		this.pass = pass;
	}

	public static IDBManager instance(){
		if(dbManager==null){
			Properties property=new Properties();
			try {
				URL iconUrl = IDBManager.class.getResource("/"+jdbcProperties);
				property.load(iconUrl.openStream());
			} catch (IOException e) {
				System.out.print(new NotFoundDBPropertiesException(e).getMessage());
			}
			String connectionDriver = property.getProperty("connectionDriver");
			String connectionPath = property.getProperty("connectionPath");
			String user = property.getProperty("user");
			String pass = property.getProperty("pass");
			dbManager = new DBManager(connectionDriver, connectionPath, user, pass);
		}
		return dbManager;
	}
    /* (non-Javadoc)
	 * @see ru.rrozhkov.lib.db.impl.IDBManager#nextId(java.lang.String)
	 */
    public int nextId(String tableName) throws SQLException {
		ResultSet result = null;
		try {
			int id = -1;
			result = executeQuery(nextId.replace("#table#", tableName));
			while(result.next()){
				id = result.getInt("ID");
			}
			return id;
		} catch (Exception e) { 
			throw new SQLException(e); 
		} finally {
			try {
				if(result!=null)
					result.close();
			}catch (SQLException e) {
				throw new SQLException(e);
			}
		}
    }
	
	/* (non-Javadoc)
	 * @see ru.rrozhkov.lib.db.impl.IDBManager#select(java.lang.String, ru.rrozhkov.lib.convert.IConverter)
	 */
	public <T> Collection<T> select(String select, IConverter<ResultSet,T> converter) throws SQLException {
		ResultSet result = null;
		try {
			Collection<T> collection = CollectionUtil.create();
			result = executeQuery(select);
			while(result.next()){
				collection.add(converter.convert(result));
			}
			return collection;
		} catch (Exception e) { 
			throw new SQLException(e); 
		} finally {
			try {
				if(result!=null)
					result.close();
			}catch (SQLException e) {
				throw new SQLException(e);			
			}
		} 
	}
	
	public int insert(String sql, Map<String, Object> map) throws SQLException {
		for(String key : map.keySet()){
			sql=sql.replace("#"+key+"#", String.valueOf(map.get(key)));
		}
		return executeUpdate(sql);
	}
	
	
	
	public int update(String sql, Map<String, Object> map) throws SQLException {
		for(String key : map.keySet()){
			sql=sql.replace("#"+key+"#", String.valueOf(map.get(key)));
		}
		return executeUpdate(sql);
	}

	public int deleteAll(String tableName) throws SQLException {
		return executeUpdate(deleteAll.replace("#table#", tableName));
	}

	public <T> Collection<T> select(String select, IEntityConverter<T> converter) throws SQLException {
		ResultSet result = null;
		try {
			Collection<T> collection = CollectionUtil.create();
			result = executeQuery(select);
			while(result.next()){
				collection.add(converter.entity(result));
			}
			return collection;
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			try {
				if(result!=null)
					result.close();
			}catch (SQLException e) {
				throw new SQLException(e);
			}
		}
	}

	/* (non-Javadoc)
	 * @see ru.rrozhkov.lib.db.impl.IDBManager#executeQuery(java.lang.String)
	 */
	protected ResultSet executeQuery(String query) throws SQLException{
		Statement stmt = null;  
		try { 
			stmt = openStatement(); 
			return stmt.executeQuery(query);
		} catch (Exception e) { 
			throw new SQLException(e); 
		} finally {
			try {
				closeStatement(stmt);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see ru.rrozhkov.lib.db.impl.IDBManager#executeUpdate(java.lang.String)
	 */
	protected int executeUpdate(String query) throws SQLException {
		Statement stmt = null;  
		try { 
			stmt = openStatement(); 
			return stmt.executeUpdate(query);
		} catch (Exception e) { 
			throw new SQLException(e); 
		} finally {
			try {
				closeStatement(stmt);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
    
    protected Connection connect() throws ClassNotFoundException, SQLException{
		if(connection==null || connection.isClosed()){
			Class.forName(getConnectDriver());
			connection =  DriverManager.getConnection( getConnectPath(), getUser(), getPass());
		}
		return connection;
    }

    protected boolean disconnect() throws SQLException{
    	if(connection!=null && !connection.isClosed()){
    		connection.close();
    		return true;
    	}
    	return false;
    }
    
    protected Statement openStatement() throws SQLException, ClassNotFoundException{
		return connect().createStatement();
	}

    protected boolean closeStatement(Statement stmt) throws SQLException{
		if(stmt!=null && !stmt.isClosed()){
			stmt.close();
			return disconnect();
		}
		return false;
	}

    protected String getConnectPath(){
		return this.connectPath;
	}
	
    protected String getUser(){
		return this.user;
	}

    protected String getPass(){
		return this.pass;
	}

	protected String getConnectDriver() {
		return connectDriver;
	}
}