<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.jira.*"%>
<%@ page import="ru.rrozhkov.easykin.model.jira.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
    UrlConfigurator urlConfigurator = new UrlConfigurator();
	Collection<JiraTaskBean> tasks = (Collection<JiraTaskBean>)request.getAttribute("jiratasks");
	String open = "";
    String hold = "";
	String analysis = "";
	String inDev = "";
	String rfcr = "";
	String rfb = "";

	for(JiraTaskBean taskBean : tasks){
	    JiraTask task = taskBean.getTask();
        if ("OPEN".equals(task.getStatus().toUpperCase())) {
            open+=" <a href='https://jira.mvideo.ru/jira/browse/"+task.getKey()+"'>"+task.getKey()+"</a>";
        }
        if ("ON HOLD".equals(task.getStatus().toUpperCase())) {
            hold+=" <a href='https://jira.mvideo.ru/jira/browse/"+task.getKey()+"'>"+task.getKey()+"</a>";
        }
        if ("IN ANALYSIS".equals(task.getStatus().toUpperCase())) {
            analysis+=" <a href='https://jira.mvideo.ru/jira/browse/"+task.getKey()+"'>"+task.getKey()+"</a>";
        }
        if ("IN DEVELOPMENT".equals(task.getStatus().toUpperCase())) {
            inDev+=" <a href='https://jira.mvideo.ru/jira/browse/"+task.getKey()+"'>"+task.getKey()+"</a>";
        }
        if ("READY FOR CODE REVIEW".equals(task.getStatus().toUpperCase())) {
            rfcr+=" <a href='https://jira.mvideo.ru/jira/browse/"+task.getKey()+"'>"+task.getKey()+"</a>";
        }
        if ("READY FOR BUILD".equals(task.getStatus().toUpperCase())) {
            rfb+=" <a href='https://jira.mvideo.ru/jira/browse/"+task.getKey()+"'>"+task.getKey()+"</a>";
        }
	}
%>
<div class="col-lg-3 col-xs-6">
  <!-- small box -->
  <div class="small-box ">
    <div class="inner">
      <h3>Jira</h3>
        <ul>
            <% if (!hold.isEmpty())%><li><b>HOLD:</b> <%=hold%></li>
            <% if (!open.isEmpty())%><li><b>OPEN:</b> <%=open%></li>
            <% if (!analysis.isEmpty())%><li><b>ANL:</b> <%=analysis%></li>
            <% if (!inDev.isEmpty())%><li><b>DEV:</b> <%=inDev%></li>
            <% if (!rfcr.isEmpty())%><li><b>RFCR:</b> <%=rfcr%></li>
            <% if (!rfb.isEmpty())%><li><b>RFB:</b> <%=rfb%></li>
        </ul>
    </div>
    <div class="icon">
      <i class="fa fa-tasks"></i>
    </div>
    <a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.JIRA)%>"class="small-box-footer">Подробно <i class="fa fa-arrow-circle-right"></i></a>
  </div>
</div>
