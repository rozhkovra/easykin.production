<%@ page import="ru.rrozhkov.lib.util.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="ru.rrozhkov.easykin.service.gui.style.impl.custom.*"%>
<%@ page import="ru.rrozhkov.easykin.model.service.calc2.*"%>
<%@ page import="ru.rrozhkov.easykin.service.data.impl.stat.*"%>
<%@ page import="ru.rrozhkov.easykin.service.db.impl.calc2.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<section class="content">
<div class="row">
<div class="col-xs-12">

<div class="box">
<div class="box-header">
<h3 class="box-title">Тарифы</h3>
</div>

<div class="box-body">
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
	Collection<IRate> rates = StaticReadingDataProvider.rates2018_1;
	try {
		rates = new RateHandler().selectForDate(DateUtil.today());
	} catch (Exception e) {
		rates = StaticReadingDataProvider.rates2018_1;
	}

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
</div>
</div>
</div>
</div>
</section>
