<%@ page import="java.util.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="ru.rrozhkov.easykin.task.*"%>
<%@ page import="ru.rrozhkov.easykin.model.task.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<!-- See dist/js/pages/dashboard.js to activate the todoList plugin -->
<ul class="overdue-list">
<%
	final AdapterFactory adapterFactory = new AdapterFactory();
	final TaskAdapter taskAdapter = adapterFactory.task();
	Collection<TaskBean> tasks = taskAdapter.toDoTasks();
	for(TaskBean taskBean : tasks){
	    ITask task = taskBean.getTask();
        if (Status.OPEN.equals(task.getStatus())
    	        && new Date().getTime()>task.getPlanDate().getTime()
    	        && !Priority.SIMPLE.equals(task.getPriority())) {

%>
    <li>
      <!-- drag handle -->
      <span class="handle">
            <i class="fa fa-ellipsis-v"></i>
            <i class="fa fa-ellipsis-v"></i>
          </span>
      <!-- checkbox -->
      <input type="checkbox" value="">
      <!-- todo text -->
      <span class="text">(<%=taskBean.getTask().getId()%>) <%=taskBean.getTask().getName()%></span>
      <!-- Emphasis label -->
      <!--small class="label label-danger"><i class="fa fa-clock-o"></i> 2 mins</small-->
      <!-- General tools such as edit or delete-->
      <div class="tools">
        <i class="fa fa-edit"></i>
        <i class="fa fa-trash-o"></i>
      </div>
    </li>
<%
        }
    }
%>
  </ul>