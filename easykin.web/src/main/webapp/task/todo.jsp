<%@ page import="java.util.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="ru.rrozhkov.easykin.task.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<ul class="todo-list">
<%
    TaskUrlConfigurator urlConfigurator = new TaskUrlConfigurator();
	Collection<TaskBean> tasks = (Collection<TaskBean>)request.getAttribute("toDoTasks");
	for(TaskBean taskBean : tasks){
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
      <span class="text"><a href="<%=urlConfigurator.getTaskViewUrl(request, session, taskBean)%>">(<%=taskBean.getTask().getId()%>)</a><%=taskBean.getTask().getName()%></span>
      <!-- Emphasis label -->
      <!--small class="label label-danger"><i class="fa fa-clock-o"></i> 2 mins</small-->
      <!-- General tools such as edit or delete-->
      <div class="tools">
        <i class="fa fa-check" id="<%=taskBean.getTaskCloseId()%>"></i>
      </div>
    </li>
<%
    }
%>
  </ul>