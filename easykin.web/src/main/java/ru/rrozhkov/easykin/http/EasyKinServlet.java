package ru.rrozhkov.easykin.http;

import ru.rrozhkov.easykin.AdapterFactory;
import ru.rrozhkov.easykin.finance.FinanceAdapter;
import ru.rrozhkov.easykin.jira.JiraTaskAdapter;
import ru.rrozhkov.easykin.module.Module;
import ru.rrozhkov.easykin.payment.PaymentAdapter;
import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.easykin.service.ServiceAdapter;
import ru.rrozhkov.easykin.task.TaskAdapter;
import ru.rrozhkov.easykin.work.WorkAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by rrozhkov on 29.06.2018.
 */
public class EasyKinServlet extends HttpServlet {
    private final AuthManager authManager = AuthManager.instance();
    private final AdapterFactory adapterFactory = new AdapterFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String signout = req.getParameter("signout")!=null?String.valueOf(req.getParameter("signout")):"";
        if (!signout.isEmpty()) {
            authManager.signOut();
        }
        if (!authManager.isSignedIn()) {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            fillData(req);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username")!=null?String.valueOf(req.getParameter("username")):"";
        String password = req.getParameter("password")!=null?String.valueOf(req.getParameter("password")):"";
        if (!username.isEmpty() && !password.isEmpty()) {
            authManager.signIn(username, password);
        }
        if (!authManager.isSignedIn()) {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            fillData(req);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    private void fillData(HttpServletRequest req) {
        Date start = new Date();
        String module = req.getParameter("moduleId");
        if (module==null) {
            final FinanceAdapter financeAdapter = adapterFactory.finance();
            req.setAttribute("finance", financeAdapter.finance());
            System.out.println(new Date().getTime() - start.getTime());
            start = new Date();
            final WorkAdapter workAdapter = adapterFactory.work();
            req.setAttribute("activities", workAdapter.activities());
            req.setAttribute("shortActivities", workAdapter.shortActivities());
            System.out.println(new Date().getTime() - start.getTime());
            start = new Date();
            final TaskAdapter taskAdapter = adapterFactory.task();
            req.setAttribute("tasks", taskAdapter.toDoTasks());
            req.setAttribute("toDoTasks", taskAdapter.toDoTasks());
            System.out.println(new Date().getTime() - start.getTime());
            start = new Date();
            final ServiceAdapter serviceAdapter = adapterFactory.service();
            req.setAttribute("services", serviceAdapter.services());
            System.out.println(new Date().getTime() - start.getTime());
            start = new Date();
            final PaymentAdapter paymentAdapter = adapterFactory.payment();
            req.setAttribute("payments", paymentAdapter.payments());
            System.out.println(new Date().getTime() - start.getTime());
            return;
        }
        if (Module.FIN.equals(module)) {
            final FinanceAdapter financeAdapter = adapterFactory.finance();
            req.setAttribute("finance", financeAdapter.finance());
        }
        System.out.println(new Date().getTime() - start.getTime());
        if (Module.WORK.equals(module)) {
            final WorkAdapter workAdapter = adapterFactory.work();
            req.setAttribute("activities", workAdapter.activities());
            req.setAttribute("shortActivities", workAdapter.shortActivities());
            req.setAttribute("groupActivities", workAdapter.groupActivities());
        }
        System.out.println(new Date().getTime() - start.getTime());
        if (Module.TASK.equals(module) || Module.FAMILY.equals(module)) {
            final TaskAdapter taskAdapter = adapterFactory.task();
            req.setAttribute("tasks", taskAdapter.tasks(req));
            req.setAttribute("toDoTasks", taskAdapter.toDoTasks());
        }
        System.out.println(new Date().getTime() - start.getTime());
        if (Module.SERVICE.equals(module)) {
            final ServiceAdapter serviceAdapter = adapterFactory.service();
            req.setAttribute("services", serviceAdapter.services());
        }
        System.out.println(new Date().getTime() - start.getTime());
        if (Module.PAYMENT.equals(module)) {
            final PaymentAdapter paymentAdapter = adapterFactory.payment();
            req.setAttribute("payments", paymentAdapter.payments());
        }
        System.out.println(new Date().getTime() - start.getTime());
        if (Module.JIRA.equals(module)) {
            final JiraTaskAdapter jiraTaskAdapter = adapterFactory.jiraTask();
            req.setAttribute("jiratasks", jiraTaskAdapter.tasks());
        }
        System.out.println(new Date().getTime() - start.getTime());
    }

}
