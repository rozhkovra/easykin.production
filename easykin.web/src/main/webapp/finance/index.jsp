<%@ page import="java.util.*"%>
<%@ page import="ru.rrozhkov.lib.util.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.finance.*"%>
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
	final AdapterFactory adapterFactory = new AdapterFactory();
	final FinanceAdapter financeAdapter = adapterFactory.finance();

	Collection<FinanceBean> payments = financeAdapter.finance();
	for (FinanceBean payment : payments) {
%>
<tr>
<td><%=payment.getNum()%></td>
<td><%=payment.getPayment().getCategory()%></td>
<td><%=payment.getPayment().getComment()%></td>
<td align="right"><%=payment.getPayment().getAmount()%></td>
<td align="center"><%=DateUtil.format(payment.getPayment().getDate())%></td>
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