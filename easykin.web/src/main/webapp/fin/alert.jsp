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
    if (!noPaid.free()) {
%>
<div class="alert alert-warning alert-dismissible">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
    <h4><i class="icon fa fa-warning"></i> Сообщение!</h4>
    К оплате: <b><%=noPaid%></b> руб.
</div>
<%
    }
%>