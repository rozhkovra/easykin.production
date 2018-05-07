package ru.rrozhkov.easykin.task.impl.convert;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.impl.PaymentFactory;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.model.task.util.TaskUtil;
import ru.rrozhkov.easykin.task.impl.filter.TaskFilterFactory;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.convert.IConverter;
import ru.rrozhkov.lib.convert.IEntityConverter;
import ru.rrozhkov.lib.filter.util.FilterUtil;
import ru.rrozhkov.lib.util.DateUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class TaskConverter implements IEntityConverter<ITask> {
    protected TaskConverter() {
    }

    public String sqlInsert(ITask task) {
        return new IConverter<ITask, String>() {
            public String convert(ITask task) {
                return "INSERT INTO task(id, name, priority, category, status) VALUES(" + task.getId()
                        + ", '" + task.getName() + "'"
                        + ", " + Priority.priority(task.getPriority())
                        + ", " + task.getCategory().getId()
                        + ", " + Status.status(task.getStatus()) + ")";
            }
        }.convert(task);
    }

    public Map<String, Object> map(ITask task) {
        return new IConverter<ITask, Map<String, Object>>() {
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
        }.convert(task);
    }

    public String[] stringArr(Collection<ITask> entries) {
        return new IConverter<Collection<ITask>, String[]>() {
            public String[] convert(Collection<ITask> entries) {
                Collection<String> items = CollectionUtil.create();
                for(ITask task : entries)
                    items.add(task.getName());
                return items.toArray(new String[items.size()]);
            }
        }.convert(entries);
    }

    public ITask entity(ResultSet resultSet) {
        return new IConverter<ResultSet, ITask>() {
            public ITask convert(ResultSet result){
                try{
                    return TaskFactory.createTask(result.getInt("id"), result.getString("name"), result.getDate("createdate")
                            , result.getDate("plandate"), result.getInt("priorityid"), result.getInt("categoryid")
                            , result.getString("categoryname"), result.getDate("closedate"), result.getInt("statusid"));
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return null;
            }
        }.convert(resultSet);
    }

    public IPayment payment(ITask task) {
        return new IConverter<ITask, IPayment>() {
            public IPayment convert(ITask task) {
                return PaymentFactory.createTaskPayment(TaskUtil.extractComment(task), TaskUtil.extractAmount(task)
                        , task.getStatus().isClose() ? task.getCloseDate() : task.getPlanDate(), task.getStatus());
            }
        }.convert(task);
    }

    public Collection<IPayment> payments(Collection<ITask> tasks) {
        return new IConverter<Collection<ITask>,Collection<IPayment>>(){
            public Collection<IPayment> convert(Collection<ITask> entries) {
                Collection<IPayment> collection = CollectionUtil.<IPayment>create();
                entries = FilterUtil.<ITask>filter(entries, TaskFilterFactory.withPayment());
                for(ITask task : entries){
                    collection.add(payment(task));
                }
                return collection;
            }
        }.convert(tasks);
    }

    public ITask task(ResultSet result) {
        return new IConverter<ResultSet, ITask>() {
            public ITask convert(ResultSet result) {
                try{
                    return TaskFactory.createTask(result.getInt("id"), result.getString("name"), result.getDate("createdate")
                            , result.getDate("plandate"), result.getInt("priorityid"), result.getInt("categoryid")
                            , result.getString("categoryname"), result.getDate("closedate"), result.getInt("statusid"));
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return null;
            }
        }.convert(result);
    }
}
