<%@ page import="ru.rrozhkov.lib.util.*"%>
<%@ page import="ru.rrozhkov.easykin.model.work.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="ru.rrozhkov.easykin.model.person.util.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<section class="content">
<div class="row">
<div class="col-xs-12">

<div class="box">
<div class="box-header">
</div>

<div class="box-body">
<table id="works" width="100%"  class="table table-bordered table-hover">
<thead>
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
</thead>
<tbody>
<%
	int i = 0;
	int daytime = 0;
	Date curDate = null;
	Collection<IActivity> activities = (Collection<IActivity>)ModuleManager.invoke(Module.WORK, "activities");
	for(IActivity activity : activities){
		String spanClass = "";
		String tdStyle = "height:30px;font-size:20px;";
		if(curDate!=null && !curDate.equals(activity.getDate())) {
			if(daytime == 8) {
				spanClass = "label label-success";
			}else{
				spanClass = "label label-warning";
			}
%>
<tr>
	<td colspan="3"/>
	<td style="<%=tdStyle%>text-align:right;font-weight:bold;"><span class="<%=spanClass%>"><%=daytime%></span></td>
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
				spanClass = "label label-success";
			}else{
				spanClass = "label label-warning";
			}
%>
<tr>
	<td colspan="3"/>
	<td style="<%=tdStyle%>text-align:right;font-weight:bold;"><span class="<%=spanClass%>"><%=daytime%></span></td>
	<td colspan="4"/>
</tr>
<%
			daytime = 0;
		}
		curDate = activity.getDate();
	}
%>
</tbody>
</table>
</div>
</div>
</div>
</div>
</section>
