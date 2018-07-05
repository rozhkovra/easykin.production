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
    UrlConfigurator urlConfigurator = new UrlConfigurator();
    final AdapterFactory adapterFactory = new AdapterFactory();
    final FinanceAdapter financeAdapter = adapterFactory.finance();
    Collection<FinanceBean> finances = financeAdapter.finance();
    Date start = DateUtil.firstDayOfMonth();
    Date end = DateUtil.lastDayOfMonth();
    Money noPaid = new Money();
    IFilter<IPayment> filter = PaymentFilterFactory.instance().betweenDate(start, end);

    for (FinanceBean finance : finances) {
        if(filter.filter(finance.getPayment())) {
            noPaid.add(finance.getPayment().getAmount());
        }
    }
    String color = "green";
    if (!noPaid.free()) {
        color = "yellow";
        if(noPaid.getValue() > 21700.00) {
            color = "red";
        }
%>
<div class="col-lg-3 col-xs-6">
<!-- payment box -->
<div class="small-box bg-<%=color%>">
    <div class="inner">
        <h3><%=FormatUtil.formatMoney(noPaid)%></h3>

        <p>К оплате</p>
    </div>
    <div class="icon">
        <i class="fa fa-money"></i>
    </div>
    <a href="<%=urlConfigurator.getFilterUrlForModule(request, session, ru.rrozhkov.easykin.module.Module.FIN)%>"class="small-box-footer">Подробно <i class="fa fa-arrow-circle-right"></i></a>
</div>
</div>
<%
    }
%>