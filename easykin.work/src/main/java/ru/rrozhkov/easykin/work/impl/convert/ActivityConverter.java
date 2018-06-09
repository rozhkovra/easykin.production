package ru.rrozhkov.easykin.work.impl.convert;

import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.easykin.model.work.ReleaseType;
import ru.rrozhkov.easykin.model.work.TaskType;
import ru.rrozhkov.easykin.model.work.impl.WorkFactory;
import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.core.util.DateUtil;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class ActivityConverter implements IEntityConverter<IActivity> {
    private static final WorkFactory workFactory = WorkFactory.instance();

    protected ActivityConverter() {
    }

    public String sqlInsert(IActivity entity) {
        return null;
    }

    public Map<String, Object> map(IActivity entity) {
        return new IConverter<IActivity, Map<String, Object>>() {
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
        }.convert(entity);
    }

    public String[] stringArr(Collection<IActivity> entries) {
        return new String[0];
    }

    public IActivity entity(ResultSet resultSet) {
        return new IConverter<ResultSet, IActivity>() {
            public IActivity convert(ResultSet entry) {
                try{
                    return workFactory.create(entry.getInt("id"), entry.getDate("actdate")
                            , null, entry.getInt("acttime")
                            , TaskType.type(entry.getString("tasktype")), entry.getString("name")
                            , ReleaseType.type(entry.getString("releaseType")), entry.getString("desc"));
                }catch(Exception e){
                    e.printStackTrace();
                }
                return null;
            }
        }.convert(resultSet);
    }
}
