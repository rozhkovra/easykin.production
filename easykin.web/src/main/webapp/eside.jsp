<%@ page import="java.util.*"%>
<%@ page import="org.hsqldb.jdbc.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.core.collection.*"%>
<%@ page import="ru.rrozhkov.easykin.core.filter.*"%>
<%@ page import="ru.rrozhkov.easykin.core.filter.util.*"%>
<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.model.category.*"%>
<%@ page import="ru.rrozhkov.easykin.model.task.*"%>
<%@ page import="ru.rrozhkov.easykin.model.person.*"%>
<%@ page import="ru.rrozhkov.easykin.model.person.util.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="ru.rrozhkov.easykin.person.auth.*"%>
<%@ page import="ru.rrozhkov.easykin.task.*"%>
<%@ page import="ru.rrozhkov.easykin.task.db.impl.*"%>
<%@ page import="ru.rrozhkov.easykin.task.impl.filter.*"%>
<%@ page import="ru.rrozhkov.easykin.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
    UrlConfigurator urlConfigurator = new UrlConfigurator();
    ModuleManager moduleManager = ModuleManager.instance();
	String moduleId = request.getParameter("moduleId")!=null?String.valueOf(request.getParameter("moduleId")):"";
	IPerson person = AuthManager.instance().signedPerson();
%>
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="AdminLTE/img/avatar5.png" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p><%=PersonUtil.fi(person)%></p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <!-- search form -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
          <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">Меню</li>
        <li class="active treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>Модули</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
<%
	for(String module : moduleManager.activeModules()){
	    if (!module.equals(ru.rrozhkov.easykin.module.Module.SERVICE) &&
	        !module.equals(ru.rrozhkov.easykin.module.Module.WORK) &&
	        !module.equals(ru.rrozhkov.easykin.module.Module.JIRA)) {
%><li class="<%=urlConfigurator.getModuleClass(request, module)%>"><a href="<%=urlConfigurator.getFilterUrlForModule(request, session, module)%>"><i class="fa fa-circle-o"></i> <%=ru.rrozhkov.easykin.module.Module.name(module)%></a></li>
<%
        }
    }
%>
          </ul>
        </li>
<%
	for(String module : moduleManager.activeModules()){
        if (ru.rrozhkov.easykin.module.Module.JIRA.equals(module)) {
%>
            <li class="active treeview">
              <a href="#">
                <i class="fa fa-industry"></i> <span><%=ru.rrozhkov.easykin.module.Module.name(ru.rrozhkov.easykin.module.Module.JIRA)%></span>
                <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
              </a>
              <ul class="treeview-menu">
                <li><a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.JIRA, ru.rrozhkov.easykin.module.SubModule.INDEX)%>"><i class="fa fa-hourglass-half"></i> Задачи</a></li>
                <li><a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.JIRA, ru.rrozhkov.easykin.module.SubModule.WORKLOG)%>"><i class="fa fa-hourglass-half"></i> Активности</a></li>
              </ul>
            </li>
<%      }
        if (ru.rrozhkov.easykin.module.Module.WORK.equals(module)) {
%>
            <li class="active treeview">
              <a href="#">
                <i class="fa fa-industry"></i> <span><%=ru.rrozhkov.easykin.module.Module.name(ru.rrozhkov.easykin.module.Module.WORK)%></span>
                <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
              </a>
              <ul class="treeview-menu">
                <li><a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.WORK, ru.rrozhkov.easykin.module.SubModule.INDEX)%>"><i class="fa fa-hourglass-half"></i> Активности</a></li>
                <li><a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.WORK, ru.rrozhkov.easykin.module.SubModule.STATISTICS )%>"><i class="fa fa-tasks"></i> Статистика</a></li>
              </ul>
            </li>
<%      }
        if (ru.rrozhkov.easykin.module.Module.SERVICE.equals(module)) {
%>
            <li class="active treeview">
              <a href="#">
                <i class="fa fa-recycle"></i> <span><%=ru.rrozhkov.easykin.module.Module.name(ru.rrozhkov.easykin.module.Module.SERVICE)%></span>
                <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
              </a>
              <ul class="treeview-menu">
                <li><a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.SERVICE, ru.rrozhkov.easykin.module.SubModule.INDEX)%>"><i class="fa fa-money"></i> Платежи</a></li>
                <li><a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.SERVICE, ru.rrozhkov.easykin.module.SubModule.RATES )%>"><i class="fa fa-calculator"></i> Тарифы</a></li>
                <li><a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.SERVICE, ru.rrozhkov.easykin.module.SubModule.INFO )%>"><i class="fa fa-info"></i> Инфо</a></li>
                <li><a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.SERVICE, ru.rrozhkov.easykin.module.SubModule.STATISTICS )%>"><i class="fa fa-bar-chart-o"></i> Статистика</a></li>
              </ul>
            </li>
<%      }
    }
            if (ru.rrozhkov.easykin.module.Module.TASK.equals(moduleId)) {
    %>
                <li class="header">Статус</li>
                <li><a href="<%=urlConfigurator.getFilterUrlForStatus(request, session, -1)%>"><i class="fa fa-circle-o text-aqua"></i> <span>Все</span></a></li>
                <li><a href="<%=urlConfigurator.getFilterUrlForStatus(request, session, Status.status(Status.OPEN))%>"><i class="fa fa-circle-o text-yellow"></i> <span><%=Status.OPEN%></span></a></li>
                <li><a href="<%=urlConfigurator.getFilterUrlForStatus(request, session, Status.status(Status.CLOSE))%>"><i class="fa fa-circle-o text-green"></i> <span><%=Status.CLOSE%></span></a></li>
    <%      }

%>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>