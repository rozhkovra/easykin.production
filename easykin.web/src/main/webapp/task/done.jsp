<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.task.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
	final AdapterFactory adapterFactory = new AdapterFactory();
	final TaskAdapter taskAdapter = adapterFactory.task();
	taskAdapter.done(request);
%>
