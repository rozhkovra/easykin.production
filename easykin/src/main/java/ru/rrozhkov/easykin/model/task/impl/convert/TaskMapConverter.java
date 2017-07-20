package ru.rrozhkov.easykin.model.task.impl.convert;

import java.util.HashMap;
import java.util.Map;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.lib.convert.IConverter;
import ru.rrozhkov.lib.util.DateUtil;

public class TaskMapConverter implements IConverter<ITask, Map<String, Object>> {

	public Map<String, Object> convert(ITask task) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", task.getId());
		map.put("name", task.getName());
		map.put("createdate", DateUtil.formatSql(task.getCreateDate()));
		map.put("plandate", DateUtil.formatSql(task.getPlanDate()));
		map.put("priorityid", Priority.priority(task.getPriority()));
		map.put("categoryid", task.getCategory().getId());
		map.put("statusid", Status.status(task.getStatus()));
		return map;
	}

}
