package ru.rrozhkov.easykin.task.category;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.task.service.impl.CategoryService;
import ru.rrozhkov.easykin.task.service.impl.TaskServiceFactory;

import java.util.Collection;

public class CategoryAdapter {
    private static final CategoryService categoryService = TaskServiceFactory.instance().category();
    final private static CategoryBeanFactory categoryBeanFactory = CategoryBeanFactory.instance();

    public Collection<CategoryBean> categories() {
        Collection<ICategory> categories = categoryService.categories();
        Collection beans = CollectionUtil.create();
        for (ICategory category : categories) {
            beans.add(categoryBeanFactory.categoryBean(category));
        }
        return beans;
    }
}
