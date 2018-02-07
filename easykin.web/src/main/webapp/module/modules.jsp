<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.person.auth.*"%>
<%@ page import="ru.rrozhkov.easykin.model.category.*"%>
<%@ page import="ru.rrozhkov.easykin.model.task.*"%>
<%@ page import="ru.rrozhkov.easykin.task.impl.filter.*"%>
<%@ page import="ru.rrozhkov.easykin.util.*"%>
<%@ page import="ru.rrozhkov.lib.filter.util.*"%>
<%@ page import="ru.rrozhkov.lib.filter.*"%>
<%@ page import="ru.rrozhkov.lib.collection.*"%>
<%@ page import="ru.rrozhkov.easykin.task.db.impl.*"%>
<%@ page import="java.util.*"%>
<%@ page import="org.hsqldb.jdbc.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<div id="category">
<table border="0">
<%
	int statusId = request.getParameter("statusId")!=null?Integer.valueOf(request.getParameter("statusId")):-1;
	int priorityId = request.getParameter("priorityId")!=null?Integer.valueOf(request.getParameter("priorityId")):-1;
	int categoryId = request.getParameter("categoryId")!=null?Integer.valueOf(request.getParameter("categoryId")):-1;
	String urlParameters = "session="+session.getId()+"&statusId="+statusId+"&priorityId="+priorityId+"&categoryId="+categoryId;
	String moduleId = request.getParameter("moduleId")!=null?String.valueOf(request.getParameter("moduleId")):"";

	String tdStyle ="";
	if("".equals(moduleId)){
		tdStyle = "font-size:20px;font-style:italic;";
	}else{
		tdStyle = "font-size:25px;font-weight:bold;";
	}

	for(String module : ModuleManager.activeModules()){
        if (module.equals(moduleId)){
        	tdStyle="font-size:25px;font-weight:bold;";
	    } else {  
	    	tdStyle="font-size:20px;font-style:italic;";
	    }
        String urlParameters1=urlParameters+"&moduleId="+module;
		%><tr><td style="<%=tdStyle%>">
		<a href="index.jsp?<%=urlParameters1%>"><%=Module.name(module)%></a>
		</td></tr><%
	}
%>
</table>
</div>