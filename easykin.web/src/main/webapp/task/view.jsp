<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.task.impl.*"%>
<%@ page import="ru.rrozhkov.easykin.model.task.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<section class="content">
<div class="row">
<div class="col-xs-12">
<div class="box">
<div class="box-header">
</div>
<div class="box-body">
<%
    int taskId = request.getParameter("taskId")!=null?Integer.valueOf(request.getParameter("taskId")):-1;
    final TaskBuilder taskBuilder = TaskBuilder.instance();
    ITask task = taskBuilder.buildTask(taskId);
    if (task != null) {
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
    }
%>
</div>
</div>
</div>
</div>
</section>