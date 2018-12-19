<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
    ModuleManager moduleManager = ModuleManager.instance();
    UrlConfigurator urlConfigurator = new UrlConfigurator();
%>
<section class="content">
<div class="row">
    <jsp:include page="task/box.jsp"/>
    <jsp:include page="work/mvideo/box.jsp"/>
    <jsp:include page="service/box.jsp"/>
    <jsp:include page="fin/box.jsp"/>
    <jsp:include page="jira/box.jsp"/>
</div>
<div class="row">
<%
    if (moduleManager.isActive(ru.rrozhkov.easykin.module.Module.TASK)) {
%>

<div class="col-md-5">
<!-- TO DO List -->
<div class="box box-primary">
<div class="box-header">
  <i class="ion ion-clipboard"></i>
  <h3 class="box-title">Задачи</h3>

</div>
<!-- /.box-header -->
<div class="box-body">
          <!-- Custom Tabs -->
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              <li class="active"><a href="#tab_1" data-toggle="tab">В работе</a></li>
              <li><a href="#tab_2" data-toggle="tab">Просрочка</a></li>
            </ul>
            <div class="tab-content">
              <div class="tab-pane active" id="tab_1">
                    <jsp:include page="task/todo.jsp"/>
              </div>
              <!-- /.tab-pane -->
              <div class="tab-pane" id="tab_2">
                    <jsp:include page="task/overdue.jsp"/>
              </div>
              <!-- /.tab-pane -->
            </div>
            <!-- /.tab-content -->
          </div>
          <!-- nav-tabs-custom -->
</div>
<!-- /.box-body -->
<div class="box-footer clearfix no-border">
  <a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.TASK)%>">Подробно</a>
</div>
</div>
<!-- /.box -->
</div>
<!-- /.col -->
<%
    }
    if (moduleManager.isActive(ru.rrozhkov.easykin.module.Module.WORK)) {
%>
    <div class="col-md-7">

    <!-- TABLE: WORK -->
    <div class="box box-info">
    <div class="box-header with-border">
      <h3 class="box-title">Работа</h3>
    </div>
    <!-- /.box-header -->
    <div class="box-body">
      <div class="table-responsive">
      <jsp:include page="work/mvideo/short.jsp"/>
      </div>
      <!-- /.table-responsive -->
    </div>
    <!-- /.box-body -->
    <div class="box-footer clearfix no-border">
        <a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.WORK)%>">Подробно</a>
    </div>
    </div>
    <!-- /.box -->
    </div>
<%
    }
%>
</div>
<%
    if (moduleManager.isActive(ru.rrozhkov.easykin.module.Module.SERVICE)) {
%>
<div class="row">
    <div class="col-md-5">
        <div class="box">
        <div class="box-header">
            <h3 class="box-title">Коммунальные услуги</h3>
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
      <!-- BAR CHART -->
      <div class="box box-success">
        <div class="box-header with-border">
          <h3 class="box-title">Коммунальные платежи - Статистика</h3>
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
<%
    }
%>

</section>