<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.jira.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
    UrlConfigurator urlConfigurator = new UrlConfigurator();
    Collection<JiraWorkLogBean> activities = (Collection<JiraWorkLogBean>)request.getAttribute("jiraworklog");

	int hours = 0;
	for(JiraWorkLogBean bean : activities){
		if (DateUtil.isToday(bean.getWorkLog().getDate())) {
			hours+=bean.getWorkLog().getTime();
		}
	}
	String color = "red";
	if (hours>4 && hours<=8) {
		color = "yellow";
		if(hours == 8) {
			color = "green";
		}
	}
	if (hours != 8) {
%>
<div class="col-lg-3 col-xs-6">
  <!-- work box -->
  <div class="small-box bg-<%=color%>">
    <div class="inner">
      <h3><%=hours%>/8</h3>

      <p>Часы</p>
    </div>
    <div class="icon">
      <i class="fa fa-hourglass-half"></i>
    </div>
    <a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.JIRA, ru.rrozhkov.easykin.module.SubModule.WORKLOG)%>"class="small-box-footer">Подробно <i class="fa fa-arrow-circle-right"></i></a>
  </div>
</div>
<%
	}
%>