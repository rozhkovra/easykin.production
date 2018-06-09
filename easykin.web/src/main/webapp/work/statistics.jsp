<%@ page import="ru.rrozhkov.lib.util.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.work.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<section class="content">
<div class="row">
<div class="col-xs-12">

<div class="box">
<div class="box-header">
<h3 class="box-title">Статистика</h3>
</div>

<div class="box-body">
<table id="activitiesstatistics" class="table table-bordered table-hover">
<thead>
<tr>
<th>№</th>
<th>Имя</th>
<th>Часы</th>
</tr>
</thead>
<tbody>
<%
	final AdapterFactory adapterFactory = new AdapterFactory();
	final WorkAdapter workAdapter = adapterFactory.work();
	Collection<GroupActivityBean> activities = workAdapter.groupActivities();
	for(GroupActivityBean bean : activities) {
%>
<tr>
<td><%=bean.getNum()%></td>
<td><%=bean.getName()%></td>
<td><%=bean.getTime()%></td>
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
    $('#activitiesstatistics').DataTable()
  })
</script>