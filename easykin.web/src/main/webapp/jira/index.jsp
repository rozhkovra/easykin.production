<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.jira.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<table id="jiratasks" width="100%"  class="table table-bordered table-striped">
  <col width="30"/>
  <col width="100"/>
  <col/>
  <col width="300"/>
<thead>
<tr>
<th>№</th>
<th>ID</th>
<th>Описание</th>
<th>Статус</th>
</tr>
</thead>
<tbody>
<%
    Collection<JiraTaskBean> tasks = (Collection<JiraTaskBean>)request.getAttribute("jiratasks");
	for(JiraTaskBean taskBean : tasks){
%>
<tr >
<td align="center"><%=taskBean.getNum()%></td>
<td ><%=taskBean.getTask().getKey()%></td>
<td ><%=taskBean.getTask().getName()%></td>
<td align="center"><%=taskBean.getTask().getStatus()%></td>
</tr>
<%			
	}
%>
</tbody>
</table>