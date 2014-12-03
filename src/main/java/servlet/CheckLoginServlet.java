package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class CheckLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        resp.setCharacterEncoding("utf8");
        resp.setHeader("Content-Type","text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        if(StringUtils.isEmpty(userName)){
            writer.println("用户名为空");
            return;
        }
        if(StringUtils.isEmpty(password)){
            writer.println("密码为空");
            return;
        }

        if("admin".equals(userName) && "admin".equals(password)){
            Cookie cookie = new Cookie("admin","admin");
            resp.addCookie(cookie);
            resp.sendRedirect("/welcome");
        }else{
            Cookie cookie = new Cookie(userName,password);
            resp.addCookie(cookie);
            resp.sendRedirect("/welcome");
        }
    }
}
