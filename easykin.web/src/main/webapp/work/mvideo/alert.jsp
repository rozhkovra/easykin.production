<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.work.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
	Collection<ActivityBean> activities = (Collection<ActivityBean>)request.getAttribute("activities");
	int hours = 0;
	String result = "<ul>";
	for(ActivityBean bean : activities){
		if (DateUtil.isToday(bean.getActivity().getDate())) {
			hours+=bean.getActivity().getTime();
			result+="<li>" + (bean.getActivity().getName().isEmpty()?bean.getActivity().getDesc():bean.getActivity().getName()) + " - " + bean.getActivity().getTime() + "</li>";
		}
	}
	result+="</ul>";
	String color = "danger";
	if (hours > 4 && hours < 8) {
		color = "warning";
	} else if (hours == 8) {
		color = "success";
	}
%>
<div class="alert alert-<%=color%> alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-hourglass-half"></i> Сообщение!</h4>
<%
	if (hours != 8) {
%>
    Отработано: <b><%=hours%></b> часов.
<%
	}
%>
    <%=result%>
<%
	if (hours != 8) {
%>
    Осталось: <b><%=8-hours%></b> часов.
<%
	}
%>
</div>