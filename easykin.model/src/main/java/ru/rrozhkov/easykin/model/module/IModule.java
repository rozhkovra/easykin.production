package ru.rrozhkov.easykin.model.module;

import ru.rrozhkov.easykin.core.db.IEntity;

/**
 * Created by rrozhkov on 10.10.2018.
 */
public interface IModule extends IEntity {
    int getId();
    String getName();
}
