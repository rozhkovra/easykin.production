<%@ page import="java.util.*"%>
<%@ page import="ru.rrozhkov.easykin.core.util.*"%>
<%@ page import="ru.rrozhkov.easykin.core.filter.util.*"%>
<%@ page import="ru.rrozhkov.easykin.payment.*"%>
<%@ page import="ru.rrozhkov.easykin.fin.payment.impl.filter.*"%>
<%@ page import="ru.rrozhkov.easykin.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.payment.*"%>
<%@ page import="ru.rrozhkov.easykin.model.fin.util.*"%>
<%@ page import="ru.rrozhkov.easykin.module.*"%>
<%@ page import="ru.rrozhkov.easykin.core.filter.*"%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%
    ModuleManager moduleManager = ModuleManager.instance();
    if (!moduleManager.isActive(ru.rrozhkov.easykin.module.Module.PAYMENT)) {
        return;
    }

    UrlConfigurator urlConfigurator = new UrlConfigurator();
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
    String color = "red";
    if (!paid.free()) {
        color = "yellow";
        if(paid.getValue() > 21700.00) {
            color = "green";
        }
    }
%>
<div class="col-lg-3 col-xs-6">
<!-- payment box -->
<div class="small-box bg-<%=color%>">
    <div class="inner">
        <h3><%=FormatUtil.formatMoney(paid)%> <i class="fa fa-rub"></i></h3>

        <p>Оплачено</p>
    </div>
    <div class="icon">
        <i class="fa fa-money"></i>
    </div>
    <a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.PAYMENT)%>"class="small-box-footer">Подробно <i class="fa fa-arrow-circle-right"></i></a>
</div>
</div>