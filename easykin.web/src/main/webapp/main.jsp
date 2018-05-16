<%@ page import="ru.rrozhkov.lib.util.*"%>
<%@ page import="ru.rrozhkov.easykin.model.category.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
<%
	String moduleId = request.getParameter("moduleId")!=null?String.valueOf(request.getParameter("moduleId")):"";
%>
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1><%=Module.name(moduleId)%></h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active"><%=Module.name(moduleId)%></li>
      </ol>
    </section>
<%
    if(ModuleManager.activeModules().contains(moduleId)) {
        if (Module.PAYMENT.equals(moduleId)) {
%><jsp:include page="payment/index.jsp"/><%
        } else if (Module.FIN.equals(moduleId)){
%><jsp:include page="finance/index.jsp"/><%
        } else if(Module.WORK.equals(moduleId)) {
%><jsp:include page="work/index.jsp"/><%
        } else if (Module.SERVICE.equals(moduleId)) {
%><jsp:include page="service/statistics.jsp"/><jsp:include page="service/index.jsp"/><%
        } else {
%><jsp:include page="task/index.jsp"/>
<%
      }
    }
%>
</div>
