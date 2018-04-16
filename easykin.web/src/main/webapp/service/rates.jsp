<%@ page import="ru.rrozhkov.lib.util.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="ru.rrozhkov.easykin.service.gui.style.impl.custom.*"%>
<%@ page import="ru.rrozhkov.easykin.model.service.calc2.*"%>
<%@ page import="ru.rrozhkov.easykin.service.data.impl.stat.*"%>
<%@ page import="ru.rrozhkov.easykin.service.db.impl.calc2.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<table width="100%" border="1">
<tr>
<th>№</th>
<th>Тип</th>
<th>Тариф</th>
</tr>
<%
	String moduleId = request.getParameter("moduleId")!=null?String.valueOf(request.getParameter("moduleId")):"";

	int i = 0;
	Collection<IRate> rates = StaticReadingDataProvider.rates2018_1;
    try {
        rates = RateHandler.selectForDate(DateUtil.today());
    } catch (Exception e) {
        rates = StaticReadingDataProvider.rates2018_1;
    }

	String tdStyle = "height:30px;font-size:20px;";
	String color = "";

	for(IRate rate : rates){
%>
<tr bgcolor="<%=color%>">
<td style="<%=tdStyle%>text-align:center;"><%=++i%></td>
<td style="<%=tdStyle%>"><%=rate.getType()%></td>
<td style="<%=tdStyle%>text-align:center;"><%=rate.getValue()%></td>
</tr>
<%
	}
%>
</table>