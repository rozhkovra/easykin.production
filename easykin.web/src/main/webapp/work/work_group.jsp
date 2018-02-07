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
<th>Часы</th>
</tr>
<%
	int i = 0;
	int daytime = 0;
	Date curDate = null;
	Collection<IActivity> activities = (Collection<IActivity>)ModuleManager.invoke(Module.WORK, "activities");
	Map<String, Integer> groupActivities = new HashMap<String, Integer>();
	for(IActivity activity : activities){
		String key = activity.getTaskType()+" "+activity.getName();
		int time = activity.getTime();
		if(groupActivities.containsKey(key)) {
			time=time+groupActivities.get(key);
		}
		groupActivities.put(key,time);
	}
	for(String key : groupActivities.keySet()) {
%>
<tr>
<td><%=++i%></td>
<td><%=key%></td>
<td><%=groupActivities.get(key)%></td>
</tr>
<%
	}
%>
</table>