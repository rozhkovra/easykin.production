<%@ page import="java.util.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.util.*"%>
<%@ page import="ru.rrozhkov.easykin.service.*"%>
<%@ page import="ru.rrozhkov.easykin.task.*"%>
<%@ page import="ru.rrozhkov.easykin.finance.*"%>
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
  <button type="button" class="btn btn-default pull-right"><i class="fa fa-plus"></i> Add item</button>
</div>
</div>
<!-- /.box -->
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
<div class="box-footer clearfix">
  <a href="javascript:void(0)" class="btn btn-sm btn-info btn-flat pull-left">Place New Order</a>
  <a href="javascript:void(0)" class="btn btn-sm btn-default btn-flat pull-right">View All Orders</a>
</div>
<!-- /.box-footer -->
</div>
<!-- /.box -->

</div>
</div>
<div class="row">
    <div class="col-md-12">
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
    <th>Вода</th>
    <th>Гор.вода</th>
    <th>Свет</th>
    <th>Газ</th>
    <th>Отопление</th>
    <th>Антенна</th>
    <th>Домофон</th>
    <th>Квартплата</th>
    <th>Кап.ремонт</th>
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
    <td align="center"><%=FormatUtil.formatMoney(service.getWater())%></td>
    <td align="center"><%=FormatUtil.formatMoney(service.getHotWater())%></td>
    <td align="center"><%=FormatUtil.formatMoney(service.getElectricity())%></td>
    <td align="center"><%=FormatUtil.formatMoney(service.getGaz())%></td>
    <td align="center"><%=FormatUtil.formatMoney(service.getHeating())%></td>
    <td align="center"><%=FormatUtil.formatMoney(service.getAntenna())%></td>
    <td align="center"><%=FormatUtil.formatMoney(service.getIntercom())%></td>
    <td align="center"><%=FormatUtil.formatMoney(service.getHouse())%></td>
    <td align="center"><%=FormatUtil.formatMoney(service.getRepair())%></td>
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
</div>
<!-- /.row -->
</section>

<!-- page script -->
<script>
  $(function () {
    $('#services').DataTable()
    $('#payments').DataTable()
    var barChartData = {
      labels  : ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
      datasets: [
        {
          label               : '2017',
          fillColor           : '#00a65a',
          strokeColor         : '#00a65a',
          pointColor          : '#00a65a',
          pointStrokeColor    : 'rgba(60,141,188,1)',
          pointHighlightFill  : '#fff',
          pointHighlightStroke: 'rgba(60,141,188,1)',
          data                : [5146.78, 5031.61, 5291.60, 4401.07, 3762.17, 4185.63, 4113.96, 4223.81, 4412.46, 4523.19, 4686.04, 4621.23]
        },
        {
          label               : '2018',
          fillColor           : 'rgba(60,141,188,0.9)',
          strokeColor         : 'rgba(60,141,188,0.8)',
          pointColor          : '#3b8bba',
          pointStrokeColor    : 'rgba(60,141,188,1)',
          pointHighlightFill  : '#fff',
          pointHighlightStroke: 'rgba(60,141,188,1)',
          data                : [4760.06, 4779.48, 4900.75, 4967.82, 4707.71, 4967.82, 0, 0, 0, 0, 0, 0]
        }
      ]
    }

    //-------------
    //- BAR CHART -
    //-------------
    var barChartCanvas               = $('#barChart').get(0).getContext('2d')
    var barChart                     = new Chart(barChartCanvas)
    var barChartOptions              = {
      //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
      scaleBeginAtZero        : true,
      //Boolean - Whether grid lines are shown across the chart
      scaleShowGridLines      : true,
      //String - Colour of the grid lines
      scaleGridLineColor      : 'rgba(0,0,0,.05)',
      //Number - Width of the grid lines
      scaleGridLineWidth      : 1,
      //Boolean - Whether to show horizontal lines (except X axis)
      scaleShowHorizontalLines: true,
      //Boolean - Whether to show vertical lines (except Y axis)
      scaleShowVerticalLines  : true,
      //Boolean - If there is a stroke on each bar
      barShowStroke           : true,
      //Number - Pixel width of the bar stroke
      barStrokeWidth          : 2,
      //Number - Spacing between each of the X value sets
      barValueSpacing         : 5,
      //Number - Spacing between data sets within X values
      barDatasetSpacing       : 1,
      //Boolean - whether to make the chart responsive
      responsive              : true,
      maintainAspectRatio     : true
    }

    barChartOptions.datasetFill = false
    barChart.Bar(barChartData, barChartOptions)

  })
</script>
