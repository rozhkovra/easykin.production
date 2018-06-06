package ru.rrozhkov.easykin.task.service.impl;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.task.db.impl.CategoryHandler;
import ru.rrozhkov.lib.collection.CollectionUtil;

import java.util.Collection;

/**
 * Created by rrozhkov on 06.06.2018.
 */
public class CategoryService {
    private static final CategoryHandler categoryHandler = new CategoryHandler();

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
