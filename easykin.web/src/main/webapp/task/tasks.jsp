<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.person.auth.*"%>
<%@ page import="ru.rrozhkov.easykin.model.task.*"%>
<%@ page import="ru.rrozhkov.easykin.model.category.*"%>
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
</div>

<div class="box-body">
<table id="tasks" width="100%"  class="table table-bordered table-hover">
  <col width="30"/>
  <col width="30"/>
  <col/>
  <col width="120"/>
  <col width="150"/>
  <col width="150"/>
  <col width="120"/>
<thead>
<tr>
<th>№</th>
<th>ID</th>
<th>Описание</th>
<th>Выполнить до</th>
<th>Приоритет</th>
<th>Категория</th>
<th>Дата</th>
</tr>
</thead>
<tbody>
<%
	int i = 0;
	Collection<ITask> tasks = (Collection<ITask>)ModuleManager.invoke(Module.TASK, "tasks", AuthManager.instance().signedPerson());
	Collection<IFilter> filters = CollectionUtil.<IFilter>create();
	int categoryId = request.getParameter("categoryId")!=null?Integer.valueOf(request.getParameter("categoryId")):-1;
	if(categoryId!=-1 && categoryId!=9){			
		ICategory category = CategoryFactory.create(categoryId, "");
		filters.add(TaskFilterFactory.category(category));
	}
	int statusId = request.getParameter("statusId")!=null?Integer.valueOf(request.getParameter("statusId")):-1;
	if(statusId!=-1){			
		Status status = Status.status(statusId);
		filters.add(TaskFilterFactory.status(status));
	}
	int priorityId = request.getParameter("priorityId")!=null?Integer.valueOf(request.getParameter("priorityId")):-1;
	if(priorityId!=-1){			
		Priority priority = Priority.priority(priorityId);
		filters.add(TaskFilterFactory.priority(priority));
	}
	tasks = FilterUtil.filter(tasks, filters);
	for(ITask task : tasks){
		String taskClass = "";
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
<td align="center"><%=DateUtil.format(task.getPlanDate())%></td>
<td align="center"><%=task.getPriority()%></td>
<td align="center"><%=task.getCategory().getName()%></td>
<td align="center"><%=DateUtil.format(task.getCreateDate())%></td>
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

<!-- jQuery 3 -->
<script src="../AdminLTE/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../AdminLTE/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="../AdminLTE/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="../AdminLTE/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="../AdminLTE/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../AdminLTE/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../AdminLTE/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../AdminLTE/js/demo.js"></script>
<!-- page script -->
<script>
  $(function () {
    $('#tasks').DataTable({
      'paging'      : true,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false
    })

  })
</script>
