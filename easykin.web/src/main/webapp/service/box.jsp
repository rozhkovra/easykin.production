<%@ page import="ru.rrozhkov.easykin.service.*"%>
<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.util.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
	UrlConfigurator urlConfigurator = new UrlConfigurator();
	Collection<ServiceBean> beans = (Collection<ServiceBean>)request.getAttribute("services");	Money noPaid = new Money();
	for(ServiceBean service : beans){
		noPaid.add(service.getNoPaid());
	}

	if (!noPaid.free()) {
		String color = "yellow";
		if(noPaid.getValue() > 5000.00) {
			color = "red";
		}
%>
<div class="col-lg-3 col-xs-6">
<!-- service box -->
<div class="small-box bg-<%=color%>">
	<div class="inner">
		<h3><%=FormatUtil.formatMoney(noPaid)%> <i class="fa fa-rub"></i></h3>

		<p>Коммунальные услуги</p>
	</div>
	<div class="icon">
		<i class="fa fa-recycle"></i>
	</div>
	<a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.SERVICE)%>"class="small-box-footer">Подробно <i class="fa fa-arrow-circle-right"></i></a>
</div>
</div>
<%	}
%>