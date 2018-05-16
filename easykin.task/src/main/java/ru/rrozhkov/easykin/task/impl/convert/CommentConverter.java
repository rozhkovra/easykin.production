package ru.rrozhkov.easykin.task.impl.convert;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.convert.IConverter;
import ru.rrozhkov.lib.convert.IEntityConverter;
import ru.rrozhkov.lib.util.DateUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class CommentConverter implements IEntityConverter<IComment> {
    protected CommentConverter() {
    }

    public String sqlInsert(IComment entity) {
        return null;
    }

    public Map<String, Object> map(IComment entity) {
        return new IConverter<IComment, Map<String, Object>>() {
            public Map<String, Object> convert(IComment comment) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", comment.getId());
                map.put("text", comment.getText());
                map.put("createdate", DateUtil.formatSql(comment.getDate()));
                map.put("taskid", comment.getTaskId());
                return map;
            }
        }.convert(entity);
    }

    public String[] stringArr(Collection<IComment> entries) {
        return new IConverter<Collection<IComment>, String[]>() {
            public String[] convert(Collection<IComment> entries) {
                Collection<String> items = CollectionUtil.create();
                for(IComment entry : entries)
                    items.add(entry.getText());
                return items.toArray(new String[items.size()]);
            }
        }.convert(entries);
    }

    public IComment entity(ResultSet resultSet) {
        return new IConverter<ResultSet, IComment>() {
            public IComment convert(ResultSet result){
                try{
                    return TaskFactory.createComment(result.getInt("id"), result.getString("text")
                            , result.getDate("createdate"), result.getInt("taskId")
                    );
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return null;
            }
        }.convert(resultSet);
    }
}