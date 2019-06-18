package ru.rrozhkov.easykin.task.category;

import ru.rrozhkov.easykin.model.category.ICategory;

/**
 * Created by rrozhkov on 04.06.2018.
 */
public class CategoryBeanFactory {
    public static class CategoryBeanFactoryHolder {
        public static final CategoryBeanFactory INSTANCE = new CategoryBeanFactory();
    }

    public static CategoryBeanFactory instance(){
        return CategoryBeanFactoryHolder.INSTANCE;
    }

    public CategoryBean categoryBean(ICategory category) {
        return new CategoryBean(category);
    }
}
