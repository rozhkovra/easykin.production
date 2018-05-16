<%@ page import="ru.rrozhkov.lib.util.*"%>
<%@ page import="ru.rrozhkov.easykin.task.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<section class="content">
<div class="row">
<div class="col-xs-12">
<div class="box">
<div class="box-header">
<jsp:include page="/task/filter.jsp"/>
<!-- /.form group -->
</div>

<div class="box-body">
<table id="tasks" width="100%"  class="table table-bordered table-striped">
  <col width="30"/>
  <col width="30"/>
  <col/>
  <col width="120"/>
  <col width="150"/>
<thead>
<tr>
<th>№</th>
<th>ID</th>
<th>Описание</th>
<th>Срок</th>
<th>Категория</th>
</tr>
</thead>
<tbody>
<%
	Collection<TaskBean> tasks = TaskAdapter.tasks(request);
	for(TaskBean taskBean : tasks){
%>
<tr >
<td align="center"><%=taskBean.getNum()%></td>
<td align="center"><span class="<%=taskBean.getTaskClass()%>"><%=taskBean.getTask().getId()%></span></td>
<td ><%=taskBean.getTask().getName()%><br/><span style="font-size:12px;"><%=taskBean.getComments()%></span></td>
<td align="center"><span class="<%=taskBean.getDateClass()%>"><%=DateUtil.format(taskBean.getTask().getPlanDate())%></span></td>
<td align="center"><%=taskBean.getTask().getCategory().getName()%></td>
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
    $('#tasks').DataTable()
  })
</script>
