package com.heaven.fly.core.language;

import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Auther: heaven
 * @Date: 2018/7/30 16:55
 * @Description:
 */
public class MyLocaleResolver extends AcceptHeaderLocaleResolver {
    private Locale myLocal;
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        return myLocal==null?request.getLocale():myLocal;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        myLocal = locale;
    }
}
