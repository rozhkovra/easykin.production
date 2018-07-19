<%@ page import="java.util.*"%>
<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.core.filter.util.*"%>
<%@ page import="ru.rrozhkov.easykin.finance.*"%>
<%@ page import="ru.rrozhkov.easykin.fin.payment.impl.filter.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.payment.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.util.*"%>
<%@ page import="ru.rrozhkov.easykin.core.filter.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
    Collection<FinanceBean> finances = (Collection<FinanceBean>)request.getAttribute("finance");
    Date start = DateUtil.firstDayOfMonth();
    Date end = DateUtil.lastDayOfMonth();
    Money noPaid = new Money();
    IFilter<IPayment> filter = PaymentFilterFactory.instance().betweenDate(start, end);

    for (FinanceBean finance : finances) {
        if(filter.filter(finance.getPayment())) {
            noPaid.add(finance.getPayment().getAmount());
        }
    }
    if (!noPaid.free()) {
        String color = "warning";
        if (noPaid.getValue() > 21700.00) {
            color = "danger";
        }
        if (noPaid.getValue() < 1000.00) {
            color = "success";
        }
%>
<div class="alert alert-<%=color%> alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-money"></i> Сообщение!</h4>
    К оплате: <b><%=noPaid%></b> руб.
</div>
<%
    }
%>