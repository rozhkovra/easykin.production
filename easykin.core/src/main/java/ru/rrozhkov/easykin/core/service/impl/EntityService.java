package ru.rrozhkov.easykin.core.service.impl;

import ru.rrozhkov.easykin.core.db.IEntity;
import ru.rrozhkov.easykin.core.db.IEntityHandler;
import ru.rrozhkov.easykin.core.service.IEntityService;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by rrozhkov on 19.12.2018.
 */
public abstract class EntityService implements IEntityService {
    private IEntityHandler handler;

    protected EntityService(IEntityHandler handler) {
        this.handler = handler;
    }

    public int createOrUpdate(final IEntity entity){
        int id = entity.getId();
        try{
            if (id == -1) {
                id = create(entity);
            } else {
                id = update(entity);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return id;
    }

    protected int create(final IEntity entity) throws SQLException {
        return handler.insert(entity);
    }

    protected int update(final IEntity entity) throws SQLException {
        handler.update(entity);
        return entity.getId();

    }

    protected Collection findAll() throws Exception {
        return handler.select();
    }
}
