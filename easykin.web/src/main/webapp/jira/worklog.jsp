<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.jira.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<table id="jiraworklog" class="table table-bordered table-hover">
<thead>
<tr>
<th>№</th>
<th>Дата</th>
<th>Часы</th>
<th>Тип</th>
<th>ID</th>
<th>Релиз</th>
<th>Комментарий</th>
</tr>
</thead>
<tbody>
<%
Collection<JiraWorkLogBean> activities = (Collection<JiraWorkLogBean>)request.getAttribute("jiraworklog");
for(JiraWorkLogBean bean : activities){
%>
<tr>
<td ><%=bean.getNum()%></td>
<td ><span class="<%=bean.getDateClass()%>"><%=DateUtil.format(bean.getWorkLog().getDate())%></span></td>
<td align="right"><%=bean.getWorkLog().getTime()%></td>
<td align="center;"></td>
<td align="center;"><%=bean.getWorkLog().getName()%></td>
<td align="center;"></td>
<td align="center;"><%=bean.getWorkLog().getDesc()%></td>
</tr>
<%
	}
%>
</tbody>
</table>