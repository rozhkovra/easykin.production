package ru.rrozhkov.easykin.service.calc2.impl.convert;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.lib.convert.IConverter;

import java.util.HashMap;
import java.util.Map;

public class MeasureMapConverter implements IConverter<IMeasure, Map<String, Object>> {

	public Map<String, Object> convert(IMeasure measure) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", measure.getId());
		map.put("readingid", measure.getReadingId());
		map.put("measuretype", measure.getType().toString());
		map.put("measurevalue", measure.getValue().toString().replace(".0", ""));
		return map;
	}

}
