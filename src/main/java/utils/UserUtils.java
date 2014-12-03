/*
 * Copyright (c) 2013 Qunar.com. All Rights Reserved.
 */
package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author rongqian.xu created on 7/8/14 7:47 PM
 * @version $Id$
 */
public class UserUtils {
    public static  String getUserName(HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();
        String userName = null;
        if(cookies != null){
            for(Cookie cookie: cookies){
                if("userName".equals(cookie.getName())){
                    userName = cookie.getValue();
                }
            }
        }
        return userName;
    }
}
