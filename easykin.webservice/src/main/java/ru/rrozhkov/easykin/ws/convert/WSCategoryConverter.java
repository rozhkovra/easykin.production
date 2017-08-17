package ru.rrozhkov.easykin.ws.convert;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.ws.bean.CategoryBean;
import ru.rrozhkov.lib.convert.IConverter;

public class WSCategoryConverter implements IConverter<ICategory, CategoryBean> {

	public CategoryBean convert(ICategory category) {
		CategoryBean bean = new CategoryBean();
		bean.setId(category.getId());
		bean.setName(category.getName());
		return bean;
	}
	
}
