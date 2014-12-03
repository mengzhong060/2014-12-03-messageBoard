package filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import utils.UserUtils;

/**
 * Created by solosky on 7/7/2014.
 */
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String uri = httpServletRequest.getRequestURI();
        System.out.println("执行用户过滤器 uri=" + httpServletRequest.getRequestURI() + ", ip="
                + httpServletRequest.getRemoteAddr());

        // 白名单
        Set<String> whiteList = new HashSet<String>();
        whiteList.add("/checkLogin");
        whiteList.add("/login.html");
        whiteList.add("/welcome");
        whiteList.add("/welcomeAdmin");
        if (whiteList.contains(uri)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 获取用户userName
        String userName = UserUtils.getUserName(httpServletRequest);

        // 没有登录就跳转登录页面
        if (StringUtils.isEmpty(userName)) {
            httpServletResponse.sendRedirect("/login.html");
            return;
        }

        // 继续执行下一个过滤器
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
