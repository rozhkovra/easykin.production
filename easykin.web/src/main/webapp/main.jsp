<%@ page import="ru.rrozhkov.lib.util.*"%>
<%@ page import="ru.rrozhkov.easykin.model.category.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="java.util.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
  <style type="text/css">
   .multiselect {
     width: 200px;
   }

   .selectBox {
     position: relative;
   }

   .selectBox select {
     width: 100%;
     font-weight: bold;
   }

   .overSelect {
     position: absolute;
     left: 0;
     right: 0;
     top: 0;
     bottom: 0;
   }

   #checkboxes {
     display: none;
     border: 1px #dadada solid;
   }

   #checkboxes label {
     display: block;
   }

   #checkboxes label:hover {
     background-color: #1e90ff;
   }
  </style>
  <script type="text/javascript">
      var expanded = false;

      function showCheckboxes() {
        var checkboxes = document.getElementById("checkboxes");
        if (!expanded) {
          checkboxes.style.display = "block";
          expanded = true;
        } else {
          checkboxes.style.display = "none";
          expanded = false;
        }
      }
  </script>
<table width="100%">
	<col width="200"/>
	<col width="200"/>
	<col/>
<tr>
<td valign="top">
<br/><br/>
<jsp:include page="module/modules.jsp"/>
</td>
<td colspan="2"  valign="top">
<%
	int categoryId = request.getParameter("categoryId")!=null?Integer.valueOf(request.getParameter("categoryId")):-1;
	String moduleId = request.getParameter("moduleId")!=null?String.valueOf(request.getParameter("moduleId")):"";
	if (Module.PAYMENT.equals(moduleId) || Module.FIN.equals(moduleId)){
%><jsp:include page="payment/payments.jsp"/><%
	}else if(Module.WORK.equals(moduleId)){
%><jsp:include page="work/work_group.jsp"/><jsp:include page="work/work.jsp"/><%
	}else{
%>
<jsp:include page="task/tasks.jsp"/>
<%}%>
</td>
</tr>
</table>