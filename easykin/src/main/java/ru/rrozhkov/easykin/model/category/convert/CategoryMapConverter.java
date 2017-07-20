package ru.rrozhkov.easykin.model.category.convert;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.lib.convert.IConverter;

import java.util.HashMap;
import java.util.Map;

public class CategoryMapConverter implements IConverter<ICategory, Map<String, Object>> {

	public Map<String, Object> convert(ICategory category) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", category.getId());
		map.put("name", category.getName());
		return map;
	}

}
