<%@ page import="ru.rrozhkov.easykin.context.*"%>
<%@ page import="ru.rrozhkov.lib.util.*"%>
<%@ page import="ru.rrozhkov.easykin.model.category.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
	String username = request.getParameter("username")!=null?String.valueOf(request.getParameter("username")):"";
%>
<div class="box box-info">
  <div class="box-header with-border">
    <h3 class="box-title">Authorization</h3>
  </div>
  <!-- /.box-header -->
  <!-- form start -->
  <form class="form-horizontal" method="POST" action="index.jsp">
    <div class="box-body">
      <div class="form-group">
        <label for="Username" class="col-sm-2 control-label">Username</label>
        <div class="col-sm-10">
          <input type="text" name="username" value="<%=username%>" class="form-control" id="Username" placeholder="Username">
        </div>
      </div>
      <div class="form-group">
        <label for="Password" class="col-sm-2 control-label">Password</label>
        <div class="col-sm-10">
          <input type="password" name="password" value="" class="form-control" id="Password" placeholder="Password">
        </div>
      </div>
    </div>
    <!-- /.box-body -->
    <div class="box-footer">
      <button type="submit" class="btn btn-info pull-right">Sign in</button>
    </div>
    <!-- /.box-footer -->
  </form>
</div>