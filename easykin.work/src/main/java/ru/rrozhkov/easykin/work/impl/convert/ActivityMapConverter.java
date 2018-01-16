package ru.rrozhkov.easykin.work.impl.convert;

import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.lib.convert.IConverter;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.HashMap;
import java.util.Map;

public class ActivityMapConverter implements IConverter<IActivity, Map<String, Object>> {

	public Map<String, Object> convert(IActivity activity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", activity.getId());
		map.put("name", activity.getName());
		map.put("date", DateUtil.formatSql(activity.getDate()));
		map.put("personId", activity.getPerson().getId());
		map.put("time", activity.getTime());
		map.put("taskType", activity.getTaskType().toString());
		map.put("releaseType", activity.getReleaseType().toString());
		map.put("desc", activity.getDesc());
		return map;
	}

}
