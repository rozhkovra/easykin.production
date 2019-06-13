package ru.rrozhkov.easykin.task;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.payment.PaymentBean;
import ru.rrozhkov.easykin.payment.PaymentBeanFactory;
import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.easykin.task.impl.filter.TaskFilterBean;
import ru.rrozhkov.easykin.task.impl.filter.TaskFilterFactory;
import ru.rrozhkov.easykin.task.service.impl.Task2PaymentService;
import ru.rrozhkov.easykin.task.service.impl.TaskService;
import ru.rrozhkov.easykin.task.service.impl.TaskServiceFactory;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by rrozhkov on 11.05.2018.
 */
public class TaskAdapter {
    final private static TaskFilterFactory taskFilterFactory = TaskFilterFactory.instance();
    final private static AuthManager authManager = AuthManager.instance();
    final private static TaskService taskService = TaskServiceFactory.instance().task();
    final private static Task2PaymentService task2PaymentService = TaskServiceFactory.instance().task2Payment();
    final private static TaskFactory taskFactory = TaskFactory.instance();
    final private static TaskBeanFactory taskBeanFactory = TaskBeanFactory.instance();
    private static final PaymentBeanFactory paymentBeanFactory = new PaymentBeanFactory();

    public Collection<TaskBean> toDoTasks() {
        IPerson person = authManager.signedPerson();
        Date fromDate = DateUtil.firstDayOfMonth();
        Date toDate = DateUtil.lastDayOfMonth();
        int priorityId = -1;
        int categoryId = -1;
        int statusId = Status.status(Status.OPEN);
        TaskFilterBean filter = taskFilterFactory.bean(statusId, categoryId, priorityId, fromDate, toDate, person.getId());
        Collection<TaskBean> tasks = tasks(filter);
        if (tasks.size() > 5) {
            tasks = ((List)tasks).subList(0, 5);
        }
        return tasks;
    }

    public Collection<TaskBean> tasks(javax.servlet.http.HttpServletRequest request) {
        TaskFilterBean bean = extractFilter(request);
        return tasks(bean);
    }

    public TaskBean task(javax.servlet.http.HttpServletRequest request) {
        int taskId = request.getParameter("taskId")!=null?Integer.valueOf(request.getParameter("taskId")):-1;
        ITask task = taskService.task(taskId);
        return createTaskBean(1, task);
    }

    public PaymentBean payment(javax.servlet.http.HttpServletRequest request) {
        int taskId = request.getParameter("taskId")!=null?Integer.valueOf(request.getParameter("taskId")):-1;
        IPayment payment = task2PaymentService.paymentForTask(taskId);
        return paymentBeanFactory.paymentBean(1, payment);
    }


    public TaskFilterBean extractFilter(javax.servlet.http.HttpServletRequest request) {
        IPerson person = authManager.signedPerson();
        int categoryId = request.getParameter("categoryId")!=null?Integer.valueOf(request.getParameter("categoryId")):-1;
        int statusId = request.getParameter("statusId")!=null?Integer.valueOf(request.getParameter("statusId")):-1;
        int priorityId = request.getParameter("priorityId")!=null?Integer.valueOf(request.getParameter("priorityId")):-1;
        Date fromDate = request.getParameter("fromDate")!=null?DateUtil.parse(request.getParameter("fromDate")):DateUtil.parse("01.01.2000");
        Date toDate = request.getParameter("toDate")!=null?DateUtil.parse(request.getParameter("toDate")): DateUtil.parse("01.01.3000");
        return taskFilterFactory.bean(statusId, categoryId, priorityId, fromDate, toDate, person.getId());
    }

    public void done(javax.servlet.http.HttpServletRequest request) {
        int taskId = request.getParameter("taskId")!=null?Integer.valueOf(request.getParameter("taskId")):-1;
        ITask task = taskFactory.createTask(taskId, "", DateUtil.today(), DateUtil.today(), Priority.priority(Priority.SIMPLE)
                    , 1, "", null, Status.status(Status.OPEN));
        taskService.close(task);
    }

    private Collection<TaskBean> tasks(TaskFilterBean bean) {
        Collection<ITask> tasks = taskService.tasks(bean);
        Collection<TaskBean> taskBeans = CollectionUtil.create();
        int num = 0;
        for (ITask task : tasks) {
            taskBeans.add(createTaskBean(++num, task));
        }
        return taskBeans;
    }

    private TaskBean createTaskBean(int num, ITask task) {
        String taskClass = "";
        String dateClass = "";
        String comments = "";
        String taskCloseId = "";
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
            taskCloseId = "taskClose"+task.getId();
        }
        for (IComment comment : task.comments()) {
            comments += comment.getText()+" | ";
        }
        return taskBeanFactory.taskBean(num,task,taskClass,dateClass,comments,taskCloseId);
    }

    public void add(javax.servlet.http.HttpServletRequest request) {
        int taskId = -1;
        String taskName = request.getParameter("taskName")!=null?request.getParameter("taskName"):"";
        int categoryId = request.getParameter("categoryId")!=null?Integer.valueOf(request.getParameter("categoryId")):-1;
        ITask task = taskFactory.createTask(taskId, taskName, DateUtil.today(), DateUtil.today(), Priority.priority(Priority.SIMPLE)
                , categoryId, "", null, Status.status(Status.OPEN));
        taskService.createOrUpdate(task, authManager.signedPerson());
    }
}
