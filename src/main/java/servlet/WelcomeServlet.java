/*
 * Copyright (c) 2013 Qunar.com. All Rights Reserved.
 */
package servlet;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.UserUtils;

/**
 * @author rongqian.xu created on 7/8/14 7:46 PM
 * @version $Id$
 */
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = UserUtils.getUserName(req);
        //resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        resp.getWriter().print("你好: " + userName);
    }
}
