package ru.rrozhkov.easykin.task.service.impl;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.db.impl.EntityHandler;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.task.db.impl.TaskHandlerFactory;

import java.util.Collection;

/**
 * Created by rrozhkov on 06.06.2018.
 */
public class CategoryService {
    private static final EntityHandler categoryHandler = TaskHandlerFactory.instance().category();

    private static class Holder {
        private static final CategoryService INSTANCE = new CategoryService();
    }

    private CategoryService() {
    }

    static CategoryService instance(){
        return Holder.INSTANCE;
    }

    public Collection<ICategory> categories() {
        Collection<ICategory> collection = CollectionUtil.create();
        try {
            collection = categoryHandler.select();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return collection;
    }
}
