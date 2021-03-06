package ru.rrozhkov.easykin.http;

import ru.rrozhkov.easykin.AdapterFactory;
import ru.rrozhkov.easykin.finance.FinanceAdapter;
import ru.rrozhkov.easykin.jira.JiraAdapter;
import ru.rrozhkov.easykin.module.Module;
import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.easykin.module.SubModule;
import ru.rrozhkov.easykin.payment.PaymentAdapter;
import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.easykin.service.ServiceAdapter;
import ru.rrozhkov.easykin.task.TaskAdapter;
import ru.rrozhkov.easykin.task.category.CategoryAdapter;
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
    ModuleManager moduleManager = ModuleManager.instance();

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
            fillDashboard(req, start);
            return;
        }
        if (!moduleManager.isActive(module)) {
            return;
        }
        String subModule = req.getParameter("subModuleId");
        if (SubModule.VIEW.equals(subModule)) {
            if (Module.TASK.equals(module) || Module.FAMILY.equals(module)) {
                final TaskAdapter taskAdapter = adapterFactory.task();
                req.setAttribute("taskBean", taskAdapter.task(req));
                req.setAttribute("paymentBean", taskAdapter.payment(req));
            }
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
            final CategoryAdapter categoryAdapter = adapterFactory.category();
            req.setAttribute("categories", categoryAdapter.categories());
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
            final JiraAdapter jiraAdapter = adapterFactory.jira();
            req.setAttribute("jiratasks", jiraAdapter.tasks());
            req.setAttribute("jiraworklog", jiraAdapter.worklogs());
        }
        System.out.println(new Date().getTime() - start.getTime());
    }

    private void fillDashboard(HttpServletRequest req, Date start) {
        if (moduleManager.isActive(Module.FIN)) {
            final FinanceAdapter financeAdapter = adapterFactory.finance();
            req.setAttribute("finance", financeAdapter.finance());
            System.out.println(new Date().getTime() - start.getTime());
            start = new Date();
        }
        if (moduleManager.isActive(Module.WORK)) {
            final WorkAdapter workAdapter = adapterFactory.work();
            req.setAttribute("activities", workAdapter.activities());
            req.setAttribute("shortActivities", workAdapter.shortActivities());
            System.out.println(new Date().getTime() - start.getTime());
            start = new Date();
        }
        if (moduleManager.isActive(Module.TASK)) {
            final TaskAdapter taskAdapter = adapterFactory.task();
            req.setAttribute("tasks", taskAdapter.toDoTasks());
            req.setAttribute("toDoTasks", taskAdapter.toDoTasks());
            final CategoryAdapter categoryAdapter = adapterFactory.category();
            req.setAttribute("categories", categoryAdapter.categories());
            System.out.println(new Date().getTime() - start.getTime());
            start = new Date();
        }
        if (moduleManager.isActive(Module.SERVICE)) {
            final ServiceAdapter serviceAdapter = adapterFactory.service();
            req.setAttribute("services", serviceAdapter.services());
            System.out.println(new Date().getTime() - start.getTime());
            start = new Date();
        }
        if (moduleManager.isActive(Module.PAYMENT)) {
            final PaymentAdapter paymentAdapter = adapterFactory.payment();
            req.setAttribute("payments", paymentAdapter.payments());
            System.out.println(new Date().getTime() - start.getTime());
            start = new Date();
        }
        if (moduleManager.isActive(Module.JIRA)) {
            final JiraAdapter jiraAdapter = adapterFactory.jira();
            req.setAttribute("jiratasks", jiraAdapter.tasks());
            System.out.println(new Date().getTime() - start.getTime());
            start = new Date();
            req.setAttribute("jiraworklog", jiraAdapter.worklogs());
            System.out.println(new Date().getTime() - start.getTime());
        }
    }

}
