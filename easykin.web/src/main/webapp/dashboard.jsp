<%@ page import="java.util.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.util.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="ru.rrozhkov.easykin.service.*"%>
<%@ page import="ru.rrozhkov.easykin.task.*"%>
<%@ page import="ru.rrozhkov.easykin.finance.*"%>
<%@ page import="ru.rrozhkov.easykin.work.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<section class="content">
<div class="row">
<div class="col-md-4">

<!-- TO DO List -->
<div class="box box-primary">
<div class="box-header">
  <i class="ion ion-clipboard"></i>

  <h3 class="box-title">To Do List</h3>

  <div class="box-tools pull-right">
    <ul class="pagination pagination-sm inline">
      <li><a href="#">&laquo;</a></li>
      <li><a href="#">1</a></li>
      <li><a href="#">2</a></li>
      <li><a href="#">3</a></li>
      <li><a href="#">&raquo;</a></li>
    </ul>
  </div>
</div>
<!-- /.box-header -->
<div class="box-body">
  <!-- See dist/js/pages/dashboard.js to activate the todoList plugin -->
  <ul class="todo-list">
<%
    UrlConfigurator urlConfigurator = new UrlConfigurator();
	final AdapterFactory adapterFactory = new AdapterFactory();
	final TaskAdapter taskAdapter = adapterFactory.task();
	Collection<TaskBean> tasks = taskAdapter.toDoTasks();
	for(TaskBean taskBean : tasks){
%>
    <li>
      <!-- drag handle -->
      <span class="handle">
            <i class="fa fa-ellipsis-v"></i>
            <i class="fa fa-ellipsis-v"></i>
          </span>
      <!-- checkbox -->
      <input type="checkbox" value="">
      <!-- todo text -->
      <span class="text">(<%=taskBean.getTask().getId()%>) <%=taskBean.getTask().getName()%></span>
      <!-- Emphasis label -->
      <!--small class="label label-danger"><i class="fa fa-clock-o"></i> 2 mins</small-->
      <!-- General tools such as edit or delete-->
      <div class="tools">
        <i class="fa fa-edit"></i>
        <i class="fa fa-trash-o"></i>
      </div>
    </li>
<%
    }
%>
  </ul>
</div>
<!-- /.box-body -->
<div class="box-footer clearfix no-border">
  <a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.TASK)%>">Задачи</a>
</div>
</div>
<!-- /.box -->
</div>
<!-- /.col -->

    <div class="col-md-8">

    <!-- TABLE: WORK -->
    <div class="box box-info">
    <div class="box-header with-border">
      <h3 class="box-title">Work</h3>

      <div class="box-tools pull-right">
        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
        </button>
        <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
      </div>
    </div>
    <!-- /.box-header -->
    <div class="box-body">
      <div class="table-responsive">
<table id="activities" class="table table-bordered table-hover">
<thead>
<tr>
<th>№</th>
<th>Дата</th>
<th>Часы</th>
<th>Тип задачи</th>
<th>ID задачи</th>
<th>Номер релиза</th>
<th>Комментарий</th>
</tr>
</thead>
<tbody>
<%
	final WorkAdapter workAdapter = adapterFactory.work();
	Collection<ActivityBean> activities = workAdapter.activities();
	for(ActivityBean bean : activities){
%>
<tr>
<td ><%=bean.getNum()%></td>
<td ><span class="<%=bean.getDateClass()%>"><%=DateUtil.format(bean.getActivity().getDate())%></span></td>
<td align="right"><%=bean.getActivity().getTime()%></td>
<td align="center;"><%=String.valueOf(bean.getActivity().getTaskType())%></td>
<td align="center;"><%=bean.getActivity().getName()%></td>
<td align="center;"><%=String.valueOf(bean.getActivity().getReleaseType())%></td>
<td align="center;"><%=bean.getActivity().getDesc()%></td>
</tr>
<%
	}
%>
</tbody>
</table>
      </div>
      <!-- /.table-responsive -->
    </div>
    <!-- /.box-body -->
    </div>
    <!-- /.box -->

    </div>


</div>
<div class="row">
    <div class="col-md-4">
    <div class="box">
    <div class="box-header">
    <h3 class="box-title">Services</h3>
    </div>
    <div class="box-body">
    <table id="services" class="table table-bordered table-hover">
    <thead>
    <tr>
    <th>№</th>
    <th>Период</th>
    <th>Дата</th>
    <th>Итого</th>
    </tr>
    </thead>
    <tbody>
    <%
    	int i = 0;
    	final ServiceAdapter adapter = adapterFactory.service();
        Collection<ServiceBean> services = adapter.services();
        for (ServiceBean service : services){
    %>
    <tr>
    <td align="center"><%=++i%></td>
    <td ><span class="<%=service.getServiceClass()%>"><%=service.getName()%></span></td>
    <td align="center"><%=DateUtil.format(service.getDate())%></td>
    <td style="<%=service.getTdStyle()%>text-align:right;"><%=FormatUtil.formatMoney(service.getItog())+(service.getNoPaid().free()?"":"/"+FormatUtil.formatMoney(service.getNoPaid()))%></td>
    </tr>
    <%
        }

    %>
    </tbody>
    </table>
    </div>
    <!--/.box-body-->
    </div>
    <!--/.box-->
    </div>
    <!-- /.col -->


    <div class="col-md-8">

    <!-- TABLE: FINANCE -->
    <div class="box box-info">
    <div class="box-header with-border">
      <h3 class="box-title">Finance</h3>

      <div class="box-tools pull-right">
        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
        </button>
        <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
      </div>
    </div>
    <!-- /.box-header -->
    <div class="box-body">
      <div class="table-responsive">
        <table  id="payments" class="table no-margin">
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
      <!-- /.table-responsive -->
    </div>
    <!-- /.box-body -->
    </div>
    <!-- /.box -->

    </div>
</div>
<!-- /.row -->

<div class="row">
    <div class="col-md-8">
      <!-- BAR CHART -->
      <div class="box box-success">
        <div class="box-header with-border">
          <h3 class="box-title">Statistics</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
            </button>
          </div>
        </div>
        <div class="box-body">
          <div class="chart">
            <canvas id="barChart" style="height:230px"></canvas>
          </div>
        </div>
        <!-- /.box-body -->
      </div>
      <!-- /.box -->
    </div>
</div>
<!-- /.row -->

</section>