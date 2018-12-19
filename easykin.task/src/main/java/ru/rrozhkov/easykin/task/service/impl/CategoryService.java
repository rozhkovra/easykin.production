package ru.rrozhkov.easykin.task.service.impl;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.service.impl.EntityService;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.task.db.impl.TaskHandlerFactory;

import java.util.Collection;

/**
 * Created by rrozhkov on 06.06.2018.
 */
public class CategoryService extends EntityService {
    private static class Holder {
        private static final CategoryService INSTANCE = new CategoryService();
    }

    private CategoryService() {
        super(TaskHandlerFactory.instance().category());
    }

    static CategoryService instance(){
        return Holder.INSTANCE;
    }

    public Collection<ICategory> categories() {
        Collection<ICategory> collection = CollectionUtil.create();
        try {
            collection = findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return collection;
    }
}
