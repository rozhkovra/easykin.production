package ru.rrozhkov.easykin.module;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by rrozhkov on 02.07.2018.
 */
public class WebModuleManager {
    private static final ModuleManager moduleManager = ModuleManager.instance();
    private HttpServletRequest request;

    public WebModuleManager(HttpServletRequest request) {
        this.request = request;
    }

    public String module() {
        return request.getParameter("moduleId")!=null?String.valueOf(request.getParameter("moduleId")):"";
    }

    public String subModule() {
        return request.getParameter("subModuleId")!=null
                && !"null".equals(String.valueOf(request.getParameter("subModuleId")))
                ?String.valueOf(request.getParameter("subModuleId")):"index";
    }

    public String moduleName() {
        return module().isEmpty()?"":Module.name(module());
    }

    public String alertUrl() {
        String module = module();
        if (moduleManager.isActive(module)) {
            if (Module.WORK.equals(module)) {
                module = module+"/mvideo";
            }
            if (Module.FAMILY.equals(module)) {
                module = Module.TASK;
            }
            if (Module.JIRA.equals(module)) {
                module = Module.JIRA+"/"+subModule();
            }

            return new StringBuilder(module).append("/alert.jsp").toString();
        }
        return "alert.jsp";
    }

    public String url() {
        String module = module();
        if (moduleManager.isActive(module)) {
            if (Module.WORK.equals(module)) {
                module = module+"/mvideo";
            }
            if (Module.FAMILY.equals(module)) {
                module = Module.TASK;
            }
            return new StringBuilder(module).append("/").append(subModule()).append(".jsp").toString();
        }
        return "dashboard.jsp";
    }
}
