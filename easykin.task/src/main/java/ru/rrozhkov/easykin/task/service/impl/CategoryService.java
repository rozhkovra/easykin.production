package ru.rrozhkov.easykin.task.service.impl;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.task.db.impl.CategoryHandler;
import ru.rrozhkov.lib.collection.CollectionUtil;

import java.util.Collection;

/**
 * Created by rrozhkov on 06.06.2018.
 */
public class CategoryService {
    private static final CategoryHandler categoryHandler = CategoryHandler.instance();

    public static class CategoryServiceHolder {
        public static final CategoryService INSTANCE = new CategoryService();
    }

    public static CategoryService instance(){
        return CategoryServiceHolder.INSTANCE;
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
