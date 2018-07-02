<%@ page import="ru.rrozhkov.easykin.service.calc2.impl.service.*"%>
<%@ page import="ru.rrozhkov.easykin.model.service.calc2.*"%>
<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<table id="rates" class="table table-bordered table-hover">
<thead>
<tr>
<th>№</th>
<th>Тип</th>
<th>Тариф</th>
</tr>
</thead>
<tbody>
<%
	int i = 0;
	final RateService rateService = RateService.instance();
	Collection<IRate> rates = rateService.rates(DateUtil.lastDayOfMonth());

	for(IRate rate : rates){
%>
<tr>
<td align="center"><%=++i%></td>
<td><%=rate.getType()%></td>
<td align="center"><%=rate.getValue()%></td>
</tr>
<%
	}
%>
</tbody>
</table>
