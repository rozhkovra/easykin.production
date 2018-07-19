<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.work.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<table id="shortactivities" class="table table-bordered table-hover">
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
	Collection<ActivityBean> activities = (Collection<ActivityBean>)request.getAttribute("shortActivities");
	for(ActivityBean bean : activities){
%>
<tr>
<td ><%=bean.getNum()%></td>
<td ><span class="<%=bean.getDateClass()%>"><%=DateUtil.format(bean.getActivity().getDate())%></span></td>
<td align="right"><%=bean.getActivity().getTime()%></td>
<td align="center;"><%=String.valueOf(bean.getActivity().getTaskType())%></td>
<td align="center;"><%=bean.getActivity().getName()%></td>
<td align="center;"><%=String.valueOf(bean.getActivity().getReleaseType())%></td>
<td align="center;"><%=bean.getActivity().getDesc()%></td>
</tr>
<%
	}
%>
</tbody>
</table>