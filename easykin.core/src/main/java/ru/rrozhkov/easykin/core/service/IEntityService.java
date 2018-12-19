package ru.rrozhkov.easykin.core.service;

import ru.rrozhkov.easykin.core.db.IEntity;

/**
 * Created by rrozhkov on 19.12.2018.
 */
public interface IEntityService {
    int createOrUpdate(final IEntity entity);
}
