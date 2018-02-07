<%@ page import="ru.rrozhkov.lib.util.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.payment.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<table width="100%">
<tr>
<th>№</th>
<th>Категория</th>
<th>Назначение</th>
<th>Сумма</th>
<th>Дата</th>
</tr>
<%
	String moduleId = request.getParameter("moduleId")!=null?String.valueOf(request.getParameter("moduleId")):"";

	int i = 0;
	Money moneyMonth = Money.valueOf(0.0);
	String curMonth = "";
	Collection<IPayment> payments = (Collection<IPayment>)ModuleManager.invoke(moduleId, "finance");
	for(IPayment payment : payments){

		String tdStyle = "height:30px;font-size:20px;";
		String color = "";

		if(!curMonth.equals(DateUtil.formatService(payment.getDate()))) {
%>
<tr>
<td style="<%=tdStyle%>;font-weight:bold;" colspan=3><%=curMonth%></td>
<td style="<%=tdStyle%>;font-weight:bold;"><%=moneyMonth%></td>
<td style="<%=tdStyle%>;font-weight:bold;"></td>
</tr>
<%
			curMonth = DateUtil.formatService(payment.getDate());
			moneyMonth = Money.valueOf(0.0);
		}

		if(payment.getStatus().isFact()){
			color = "#44e53f";
		}else{
			color = "#eec95e";
		}
%>
<tr bgcolor="<%=color%>">
<td style="<%=tdStyle%>"><%=++i%></td>
<td style="<%=tdStyle%>"><%=payment.getCategory()%></td>
<td style="<%=tdStyle%>"><%=payment.getComment()%></td>
<td style="<%=tdStyle%>text-align:right;"><%=payment.getAmount()%></td>
<td style="<%=tdStyle%>text-align:center;"><%=DateUtil.format(payment.getDate())%></td>
</tr>
<%
		moneyMonth.add(payment.getAmount());
	}
%>
</table>