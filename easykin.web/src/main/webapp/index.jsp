<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="ru.rrozhkov.easykin.model.category.*"%>
<%@ page import="ru.rrozhkov.easykin.person.auth.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<html>
<title>EasyKin, <%=DateUtil.formatWeek()%></title>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>EasyKin</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="AdminLTE/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="AdminLTE/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="AdminLTE/bower_components/Ionicons/css/ionicons.min.css">
  <!-- daterange picker -->
  <link rel="stylesheet" href="AdminLTE/bower_components/bootstrap-daterangepicker/daterangepicker.css">
  <!-- bootstrap datepicker -->
  <link rel="stylesheet" href="AdminLTE/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
  <!-- iCheck for checkboxes and radio inputs -->
  <link rel="stylesheet" href="AdminLTE/plugins/iCheck/all.css">
  <!-- Bootstrap Color Picker -->
  <link rel="stylesheet" href="AdminLTE/bower_components/bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css">
  <!-- Bootstrap time Picker -->
  <link rel="stylesheet" href="AdminLTE/plugins/timepicker/bootstrap-timepicker.min.css">
  <!-- Select2 -->
  <link rel="stylesheet" href="AdminLTE/bower_components/select2/dist/css/select2.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="AdminLTE/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="AdminLTE/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="AdminLTE/css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <!-- jQuery 3 -->
  <script src="AdminLTE/bower_components/jquery/dist/jquery.min.js"></script>
  <!-- Bootstrap 3.3.7 -->
  <script src="AdminLTE/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
  <!-- ChartJS -->
  <script src="AdminLTE/bower_components/chart.js/Chart.js"></script>
  <!-- DataTables -->
  <script src="AdminLTE/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
  <script src="AdminLTE/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
  <!-- date-range-picker -->
  <script src="AdminLTE/bower_components/moment/min/moment.min.js"></script>
  <script src="AdminLTE/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
  <!-- bootstrap datepicker -->
  <script src="AdminLTE/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
  <!-- bootstrap color picker -->
  <script src="AdminLTE/bower_components/bootstrap-colorpicker/dist/js/bootstrap-colorpicker.min.js"></script>
  <!-- bootstrap time picker -->
  <script src="AdminLTE/plugins/timepicker/bootstrap-timepicker.min.js"></script>
  <!-- SlimScroll -->
  <script src="AdminLTE/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
  <!-- iCheck 1.0.1 -->
  <script src="AdminLTE/plugins/iCheck/icheck.min.js"></script>
  <!-- FastClick -->
  <script src="AdminLTE/bower_components/fastclick/lib/fastclick.js"></script>
  <!-- SlimScroll -->
  <script src="AdminLTE/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
  <!-- AdminLTE App -->
  <script src="AdminLTE/js/adminlte.min.js"></script>
  <!-- AdminLTE for demo purposes -->
  <script src="AdminLTE/js/demo.js"></script>

  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
  <link rel="shortcut icon" href="icon/logo.ico" />

  <!-- EasyKin scripts -->
  <script src="js/easykin.work.js"></script>
  <script src="js/easykin.service.js"></script>
  <script src="js/easykin.payment.js"></script>
  <script src="js/easykin.task.js"></script>
  <script src="js/easykin.core.js"></script>
  <script src="js/easykin.finance.js"></script>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
<jsp:include page="header.jsp"/>
<jsp:include page="eside.jsp"/>
<div class="content-wrapper">
<%
    WebModuleManager moduleManager = new WebModuleManager(request);
%>
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h4><%=moduleManager.moduleName()%>&nbsp;&nbsp;<i id="refresh" class="fa fa-refresh" style="cursor:pointer;"></i></h4>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active"><%=moduleManager.moduleName()%></li>
      </ol>
    </section>
    <section class="content">
    <div class="row">
    <div class="col-xs-12">
    <jsp:include page="<%=moduleManager.alertUrl()%>"/>
    </div>
    </div>
    <div class="row">
    <div class="col-xs-12">
    <div class="box">
    <div class="box-body">
    <jsp:include page="<%=moduleManager.url()%>"/>
    </div>
    </div>
    </div>
    </div>
    </section>
</div>
</div>
</body>
</html>