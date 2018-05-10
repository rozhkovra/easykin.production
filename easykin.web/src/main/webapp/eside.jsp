<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.person.auth.*"%>
<%@ page import="ru.rrozhkov.easykin.model.category.*"%>
<%@ page import="ru.rrozhkov.easykin.model.task.*"%>
<%@ page import="ru.rrozhkov.easykin.model.person.*"%>
<%@ page import="ru.rrozhkov.easykin.model.person.util.*"%>
<%@ page import="ru.rrozhkov.easykin.task.impl.filter.*"%>
<%@ page import="ru.rrozhkov.easykin.util.*"%>
<%@ page import="ru.rrozhkov.lib.util.*"%>
<%@ page import="ru.rrozhkov.lib.filter.util.*"%>
<%@ page import="ru.rrozhkov.lib.filter.*"%>
<%@ page import="ru.rrozhkov.lib.collection.*"%>
<%@ page import="ru.rrozhkov.easykin.task.db.impl.*"%>
<%@ page import="java.util.*"%>
<%@ page import="org.hsqldb.jdbc.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
	Collection<IFilter> filters = CollectionUtil.<IFilter>create();
	int categoryId = request.getParameter("categoryId")!=null?Integer.valueOf(request.getParameter("categoryId")):-1;
	int statusId = request.getParameter("statusId")!=null?Integer.valueOf(request.getParameter("statusId")):-1;
	int priorityId = request.getParameter("priorityId")!=null?Integer.valueOf(request.getParameter("priorityId")):-1;
	Date fromDate = request.getParameter("fromDate")!=null?DateUtil.parse(request.getParameter("fromDate")):DateUtil.parse("01.01.2000");
	Date toDate = request.getParameter("toDate")!=null?DateUtil.parse(request.getParameter("toDate")):DateUtil.parse("01.01.3000");
	String moduleId = request.getParameter("moduleId")!=null?String.valueOf(request.getParameter("moduleId")):"";
	IPerson person = AuthManager.instance().signedPerson();
	TaskFilterBean bean = TaskFilterFactory.bean(statusId, categoryId, priorityId,fromDate, toDate, person.getId());
	Collection<ITask> tasks = (Collection<ITask>)ModuleManager.invoke(Module.TASK, "tasks", bean);
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
	String moduleClass = "";
	for(String module : ModuleManager.activeModules()){
		if(module.equals(moduleId)) {
			moduleClass = "active";
		} else {
			moduleClass = "";
		}
%><li class="<%=moduleClass%>"><a href="index.jsp?<%="session="+session.getId()+"&priorityId="+priorityId+"&categoryId="+categoryId+"&moduleId="+module+"&statusId="+statusId%>"><i class="fa fa-circle-o"></i> <%=Module.name(module)%></a></li>
<%
	}
%>
          </ul>
        </li>

<%      if (Module.TASK.equals(moduleId)) {
%>
        <li class="active treeview">
          <a href="#">
            <i class="fa fa-files-o"></i> <span>Категории</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
<%	String categoryClass = "";
		if(-1 == categoryId) {
			categoryClass = "active";
		}
%>		<li class="<%=categoryClass%>"><a href="index.jsp?<%="session="+session.getId()+"&priorityId="+priorityId+"&moduleId="+moduleId+"&statusId="+statusId%>"><span>Все</span></a></li>
<%
	for(ICategory category : CategoryHandler.select()){
		if(category.getId() == categoryId) {
			categoryClass = "active";
		} else {
			categoryClass = "";
		}
		int taskCount = 0;
		taskCount = FilterUtil.filter(tasks, TaskFilterFactory.category(category)).size();
%>		<li class="<%=categoryClass%>"><a href="index.jsp?<%="session="+session.getId()+"&priorityId="+priorityId+"&categoryId="+category.getId()+"&moduleId="+moduleId+"&statusId="+statusId%>"><span><%=category.getName()%> (<%=taskCount%>)</span></a></li><%
	}
%>
          </ul>
        </li>
        <li class="header">Статус</li>
        <li><a href="index.jsp?<%="session="+session.getId()+"&priorityId="+priorityId+"&categoryId="+categoryId+"&moduleId="+moduleId+"&statusId=-1"%>"><i class="fa fa-circle-o text-aqua"></i> <span>Все</span></a></li>
	<li><a href="index.jsp?<%="session="+session.getId()+"&priorityId="+priorityId+"&categoryId="+categoryId+"&moduleId="+moduleId+"&statusId="+Status.status(Status.OPEN)%>"><i class="fa fa-circle-o text-yellow"></i> <span><%=Status.OPEN%></span></a></li>
	<li><a href="index.jsp?<%="session="+session.getId()+"&priorityId="+priorityId+"&categoryId="+categoryId+"&moduleId="+moduleId+"&statusId="+Status.status(Status.CLOSE)%>"><i class="fa fa-circle-o text-green"></i> <span><%=Status.CLOSE%></span></a></li>
<%      }
%>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>