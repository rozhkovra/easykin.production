<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.jira.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<table id="jiratasks" width="100%"  class="table table-bordered table-striped">
  <col width="30"/>
  <col width="100"/>
  <col width="300"/>
  <col/>
<thead>
<tr>
<th>№</th>
<th>ID</th>
<th>Статус</th>
<th>Описание</th>
</tr>
</thead>
<tbody>
<%
    Collection<JiraTaskBean> tasks = (Collection<JiraTaskBean>)request.getAttribute("jiratasks");
	for(JiraTaskBean taskBean : tasks){
%>
<tr>
<td align="center"><%=taskBean.getNum()%></td>
<td><b><a href="https://jira.mvideo.ru/jira/browse/<%=taskBean.getTask().getKey()%>"><%=taskBean.getTask().getKey()%></a></b></td>
<td align="center"><%=taskBean.getTask().getStatus()%></td>
<td><%=taskBean.getTask().getName()%></td>
</tr>
<%			
	}
%>
</tbody>
</table>