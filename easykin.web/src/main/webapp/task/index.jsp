<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.task.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<jsp:include page="/task/filter.jsp"/>
<table id="tasks" width="100%"  class="table table-bordered table-striped">
  <col width="30"/>
  <col width="30"/>
  <col/>
  <col width="120"/>
  <col width="150"/>
  <col width="50"/>
<thead>
<tr>
<th>№</th>
<th>ID</th>
<th>Описание</th>
<th>Срок</th>
<th>Категория</th>
<th></th>
</tr>
</thead>
<tbody>
<%
    TaskUrlConfigurator urlConfigurator = new TaskUrlConfigurator();
    Collection<TaskBean> tasks = (Collection<TaskBean>)request.getAttribute("tasks");
	for(TaskBean taskBean : tasks){
%>
<tr >
<td align="center"><%=taskBean.getNum()%></td>
<td align="center"><a href="<%=urlConfigurator.getTaskViewUrl(request, session, taskBean)%>"><span class="<%=taskBean.getTaskClass()%>"><%=taskBean.getTask().getId()%></span></a></td>
<td ><%=taskBean.getTask().getName()%><br/><span style="font-size:12px;"><%=taskBean.getComments()%></span></td>
<td align="center"><span class="<%=taskBean.getDateClass()%>"><%=DateUtil.format(taskBean.getTask().getPlanDate())%></span></td>
<td align="center"><%=taskBean.getTask().getCategory().getName()%></td>
<td align="center">
<%
    if (taskBean.getTask().getStatus().isOpen()) {
%>
<button id="<%=taskBean.getTaskCloseId()%>" type="button" class="btn btn-block btn-sm btn-success">Выполнить</button>
<%
    }
%>
</td>
</tr>
<%			
	}
%>
</tbody>
</table>