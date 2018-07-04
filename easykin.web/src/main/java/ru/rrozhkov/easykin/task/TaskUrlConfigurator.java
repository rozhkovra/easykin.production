package ru.rrozhkov.easykin.task;

import ru.rrozhkov.easykin.UrlConfigurator;
import ru.rrozhkov.easykin.module.SubModule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by rrozhkov on 29.06.2018.
 */
public class TaskUrlConfigurator extends UrlConfigurator {
    public String getTaskViewUrl(HttpServletRequest request, HttpSession session, TaskBean bean) {
        return new StringBuilder(getBaseUrl(request,session))
                .append("?session=").append(session.getId())
                .append("&moduleId=").append(ru.rrozhkov.easykin.module.Module.TASK)
                .append("&subModuleId=").append(SubModule.VIEW)
                .append("&taskId=").append(bean.getTask().getId())
                .toString();
    }
}
