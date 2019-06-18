package ru.rrozhkov.easykin.task.category;

import ru.rrozhkov.easykin.model.category.ICategory;

public class CategoryBean {
    private ICategory category;

    public CategoryBean(ICategory category) {
        this.category = category;
    }

    public ICategory getCategory() {
        return category;
    }

    public void setCategory(ICategory category) {
        this.category = category;
    }
}
