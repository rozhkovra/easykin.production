<%@ page import="ru.rrozhkov.lib.util.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="ru.rrozhkov.easykin.service.gui.style.impl.custom.*"%>
<%@ page import="ru.rrozhkov.easykin.model.service.calc.impl.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<section class="content">
<div class="row">
<div class="col-xs-12">

<div class="box">
<div class="box-header">
<h3 class="box-title">Платежи</h3>
</div>

<div class="box-body">
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
<th>Итого</th>
</tr>
</thead>
<tbody>
<%
	String moduleId = request.getParameter("moduleId")!=null?String.valueOf(request.getParameter("moduleId")):"";

	int i = 0;
	ServiceCalcConverter converter = new ServiceCalcConverter(0);
	Collection<ServiceCalc> calcs = (Collection<ServiceCalc>)ModuleManager.invoke(moduleId, "calcs");
	String tdStyle = "";
	String serviceClass = "";

	for(ServiceCalc calc : calcs){
		if(calc.isPaid()){
    			serviceClass = "label bg-green";
	    		tdStyle = "font-weight:bold;";
    		}else{
    			serviceClass = "label bg-yellow";
			tdStyle = "";
		}
		String[] values = converter.convert(i, calc);
%>
<tr>
<td align="center"><%=++i%></td>
<td ><span class="<%=serviceClass%>"><%=values[0]%></span></td>
<td align="center"><%=values[1]%></td>
<td align="center"><%=values[2]%></td>
<td align="center"><%=values[3]%></td>
<td align="center"><%=values[4]%></td>
<td align="center"><%=values[5]%></td>
<td align="center"><%=values[6]%></td>
<td align="center"><%=values[7]%></td>
<td align="center"><%=values[8]%></td>
<td align="center"><%=values[9]%></td>
<td align="center"><%=values[10]%></td>
<td style="<%=tdStyle%>text-align:right;"><%=values[11]%></td>
</tr>
<%
	}
%>
</tbody>
</table>
</div>
</div>
</div>
</div>
</section>

<!-- page script -->
<script>
  $(function () {
    $('#services').DataTable()
  })
</script>