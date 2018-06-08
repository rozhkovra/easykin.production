package ru.rrozhkov.lib.db.impl;

import ru.rrozhkov.lib.convert.IEntityConverter;
import ru.rrozhkov.lib.db.IDBManager;
import ru.rrozhkov.lib.db.IEntity;
import ru.rrozhkov.lib.db.IEntityHandler;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

/**
 * Created by rrozhkov on 07.06.2018.
 */
public abstract class EntityHandler implements IEntityHandler {
    private static final IDBManager dbManager = DBManager.instance();

    public Collection select() throws Exception {
        return dbManager.select(getSelect(), getConverter());
    }

    public int insert(IEntity entity) throws SQLException {
        try {
            Map<String, Object> map = getConverter().map(entity);
            int id = dbManager.nextId(getTableName());
            map.put("id", id);
            dbManager.insert(getInsert(), map);
            return id;
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    public int update(IEntity entity) throws SQLException {
        try {
            Map<String, Object> map = getConverter().map(entity);
            int count = dbManager.update(getUpdate(), map);
            return count;
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    protected static IDBManager dbManager() {
        return dbManager;
    }
    protected abstract String getTableName();
    protected abstract IEntityConverter getConverter();
    protected String getSelect() {
        return "SELECT * FROM " + getTableName();
    }
    protected String getInsert() {
        return null;
    }
    protected String getUpdate() {
        return null;
    }
}
