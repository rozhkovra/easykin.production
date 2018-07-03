<%@ page import="java.util.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.util.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="ru.rrozhkov.easykin.service.*"%>
<%@ page import="ru.rrozhkov.easykin.task.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
    UrlConfigurator urlConfigurator = new UrlConfigurator();
%>
<section class="content">
<div class="row">
<div class="col-lg-3 col-xs-6">
  <!-- small box -->
  <div class="small-box bg-gray">
    <div class="inner">
      <h3>10</h3>

      <p>Просрочено</p>
    </div>
    <div class="icon">
      <i class="fa fa-tasks"></i>
    </div>
    <a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.TASK)%>"class="small-box-footer">Подробно <i class="fa fa-arrow-circle-right"></i></a>
  </div>
</div>
<div class="col-lg-3 col-xs-6">
<jsp:include page="work/mvideo/box.jsp"/>
</div>
<!-- ./col -->
<div class="col-lg-3 col-xs-6">
<jsp:include page="service/box.jsp"/>
</div>
<!-- ./col -->
<div class="col-lg-3 col-xs-6">
<jsp:include page="payment/box.jsp"/>
</div>
</div>
<div class="row">
<div class="col-md-5">

<!-- TO DO List -->
<div class="box box-primary">
<div class="box-header">
  <i class="ion ion-clipboard"></i>

  <h3 class="box-title">Задачи</h3>

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
  <a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.TASK)%>">Подробно</a>
</div>
</div>
<!-- /.box -->
</div>
<!-- /.col -->

    <div class="col-md-7">

    <!-- TABLE: WORK -->
    <div class="box box-info">
    <div class="box-header with-border">
      <h3 class="box-title">Работа</h3>

      <div class="box-tools pull-right">
        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
        </button>
        <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
      </div>
    </div>
    <!-- /.box-header -->
    <div class="box-body">
      <div class="table-responsive">
      <jsp:include page="work/mvideo/index.jsp"/>
      </div>
      <!-- /.table-responsive -->
    </div>
    <!-- /.box-body -->
    </div>
    <!-- /.box -->

    </div>


</div>
<div class="row">
    <div class="col-md-5">
    <div class="box">
    <div class="box-header">
    <h3 class="box-title">Комуналльные услуги</h3>
    </div>
    <div class="box-body">
    <jsp:include page="service/short.jsp"/>
    </div>
    <!--/.box-body-->
    </div>
    <!--/.box-->
    </div>
    <!-- /.col -->


    <div class="col-md-7">

    <!-- TABLE: FINANCE -->
    <div class="box box-info">
    <div class="box-header with-border">
      <h3 class="box-title">Финансы</h3>

      <div class="box-tools pull-right">
        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
        </button>
        <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
      </div>
    </div>
    <!-- /.box-header -->
    <div class="box-body">
      <div class="table-responsive">
      <jsp:include page="fin/index.jsp"/>
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
          <h3 class="box-title">Комуналльные платежи - Статистика</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
            </button>
          </div>
        </div>
        <div class="box-body">
        <jsp:include page="service/statistics.jsp"/>
        </div>
        <!-- /.box-body -->
      </div>
      <!-- /.box -->
    </div>
</div>
<!-- /.row -->

</section>