<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.work.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<table id="activitiesstatistics" class="table table-bordered table-hover">
<thead>
<tr>
<th>№</th>
<th>Имя</th>
<th>Часы</th>
</tr>
</thead>
<tbody>
<%
	Collection<GroupActivityBean> activities = (Collection<GroupActivityBean>)request.getAttribute("groupActivities");
	for(GroupActivityBean bean : activities) {
%>
<tr>
<td><%=bean.getNum()%></td>
<td><%=bean.getName()%></td>
<td><%=bean.getTime()%></td>
</tr>
<%
	}
%>
</tbody>
</table>