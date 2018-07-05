package ru.rrozhkov.easykin.http;

import ru.rrozhkov.easykin.person.auth.AuthManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.TimeZone;

/**
 * Created by rrozhkov on 29.06.2018.
 */
public class EasyKinServlet extends HttpServlet {
    private final AuthManager authManager = AuthManager.instance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String signout = req.getParameter("signout")!=null?String.valueOf(req.getParameter("signout")):"";
        if (!signout.isEmpty()) {
            authManager.signOut();
        }
        if (!authManager.isSignedIn()) {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
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
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
