<%@ page import="ru.rrozhkov.easykin.service.*"%>
<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.util.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<table id="services" class="table table-bordered table-hover">
<thead>
<tr>
<th>№</th>
<th>Период</th>
<th>Дата</th>
<th>Итого</th>
</tr>
</thead>
<tbody>
<%
	int i = 0;
	final AdapterFactory adapterFactory = new AdapterFactory();
	final ServiceAdapter serviceAdapter = adapterFactory.service();
	Collection<ServiceBean> beans = serviceAdapter.services();
	for(ServiceBean service : beans){
%>
<tr>
<td align="center"><%=++i%></td>
<td ><span class="<%=service.getServiceClass()%>"><%=service.getName()%></span></td>
<td align="center"><%=DateUtil.format(service.getDate())%></td>
<td style="<%=service.getTdStyle()%>text-align:right;"><%=FormatUtil.formatMoney(service.getItog())+(service.getNoPaid().free()?"":"/"+FormatUtil.formatMoney(service.getNoPaid()))%></td>
</tr>
<%
	}
%>
</tbody>
</table>