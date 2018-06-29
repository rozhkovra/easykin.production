package ru.rrozhkov.easykin;

import ru.rrozhkov.easykin.task.TaskAdapter;
import ru.rrozhkov.easykin.task.impl.filter.TaskFilterBean;
import ru.rrozhkov.easykin.core.util.DateUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by rrozhkov on 11.05.2018.
 */
public class UrlConfigurator {
    final private static AdapterFactory adapterFactory = new AdapterFactory();
    final private static TaskAdapter taskAdapter = adapterFactory.task();

    public String getBaseUrl(HttpServletRequest request, HttpSession session) {
        return request.getContextPath()+"/easykin";
    }

    public String getFilterUrl(HttpServletRequest request, HttpSession session) {
        TaskFilterBean filterBean = taskAdapter.filter(request);
        return getFilterUrl(request, session, filterBean);
    }

    public String getFilterUrlForModule(HttpServletRequest request, HttpSession session, String moduleId) {
        TaskFilterBean filterBean = taskAdapter.filter(request);
        filterBean.setModuleId(moduleId);
        return getFilterUrl(request, session, filterBean);
    }

    public String getFilterUrlForModule(HttpServletRequest request, HttpSession session, String moduleId, String subModule) {
        TaskFilterBean filterBean = taskAdapter.filter(request);
        filterBean.setModuleId(moduleId);
        filterBean.setSubModuleId(subModule);
        return getFilterUrl(request, session, filterBean);
    }

    public String getFilterUrlForCategory(HttpServletRequest request, HttpSession session, int categoryId) {
        TaskFilterBean filterBean = taskAdapter.filter(request);
        filterBean.setCategoryId(categoryId);
        return getFilterUrl(request, session, filterBean);
    }

    public String getFilterUrlForStatus(HttpServletRequest request, HttpSession session, int statusId) {
        TaskFilterBean filterBean = taskAdapter.filter(request);
        filterBean.setStatusId(statusId);
        return getFilterUrl(request, session, filterBean);
    }

    public String getFilterUrlForPriority(HttpServletRequest request, HttpSession session, int priorityId) {
        TaskFilterBean filterBean = taskAdapter.filter(request);
        filterBean.setPriority(priorityId);
        return getFilterUrl(request, session, filterBean);
    }

    public String getFilterUrl(HttpServletRequest request, HttpSession session, TaskFilterBean filterBean) {
        return new StringBuilder(getBaseUrl(request, session))
                .append("?session=").append(session.getId())
                .append("&priorityId=").append(filterBean.getPriorityId())
                .append("&categoryId=").append(filterBean.getCategoryId())
                .append("&moduleId=").append(filterBean.getModuleId())
                .append("&subModuleId=").append(filterBean.getSubModuleId())
                .append("&statusId=").append(filterBean.getStatusId())
                .append("&fromDate=").append(DateUtil.format(filterBean.getFromDate()))
                .append("&toDate=").append(DateUtil.format(filterBean.getToDate())).toString();
    }

    public String getCategoryClass(HttpServletRequest request, int curCategoryId) {
        int categoryId = request.getParameter("categoryId")!=null?Integer.valueOf(request.getParameter("categoryId")):-1;
        if (categoryId == curCategoryId)
            return "active";
        return "";
    }

    public String getModuleClass(HttpServletRequest request, String curModuleId) {
        String moduleId = request.getParameter("moduleId")!=null?String.valueOf(request.getParameter("moduleId")):"";
        if (curModuleId.equals(moduleId))
            return "active";
        return "";
    }
}
