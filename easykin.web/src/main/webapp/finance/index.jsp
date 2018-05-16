<%@ page import="java.util.*"%>
<%@ page import="ru.rrozhkov.lib.util.*"%>
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
	Collection<FinanceBean> payments = FinanceAdapter.finance();
	for (FinanceBean payment : payments) {
%>
<tr >
<td style="height:30px;font-size:20px;"><%=payment.getNum()%></td>
<td style="height:30px;font-size:20px;"><%=payment.getPayment().getCategory()%></td>
<td style="height:30px;font-size:20px;"><%=payment.getPayment().getComment()%></td>
<td style="height:30px;font-size:20px;text-align:right;"><%=payment.getPayment().getAmount()%></td>
<td style="height:30px;font-size:20px;text-align:center;"><%=DateUtil.format(payment.getPayment().getDate())%></td>
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