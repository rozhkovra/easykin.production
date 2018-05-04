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
<table id="activities" class="table table-bordered table-hover">
<thead>
<tr>
<th>№</th>
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
	Collection<IActivity> activities = (Collection<IActivity>)ModuleManager.invoke(Module.WORK, "activities");
	Map<Date, Integer> dayTime = new HashMap<Date, Integer>();
	for(IActivity activity : activities){
		int curTime = activity.getTime();
		if (dayTime.containsKey(activity.getDate())) {
			 curTime += dayTime.get(activity.getDate());
		}
		dayTime.put(activity.getDate(), curTime);
	}
	for(IActivity activity : activities){
    		String dateClass = "";
            if(Integer.valueOf(8).equals(dayTime.get(activity.getDate()))){
            	dateClass = "label bg-green";
            }else{
            	dateClass = "label bg-yellow";
            }
%>
<tr>
<td ><%=++i%></td>
<td ><span class="<%=dateClass%>"><%=DateUtil.format(activity.getDate())%></span></td>
<td align="right"><%=activity.getTime()%></td>
<td align="center;"><%=activity.getTaskType().toString()%></td>
<td align="center;"><%=activity.getName()%></td>
<td align="center;"><%=activity.getReleaseType().toString()%></td>
<td align="center;"><%=activity.getDesc()%></td>
</tr>
<%
	}
%>
</tbody>
</table>
</div>
</div>
</div>
</div>
</section>

<!-- page script -->
<script>
  $(function () {
    $('#activities').DataTable()
  })
</script>