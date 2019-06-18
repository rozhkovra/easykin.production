<%@ page import="ru.rrozhkov.easykin.task.category.*"%>
<%@ page import="ru.rrozhkov.easykin.model.category.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
	Collection<CategoryBean> categories = (Collection<CategoryBean>)request.getAttribute("categories");
%>
<form id="formTaskAdd">
Desc: <input id="taskName" name="taskName"/> Cat: <select class="form-control select2" style="width: 20%;" id="categoryId" name="categoryId">
<%
    for (CategoryBean bean : categories) {
%>
		<option value="<%=bean.getCategory().getId()%>"><%=bean.getCategory().getName()%></option>
<%
    }
%>
	</select>
<button id="taskAddForm" type="button" class="btn btn-success">Add</button>
</form>