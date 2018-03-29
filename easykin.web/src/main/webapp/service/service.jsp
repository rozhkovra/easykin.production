<%@ page import="ru.rrozhkov.lib.util.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="ru.rrozhkov.easykin.service.gui.style.impl.custom.*"%>
<%@ page import="ru.rrozhkov.easykin.model.service.calc.impl.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<table width="100%" border="1">
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
<th>Итого</th>
</tr>
<%
	String moduleId = request.getParameter("moduleId")!=null?String.valueOf(request.getParameter("moduleId")):"";

	int i = 0;
	ServiceCalcConverter converter = new ServiceCalcConverter(0);
	Collection<ServiceCalc> calcs = (Collection<ServiceCalc>)ModuleManager.invoke(moduleId, "calcs");
	String tdStyle = "height:30px;font-size:20px;";
	String color = "";

	for(ServiceCalc calc : calcs){
		if(calc.isPaid()){
    		color = "#44e53f";
    		tdStyle = "height:30px;font-size:20px;font-weight:bold;";
    	}else{
			color = "#eec95e";
			tdStyle = "height:30px;font-size:20px;";
		}
		String[] values = converter.convert(i, calc);
%>
<tr bgcolor="<%=color%>">
<td style="<%=tdStyle%>text-align:center;"><%=++i%></td>
<td style="<%=tdStyle%>"><%=values[0]%></td>
<td style="<%=tdStyle%>text-align:center;"><%=values[1]%></td>
<td style="<%=tdStyle%>text-align:center;"><%=values[2]%></td>
<td style="<%=tdStyle%>text-align:center;"><%=values[3]%></td>
<td style="<%=tdStyle%>text-align:center;"><%=values[4]%></td>
<td style="<%=tdStyle%>text-align:center;"><%=values[5]%></td>
<td style="<%=tdStyle%>text-align:center;"><%=values[6]%></td>
<td style="<%=tdStyle%>text-align:center;"><%=values[7]%></td>
<td style="<%=tdStyle%>text-align:center;"><%=values[8]%></td>
<td style="<%=tdStyle%>text-align:center;"><%=values[9]%></td>
<td style="<%=tdStyle%>text-align:center;"><%=values[10]%></td>
<td style="<%=tdStyle%>text-align:right;"><%=values[11]%></td>
</tr>
<%
	}
%>
</table>