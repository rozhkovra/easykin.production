<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.task.*"%>
<%@ page import="ru.rrozhkov.easykin.model.task.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
	Collection<TaskBean> tasks = (Collection<TaskBean>)request.getAttribute("tasks");
	int overdueCount = 0;
	int todayCount = 0;
	String result = "";
	String overdueResult = "";
	String todayResult = "";

	for(TaskBean taskBean : tasks){
	    ITask task = taskBean.getTask();
	    if (task.getStatus().isOpen() && !task.getPriority().isSimple()) {
	        if (DateUtil.future(task.getPlanDate())
	            && !DateUtil.isToday(task.getPlanDate())) {
	            overdueResult += "<li>" + task.getId() + " " + task.getName() + "</li>";
                overdueCount++;
            }
            if (DateUtil.isToday(task.getPlanDate())) {
                todayResult += "<li>" + task.getId() + " " + task.getName() + "</li>";
                todayCount++;
            }
        }
	}
    if (overdueCount > 0) {
        result += "<b>Просрочено задач: ("+overdueCount+")</b><br/>" + overdueResult;
    }
    if (todayCount > 0) {
        result += "<b>На сегодня задач ("+todayCount+")</b><br/>" + todayResult;
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