package ru.rrozhkov.easykin.task;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.easykin.task.impl.filter.TaskFilterBean;
import ru.rrozhkov.easykin.task.impl.filter.TaskFilterFactory;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 11.05.2018.
 */
public class ModuleAdapter {
    public static Collection<TaskBean> tasks(javax.servlet.http.HttpServletRequest request) {
        int categoryId = request.getParameter("categoryId")!=null?Integer.valueOf(request.getParameter("categoryId")):-1;
        int statusId = request.getParameter("statusId")!=null?Integer.valueOf(request.getParameter("statusId")):-1;
        int priorityId = request.getParameter("priorityId")!=null?Integer.valueOf(request.getParameter("priorityId")):-1;
        Date fromDate = request.getParameter("fromDate")!=null?DateUtil.parse(request.getParameter("fromDate")):DateUtil.parse("01.01.2000");
        Date toDate = request.getParameter("toDate")!=null?DateUtil.parse(request.getParameter("toDate")): DateUtil.parse("01.01.3000");

        IPerson person = AuthManager.instance().signedPerson();
        TaskFilterBean bean = TaskFilterFactory.bean(statusId, categoryId, priorityId, fromDate, toDate, person.getId());
        Collection<ITask> tasks = Module.tasks(bean);
        Collection<TaskBean> taskBeans = CollectionUtil.create();
        int num = 0;
        for (ITask task : tasks) {
            String taskClass = "";
            String dateClass = "";
            String comments = "";
            if(Status.CLOSE.equals(task.getStatus())){
                if(task.getCloseDate().getTime()>task.getPlanDate().getTime())
                    taskClass = "label bg-gray";
                else
                    taskClass = "label bg-green";
            }else{
                taskClass  = "";
                if(Priority.IMPOTANT_FAST.equals(task.getPriority())){
                    taskClass  = "label bg-yellow";
                }
                if(Priority.IMPOTANT_NOFAST.equals(task.getPriority())){
                    taskClass  = "label bg-blue";
                }
                if (new Date().getTime()>task.getPlanDate().getTime()) {
                    dateClass = "label bg-gray";
                }
            }
            for (IComment comment : task.comments()) {
                comments += comment.getText()+" | ";
            }
            taskBeans.add(new TaskBean(++num,task,taskClass,dateClass,comments));
        }
        return taskBeans;
    }
}
