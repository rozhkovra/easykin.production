package ru.rrozhkov.easykin;

import ru.rrozhkov.easykin.finance.FinanceAdapter;
import ru.rrozhkov.easykin.jira.JiraAdapter;
import ru.rrozhkov.easykin.payment.PaymentAdapter;
import ru.rrozhkov.easykin.service.ServiceAdapter;
import ru.rrozhkov.easykin.task.TaskAdapter;
import ru.rrozhkov.easykin.task.category.CategoryAdapter;
import ru.rrozhkov.easykin.work.WorkAdapter;

/**
 * Created by rrozhkov on 04.06.2018.
 */
public class AdapterFactory {
    public TaskAdapter task() {
        return new TaskAdapter();
    }
    public WorkAdapter work() {
        return new WorkAdapter();
    }
    public ServiceAdapter service() {
        return new ServiceAdapter();
    }
    public PaymentAdapter payment() {
        return new PaymentAdapter();
    }
    public FinanceAdapter finance() {
        return new FinanceAdapter();
    }
    public JiraAdapter jira() {
        return new JiraAdapter();
    }
    public CategoryAdapter category() {
        return new CategoryAdapter();
    }
}
