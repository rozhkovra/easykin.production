<%@ page import="ru.rrozhkov.easykin.service.*"%>
<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.util.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
	Collection<ServiceBean> beans = (Collection<ServiceBean>)request.getAttribute("services");
	Money noPaid = new Money();
	for(ServiceBean service : beans){
		noPaid.add(service.getNoPaid());
	}

    if (!noPaid.free()) {
        String color = "warning";
        if(noPaid.getValue() > 5000.00) {
            color = "danger";
        }
%>
<div class="alert alert-<%=color%> alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-recycle"></i> Сообщение!</h4>
    К оплате: <b><%=noPaid%></b> руб.
</div>
<%
    }
%>