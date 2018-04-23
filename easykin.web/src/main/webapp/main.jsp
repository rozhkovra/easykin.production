<%@ page import="ru.rrozhkov.lib.util.*"%>
<%@ page import="ru.rrozhkov.easykin.model.category.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
	int categoryId = request.getParameter("categoryId")!=null?Integer.valueOf(request.getParameter("categoryId")):-1;
	String moduleId = request.getParameter("moduleId")!=null?String.valueOf(request.getParameter("moduleId")):"";
%>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1><%=Module.name(moduleId)%></h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active"><%=Module.name(moduleId)%></li>
      </ol>
    </section>
<%
	if (Module.PAYMENT.equals(moduleId) || Module.FIN.equals(moduleId)){
%><jsp:include page="payment/payments.jsp"/><%
	}else if(Module.WORK.equals(moduleId)){
%><jsp:include page="work/work.jsp"/><%
	}else if(Module.SERVICE.equals(moduleId)){
%><jsp:include page="service/statistics.jsp"/><jsp:include page="service/service.jsp"/><%
    }else{
%>
<jsp:include page="task/tasks.jsp"/>
<%}%>
</div>
