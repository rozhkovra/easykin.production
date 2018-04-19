<%@ page import="ru.rrozhkov.lib.util.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
  <header class="main-header">
    <!-- Logo -->
    <a href="index.jsp" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      	<span class="logo-mini">        
          <img src="icon/logo.ico" width="40" height="40" class="img-circle" alt="Logo Image">
	</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><img src="icon/logo.ico" width="40" height="40" class="img-circle" alt="Logo Image">&nbsp;&nbsp;&nbsp;<b>EasyKin</b></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu">
	  <span><%=DateUtil.formatWeek(new Date())%></span>
	  <span><a href="index.jsp?signout=signout">Выйти</a></span>

      </div>
    </nav>
  </header>