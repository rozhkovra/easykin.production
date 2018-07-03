<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.work.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
    UrlConfigurator urlConfigurator = new UrlConfigurator();
	final AdapterFactory adapterFactory = new AdapterFactory();
	final WorkAdapter workAdapter = adapterFactory.work();
	Collection<ActivityBean> activities = workAdapter.activities();
	int hours = 0;
	for(ActivityBean bean : activities){
		if (DateUtil.isToday(bean.getActivity().getDate())) {
			hours+=bean.getActivity().getTime();
		}
	}
	String color = "red";
	if (hours>4 && hours<=8) {
		color = "yellow";
		if(hours == 8) {
			color = "green";
		}
	}

%>
  <!-- work box -->
  <div class="small-box bg-<%=color%>">
    <div class="inner">
      <h3><%=hours%>/8</h3>

      <p>Часы</p>
    </div>
    <div class="icon">
      <i class="fa fa-hourglass-half"></i>
    </div>
    <a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.WORK)%>"class="small-box-footer">Подробно <i class="fa fa-arrow-circle-right"></i></a>
  </div>