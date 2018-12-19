<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.task.impl.*"%>
<%@ page import="ru.rrozhkov.easykin.task.service.impl.*"%>
<%@ page import="ru.rrozhkov.easykin.model.task.*"%>
<%@ page import="ru.rrozhkov.easykin.task.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
    TaskBean taskBean = (TaskBean)request.getAttribute("viewBean");
    ITask task = taskBean.getTask();
%>
Задача # <b><%=task.getId()%></b>
<br/>
<b>Имя</b>: <%=task.getName()%>
<br/>
<b>Дата</b>: <%=DateUtil.format(task.getPlanDate())%>
<br/>
<b>Приоритет</b>: <%=task.getPriority()%>
<br/>
<b>Категория</b>: <%=task.getCategory().getName()%>
<br/>
<b>Статус</b>: <%=task.getStatus()%>
<br/>
<b>Комментарии</b>:
<br/>
<%
    for (IComment comment : task.comments()) {
        %><%=comment.getText()%><br/><%
    }

    if (task.getStatus().isOpen()) {
%>
<br/>
<div style="width:100px">
<button id="<%=taskBean.getTaskCloseId()%>" type="button" class="btn btn-block btn-success">Выполнить</button>
</div>
<%
    }
%>
