<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.work.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<section class="content">
<div class="row">
<div class="col-xs-12">

<div class="box">
<div class="box-header">
<h3 class="box-title">Активности</h3>
</div>

<div class="box-body">
<table id="activities" class="table table-bordered table-hover">
<thead>
<tr>
<th>№</th>
<th>Дата</th>
<th>Часы</th>
<th>Тип задачи</th>
<th>ID задачи</th>
<th>Номер релиза</th>
<th>Комментарий</th>
</tr>
</thead>
<tbody>
<%
	final AdapterFactory adapterFactory = new AdapterFactory();
	final WorkAdapter workAdapter = adapterFactory.work();
	Collection<ActivityBean> activities = workAdapter.activities();
	for(ActivityBean bean : activities){
%>
<tr>
<td ><%=bean.getNum()%></td>
<td ><span class="<%=bean.getDateClass()%>"><%=DateUtil.format(bean.getActivity().getDate())%></span></td>
<td align="right"><%=bean.getActivity().getTime()%></td>
<td align="center;"><%=String.valueOf(bean.getActivity().getTaskType())%></td>
<td align="center;"><%=bean.getActivity().getName()%></td>
<td align="center;"><%=String.valueOf(bean.getActivity().getReleaseType())%></td>
<td align="center;"><%=bean.getActivity().getDesc()%></td>
</tr>
<%
	}
%>
</tbody>
</table>
</div>
</div>
</div>
</div>
</section>