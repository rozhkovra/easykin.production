<%@ page import="java.util.*"%>
<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.core.filter.util.*"%>
<%@ page import="ru.rrozhkov.easykin.payment.*"%>
<%@ page import="ru.rrozhkov.easykin.fin.payment.impl.filter.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.payment.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.util.*"%>
<%@ page import="ru.rrozhkov.easykin.core.filter.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
    Collection<PaymentBean> payments = (Collection<PaymentBean>)request.getAttribute("payments");
    Date start = DateUtil.firstDayOfMonth();
    Date end = DateUtil.lastDayOfMonth();
    Money paid = new Money();
    IFilter<IPayment> filter = PaymentFilterFactory.instance().betweenDate(start, end);

    for (PaymentBean payment : payments) {
        if(filter.filter(payment.getPayment())) {
            paid.add(payment.getPayment().getAmount());
        }
    }

    if (!paid.free()) {
        String color = "danger";
        if (!paid.free()) {
            color = "warning";
            if(paid.getValue() > 21700.00) {
                color = "success";
            }
        }
%>
<div class="alert alert-<%=color%> alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-money"></i> Сообщение!</h4>
    Оплачено: <b><%=paid%></b> руб.
</div>
<%
    }
%>