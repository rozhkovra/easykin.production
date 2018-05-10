<%@ page import="ru.rrozhkov.lib.util.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.payment.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<section class="content">
<div class="row">
<div class="col-xs-12">

<div class="box">
<div class="box-header">
</div>

<div class="box-body">
<table id="payments" class="table table-bordered table-hover">
<thead>
<tr>
<th>№</th>
<th>Категория</th>
<th>Назначение</th>
<th>Сумма</th>
<th>Дата</th>
</tr>
</thead>
<tbody>
<%
	String moduleId = request.getParameter("moduleId")!=null?String.valueOf(request.getParameter("moduleId")):"";

	int i = 0;
	Collection<IPayment> payments = (Collection<IPayment>)ModuleManager.invoke(moduleId, "finance");
	String tdStyle = "height:30px;font-size:20px;";
	String color = "";

	for (IPayment payment : payments) {
%>
<tr >
<td style="<%=tdStyle%>"><%=++i%></td>
<td style="<%=tdStyle%>"><%=payment.getCategory()%></td>
<td style="<%=tdStyle%>"><%=payment.getComment()%></td>
<td style="<%=tdStyle%>text-align:right;"><%=payment.getAmount()%></td>
<td style="<%=tdStyle%>text-align:center;"><%=DateUtil.format(payment.getDate())%></td>
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
    $('#payments').DataTable()
  })
</script>