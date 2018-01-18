<%@ page import="ru.rrozhkov.lib.util.*"%>
<%@ page import="ru.rrozhkov.easykin.model.work.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="ru.rrozhkov.easykin.model.person.util.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<table width="100%" border="1">
<tr>
<th>№</th>
<th>Имя</th>
<th>Дата</th>
<th>Часы</th>
<th>Тип задачи</th>
<th>ID задачи</th>
<th>Номер релиза</th>
<th>Комментарий</th>
</tr>
<%
	int i = 0;
	int daytime = 0;
	Date curDate = null;
	Collection<IActivity> activities = (Collection<IActivity>)ModuleManager.invoke(Module.WORK, "activities");
	for(IActivity activity : activities){
		String color = "";
		String tdStyle = "height:30px;font-size:20px;";
		if(curDate!=null && !curDate.equals(activity.getDate())) {
			if(daytime == 8) {
				color = "#44e53f";
			}else{
				color = "#eec95e";
			}
%>
<tr>
	<td colspan="3"/>
	<td bgcolor="<%=color%>" style="<%=tdStyle%>text-align:right;font-weight:bold;"><%=daytime%></td>
	<td colspan="4"/>
</tr>
<%
			daytime = 0;
		}
%>
<tr>
<td style="<%=tdStyle%>"><%=++i%></td>
<td style="<%=tdStyle%>"><%=PersonUtil.fi(activity.getPerson())%></td>
<td style="<%=tdStyle%>"><%=DateUtil.format(activity.getDate())%></td>
<td style="<%=tdStyle%>text-align:right;"><%=activity.getTime()%></td>
<td style="<%=tdStyle%>text-align:center;"><%=activity.getTaskType().toString()%></td>
<td style="<%=tdStyle%>text-align:center;"><%=activity.getName()%></td>
<td style="<%=tdStyle%>text-align:center;"><%=activity.getReleaseType().toString()%></td>
<td style="<%=tdStyle%>text-align:center;"><%=activity.getDesc()%></td>
</tr>
<%
		daytime+=activity.getTime();
		if(i==activities.size()) {
			if(daytime == 8) {
				color = "#44e53f";
			}else{
				color = "#eec95e";
			}
%>
<tr>
	<td colspan="3"/>
	<td bgcolor="<%=color%>" style="<%=tdStyle%>text-align:right;font-weight:bold;"><%=daytime%></td>
	<td colspan="4"/>
</tr>
<%
			daytime = 0;
		}
		curDate = activity.getDate();
	}
%>
</table>