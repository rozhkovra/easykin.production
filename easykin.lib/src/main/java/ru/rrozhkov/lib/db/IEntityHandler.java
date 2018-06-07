package ru.rrozhkov.lib.db;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by rrozhkov on 07.06.2018.
 */
public interface IEntityHandler {
    Collection select() throws Exception;
    int insert(IEntity entity) throws SQLException;
    int update(IEntity entity) throws SQLException;
}
