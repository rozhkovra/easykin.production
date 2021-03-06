package ru.rrozhkov.easykin.core.db;

import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;

import java.sql.SQLException;
import java.util.Collection;

public interface IDBManager<A, B> {

	int nextId(String tableName) throws SQLException;

	<T> Collection<T> select(String select,
			IConverter<A, T> converter) throws SQLException;
	
	int insert(String sql, B map)  throws SQLException;
	
	int update(String sql, B map)  throws SQLException;

	int deleteAll(String tableName) throws SQLException;

	<T> Collection<T> select(String select,
							 IEntityConverter<T> converter) throws SQLException;

}