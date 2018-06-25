<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.model.category.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
<%
	String moduleId = request.getParameter("moduleId")!=null?String.valueOf(request.getParameter("moduleId")):"";
	String subModuleId = request.getParameter("subModuleId")!=null?String.valueOf(request.getParameter("subModuleId")):"";
	String module = moduleId.isEmpty()?moduleId:Module.name(moduleId);
%>
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h4><%=module%>&nbsp;&nbsp;<i id="refresh" class="fa fa-refresh" style="cursor:pointer;"></i></h4>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active"><%=module%></li>
      </ol>
    </section>
<%
    ModuleManager moduleManager = ModuleManager.instance();
    if(moduleManager.activeModules().contains(moduleId)) {
        if (Module.PAYMENT.equals(moduleId)) {
%><jsp:include page="payment/index.jsp"/><%
        } else if (Module.FIN.equals(moduleId)){
%><jsp:include page="finance/index.jsp"/><%
        } else if(Module.WORK.equals(moduleId)) {
            if(SubModule.INDEX.equals(subModuleId)) {
%><jsp:include page="work/mvideo/index.jsp"/><%
            } else if(SubModule.STATISTICS.equals(subModuleId)) {
%><jsp:include page="work/mvideo/statistics.jsp"/><%
            }
        } else if (Module.SERVICE.equals(moduleId)) {
            if(SubModule.INDEX.equals(subModuleId)) {
%><jsp:include page="service/index.jsp"/><%
            } else if(SubModule.INFO.equals(subModuleId)) {
%><jsp:include page="service/info.html"/><%
            } else if(SubModule.RATES.equals(subModuleId)) {
%><jsp:include page="service/rates.jsp"/><%
            } else if(SubModule.STATISTICS.equals(subModuleId)) {
%><jsp:include page="service/statistics.jsp"/><%
            }
        } else {
%><jsp:include page="task/index.jsp"/>
<%
      }
    } else {
%><jsp:include page="dashboard.jsp"/>
<%
    }
%>
</div>

<!-- page script -->
<script>
  $('[id^=refresh]').click(
    function(){
        location.reload();
    }
  );
</script>