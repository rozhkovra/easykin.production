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
	int count = 0;

	for(TaskBean taskBean : tasks){
	    ITask task = taskBean.getTask();
	    if (Status.OPEN.equals(task.getStatus())
	        && new Date().getTime()>task.getPlanDate().getTime()
	        && !Priority.SIMPLE.equals(task.getPriority())) {
          count++;
        }
	}
    String color = "green";
    if (count>0) {
        color = "gray";
%>
<div class="col-lg-3 col-xs-6">
  <!-- small box -->
  <div class="small-box bg-<%=color%>">
    <div class="inner">
      <h3><%=count%></h3>

      <p>Просрочено</p>
    </div>
    <div class="icon">
      <i class="fa fa-tasks"></i>
    </div>
    <a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.TASK)%>"class="small-box-footer">Подробно <i class="fa fa-arrow-circle-right"></i></a>
  </div>
</div>
<%
    }
%>