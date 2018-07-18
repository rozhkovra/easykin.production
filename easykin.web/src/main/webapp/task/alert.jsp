<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.task.*"%>
<%@ page import="ru.rrozhkov.easykin.model.task.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
    TaskUrlConfigurator urlConfigurator = new TaskUrlConfigurator();
	final AdapterFactory adapterFactory = new AdapterFactory();
	final TaskAdapter taskAdapter = adapterFactory.task();
	Collection<TaskBean> tasks = taskAdapter.tasks(request);
	int overdueCount = 0;
	int todayCount = 0;
	String result = "";

	for(TaskBean taskBean : tasks){
	    ITask task = taskBean.getTask();
	    if (Status.OPEN.equals(task.getStatus())
	        && new Date().getTime()>task.getPlanDate().getTime()
	        && !Priority.SIMPLE.equals(task.getPriority())) {
          overdueCount++;
        }
	}
    if (overdueCount > 0 || todayCount > 0) {
        result += "<li>Просрочено задач - <b>"+overdueCount+"</b></li>";
    }
    if (todayCount > 0) {
        result += "<li>На сегодня задач - <b>"+overdueCount+"</b></li>";
    }
    if (!result.isEmpty()) {
%>
<div class="alert alert-info alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-tasks"></i> Сообщение!</h4>
    <ul><%=result%></ul>
</div>
<%
    }
%>