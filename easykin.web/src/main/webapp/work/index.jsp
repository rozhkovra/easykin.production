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
</table>
</div>
</div>
</div>
</div>
</section>

<!-- page script -->
<script>
  $(function () {
    $('#activities').DataTable()
  })
</script>