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

    public static String getFilterUrl(HttpServletRequest request, HttpSession session) {
        TaskFilterBean filterBean = taskAdapter.filter(request);
        return getFilterUrl(session.getId(), filterBean);
    }

    public static String getFilterUrlForModule(HttpServletRequest request, HttpSession session, String moduleId) {
        TaskFilterBean filterBean = taskAdapter.filter(request);
        filterBean.setModuleId(moduleId);
        return getFilterUrl(session.getId(), filterBean);
    }

    public static String getFilterUrlForModule(HttpServletRequest request, HttpSession session, String moduleId, String subModule) {
        TaskFilterBean filterBean = taskAdapter.filter(request);
        filterBean.setModuleId(moduleId);
        filterBean.setSubModuleId(subModule);
        return getFilterUrl(session.getId(), filterBean);
    }

    public static String getFilterUrlForCategory(HttpServletRequest request, HttpSession session, int categoryId) {
        TaskFilterBean filterBean = taskAdapter.filter(request);
        filterBean.setCategoryId(categoryId);
        return getFilterUrl(session.getId(), filterBean);
    }

    public static String getFilterUrlForStatus(HttpServletRequest request, HttpSession session, int statusId) {
        TaskFilterBean filterBean = taskAdapter.filter(request);
        filterBean.setStatusId(statusId);
        return getFilterUrl(session.getId(), filterBean);
    }

    public static String getFilterUrlForPriority(HttpServletRequest request, HttpSession session, int priorityId) {
        TaskFilterBean filterBean = taskAdapter.filter(request);
        filterBean.setPriority(priorityId);
        return getFilterUrl(session.getId(), filterBean);
    }

    public static String getFilterUrl(String sessionId, TaskFilterBean filterBean) {
        return new StringBuilder("index.jsp").append("?session=").append(sessionId)
                .append("&priorityId=").append(filterBean.getPriorityId())
                .append("&categoryId=").append(filterBean.getCategoryId())
                .append("&moduleId=").append(filterBean.getModuleId())
                .append("&subModuleId=").append(filterBean.getSubModuleId())
                .append("&statusId=").append(filterBean.getStatusId())
                .append("&fromDate=").append(DateUtil.format(filterBean.getFromDate()))
                .append("&toDate=").append(DateUtil.format(filterBean.getToDate())).toString();
    }

    public static String getCategoryClass(HttpServletRequest request, int curCategoryId) {
        int categoryId = request.getParameter("categoryId")!=null?Integer.valueOf(request.getParameter("categoryId")):-1;
        if (categoryId == curCategoryId)
            return "active";
        return "";
    }

    public static String getModuleClass(HttpServletRequest request, String curModuleId) {
        String moduleId = request.getParameter("moduleId")!=null?String.valueOf(request.getParameter("moduleId")):"";
        if (curModuleId.equals(moduleId))
            return "active";
        return "";
    }
}
