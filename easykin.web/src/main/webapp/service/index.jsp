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
<th>Вода</th>
<th>Гор.вода</th>
<th>Свет</th>
<th>Газ</th>
<th>Отопление</th>
<th>Антенна</th>
<th>Домофон</th>
<th>Квартплата</th>
<th>Кап.ремонт</th>
<th>Вывоз ТКО</th>
<th>Итого</th>
</tr>
</thead>
<tbody>
<%
	int i = 0;
	Collection<ServiceBean> beans = (Collection<ServiceBean>)request.getAttribute("services");
	for(ServiceBean service : beans){
%>
<tr>
<td align="center"><%=++i%></td>
<td ><span class="<%=service.getServiceClass()%>"><%=service.getName()%></span></td>
<td align="center"><%=DateUtil.format(service.getDate())%></td>
<td align="center"><%=FormatUtil.formatMoney(service.getWater())%></td>
<td align="center"><%=FormatUtil.formatMoney(service.getHotWater())%></td>
<td align="center"><%=FormatUtil.formatMoney(service.getElectricity())%></td>
<td align="center"><%=FormatUtil.formatMoney(service.getGaz())%></td>
<td align="center"><%=FormatUtil.formatMoney(service.getHeating())%></td>
<td align="center"><%=FormatUtil.formatMoney(service.getAntenna())%></td>
<td align="center"><%=FormatUtil.formatMoney(service.getIntercom())%></td>
<td align="center"><%=FormatUtil.formatMoney(service.getHouse())%></td>
<td align="center"><%=FormatUtil.formatMoney(service.getRepair())%></td>
<td align="center"><%=FormatUtil.formatMoney(service.getGarbage())%></td>
<td style="<%=service.getTdStyle()%>text-align:right;"><%=FormatUtil.formatMoney(service.getItog())+(service.getNoPaid().free()?"":"/"+FormatUtil.formatMoney(service.getNoPaid()))%></td>
</tr>
<%
	}
%>
</tbody>
</table>