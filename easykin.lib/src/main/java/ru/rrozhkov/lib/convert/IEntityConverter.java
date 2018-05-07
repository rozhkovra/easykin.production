package ru.rrozhkov.lib.convert;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.Map;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public interface IEntityConverter<T> {
    String sqlInsert(T entity);
    Map<String, Object> map(T entity);
    String[] stringArr(Collection<T> entries);
    T entity(ResultSet resultSet);
}
