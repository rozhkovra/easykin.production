<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.person.auth.*"%>
<%@ page import="ru.rrozhkov.easykin.model.task.*"%>
<%@ page import="ru.rrozhkov.easykin.model.category.*"%>
<%@ page import="ru.rrozhkov.easykin.model.person.*"%>
<%@ page import="ru.rrozhkov.lib.util.*"%>
<%@ page import="ru.rrozhkov.lib.filter.util.*"%>
<%@ page import="ru.rrozhkov.lib.filter.*"%>
<%@ page import="ru.rrozhkov.lib.collection.*"%>
<%@ page import="ru.rrozhkov.easykin.task.impl.filter.*"%>
<%@ page import="java.util.*"%>
<%@ page import="org.hsqldb.jdbc.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<section class="content">
<div class="row">
<div class="col-xs-12">
<div class="box">
<div class="box-header">
<h3 class="box-title"><jsp:include page="priorities.jsp"/></h3>
<button type="button" class="btn btn-default pull-right" id="daterange-btn">
	<span>
	  <i class="fa fa-calendar"></i> Период
	</span>
	<i class="fa fa-caret-down"></i>
</button>
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
	int i = 0;
	Collection<IFilter> filters = CollectionUtil.<IFilter>create();
	int categoryId = request.getParameter("categoryId")!=null?Integer.valueOf(request.getParameter("categoryId")):-1;
	int statusId = request.getParameter("statusId")!=null?Integer.valueOf(request.getParameter("statusId")):-1;
	int priorityId = request.getParameter("priorityId")!=null?Integer.valueOf(request.getParameter("priorityId")):-1;
	Date fromDate = request.getParameter("fromDate")!=null?DateUtil.parse(request.getParameter("fromDate")):DateUtil.parse("01.01.2000");
	Date toDate = request.getParameter("toDate")!=null?DateUtil.parse(request.getParameter("toDate")):DateUtil.parse("01.01.3000");
	String moduleId = request.getParameter("moduleId")!=null?String.valueOf(request.getParameter("moduleId")):"";
	IPerson person = AuthManager.instance().signedPerson();
	TaskFilterBean bean = TaskFilterFactory.bean(statusId, categoryId, priorityId,fromDate, toDate, person.getId());
	Collection<ITask> tasks = (Collection<ITask>)ModuleManager.invoke(Module.TASK, "tasks", bean);
	for(ITask task : tasks){
		String taskClass = "";
		String dateClass = "";
        if(Status.CLOSE.equals(task.getStatus())){
        	if(task.getCloseDate().getTime()>task.getPlanDate().getTime())
        		taskClass = "label bg-gray";
        	else
        		taskClass = "label bg-green";
        }else{
        	taskClass  = "";
        	if(Priority.IMPOTANT_FAST.equals(task.getPriority())){
        		taskClass  = "label bg-yellow";
        	}
			if(Priority.IMPOTANT_NOFAST.equals(task.getPriority())){
				taskClass  = "label bg-blue";
			}
			if (new Date().getTime()>task.getPlanDate().getTime()) {
				dateClass = "label bg-gray";
			}
        }
        String comments = "";
        for(IComment comment : task.comments()){
        	comments += comment.getText()+"|";
        }
%>


<tr >
<td align="center"><%=++i%></td>
<td align="center"><span class="<%=taskClass%>"><%=task.getId()%></span></td>
<td ><%=task.getName()%><br/><span style="font-size:12px;"><%=comments%></span></td>
<td align="center"><span class="<%=dateClass%>"><%=DateUtil.format(task.getPlanDate())%></span></td>
<td align="center"><%=task.getCategory().getName()%></td>
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
<form id="taskFilter">
<input type="hidden" id="fromDate" name="fromDate" value="<%=fromDate%>"/>
<input type="hidden" id="toDate" name="toDate" value="<%=toDate%>"/>
<input type="hidden" id="categoryId" name="categoryId" value="<%=categoryId%>"/>
<input type="hidden" id="statusId" name="statusId" value="<%=statusId%>"/>
<input type="hidden" id="priorityId" name="priorityId" value="<%=priorityId%>"/>
<input type="hidden" id="moduleId" name="moduleId" value="<%=moduleId%>"/>
</form>


<!-- page script -->
<script>
  $(function () {
    $('#tasks').DataTable()
	$('#daterange-btn span').html('<%=DateUtil.format(fromDate)%> - <%=DateUtil.format(toDate)%>')

	$('#daterange-btn').daterangepicker(
	{
	  ranges   : {
		'Неделя' : [moment().startOf('week'), moment().endOf('week')],
		[moment().format('MMMM')]  : [moment().startOf('month'), moment().endOf('month')],
		[moment().subtract(1, 'month').format('MMMM')]  : [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')],
		[moment().add(1, 'month').format('MMMM')]  : [moment().add(1, 'month').startOf('month'), moment().add(1, 'month').endOf('month')]
	  },
	  startDate: moment().subtract(10, 'days'),
	  endDate  : moment()
	},
	function (start, end) {
	  $('#daterange-btn span').html(start.format('DD.MM.YYYY') + ' - ' + end.format('DD.MM.YYYY'))
	  $('#fromDate').val(start.format('DD.MM.YYYY'));
	  $('#toDate').val(end.format('DD.MM.YYYY'));
	  $('#taskFilter').submit();
	}
	)
  })
</script>
