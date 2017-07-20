package ru.rrozhkov.lib.db.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;

import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.convert.IConverter;
import ru.rrozhkov.lib.db.IDBManager;

public abstract class DBManager implements IDBManager<ResultSet,Map<String,Object>> {
	protected static IDBManager dbManager;
    private Connection connection;
	private static String nextId = "SELECT MAX(ID)+1 AS ID FROM #table#";
	private static String deleteAll = "DELETE FROM #table#";
    
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
			Collection<T> collection = CollectionUtil.<T>create();
			result = executeQuery(select);
			while(result.next()){
				collection.add((T)converter.convert(result));
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
			Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
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

    protected abstract String getConnectPath();

    protected abstract String getUser();

    protected abstract String getPass();
}