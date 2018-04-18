package ru.rrozhkov.easykin.service.calc2.impl.convert;

import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.lib.convert.IConverter;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.HashMap;
import java.util.Map;

public class ReadingMapConverter implements IConverter<IReading, Map<String, Object>> {

	public Map<String, Object> convert(IReading reading) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", reading.getId());
		map.put("reddate", DateUtil.formatSql(reading.getDate()));
		return map;
	}

}
