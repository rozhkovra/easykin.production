<%@ page import="ru.rrozhkov.easykin.model.task.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
	int statusId = request.getParameter("statusId")!=null?Integer.valueOf(request.getParameter("statusId")):-1;
	int categoryId = request.getParameter("categoryId")!=null?Integer.valueOf(request.getParameter("categoryId")):-1;
	int priorityId = request.getParameter("priorityId")!=null?Integer.valueOf(request.getParameter("priorityId")):-1;
%>
<span class="label"><a href="index.jsp?<%="session="+session.getId()+"&categoryId="+categoryId+"&statusId="+statusId+"&priorityId=-1"%>">Все</a></span>
<span class="label bg-yellow"><a href="index.jsp?<%="session="+session.getId()+"&categoryId="+categoryId+"&statusId="+statusId+"&priorityId="+Priority.priority(Priority.IMPOTANT_FAST)%>"><%=Priority.IMPOTANT_FAST%></a></span>
<span class="label bg-blue"><a href="index.jsp?<%="session="+session.getId()+"&categoryId="+categoryId+"&statusId="+statusId+"&priorityId="+Priority.priority(Priority.IMPOTANT_NOFAST)%>"><%=Priority.IMPOTANT_NOFAST%></a></span>
<span class="label"><a href="index.jsp?<%="session="+session.getId()+"&categoryId="+categoryId+"&statusId="+statusId+"&priorityId="+Priority.priority(Priority.SIMPLE)%>"><%=Priority.SIMPLE%></a></span>