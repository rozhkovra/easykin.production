<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.model.task.*"%>
<%@ page import="ru.rrozhkov.easykin.task.*"%>
<%@ page import="ru.rrozhkov.easykin.task.impl.filter.*"%>
<%
    UrlConfigurator urlConfigurator = new UrlConfigurator();
	final AdapterFactory adapterFactory = new AdapterFactory();
	final TaskAdapter taskAdapter = adapterFactory.task();
	TaskFilterBean filter = taskAdapter.extractFilter(request);
%>
<h3 class="box-title">
<span class="label"><a href="<%=urlConfigurator.getFilterUrlForPriority(request, session, -1)%>">Все</a></span>
<span class="label"><a href="<%=urlConfigurator.getFilterUrlForPriority(request, session, Priority.priority(Priority.IMPOTANT_FAST))%>"><%=Priority.IMPOTANT_FAST%></a></span>
<span class="label"><a href="<%=urlConfigurator.getFilterUrlForPriority(request, session, Priority.priority(Priority.IMPOTANT_NOFAST))%>"><%=Priority.IMPOTANT_NOFAST%></a></span>
<span class="label"><a href="<%=urlConfigurator.getFilterUrlForPriority(request, session, Priority.priority(Priority.SIMPLE))%>"><%=Priority.SIMPLE%></a></span>
</h3>
<button type="button" class="btn btn-default pull-right" id="daterange-btn">
	<span>
	  <i class="fa fa-calendar"></i> Период
	</span>
	<i class="fa fa-caret-down"></i>
</button>
<form id="taskFilter">
<input type="hidden" id="fromDate" name="fromDate" value="<%=filter.getFromDate()%>"/>
<input type="hidden" id="toDate" name="toDate" value="<%=filter.getToDate()%>"/>
<input type="hidden" id="categoryId" name="categoryId" value="<%=filter.getCategoryId()%>"/>
<input type="hidden" id="statusId" name="statusId" value="<%=filter.getStatusId()%>"/>
<input type="hidden" id="priorityId" name="priorityId" value="<%=filter.getPriorityId()%>"/>
<input type="hidden" id="moduleId" name="moduleId" value="<%=filter.getModuleId()%>"/>
</form>

<!-- page script -->
<script>
  $(function () {
	$('#daterange-btn span').html('<%=DateUtil.format(filter.getFromDate())%> - <%=DateUtil.format(filter.getToDate())%>')
  })
</script>
