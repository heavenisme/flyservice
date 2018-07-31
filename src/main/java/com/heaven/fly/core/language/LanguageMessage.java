package com.heaven.fly.core.language;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * @Auther: heaven
 * @Date: 2018/7/30 17:54
 * @Description:
 */
public class LanguageMessage {
    static Logger logger = LoggerFactory.getLogger(LanguageMessage.class);

//    @Autowired
//    private static MessageSource messageSource;

   static ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

    /**
     * 国际化
     *
     * @param result
     * @return
     */
    public static String getMessage(String result) {
        return getMessages(result,null);
    }

    /**
     * 国际化
     *
     * @param result
     * @return
     */
    public static String getMessage(String result, Object[] params) {
        return getMessages(messageSource,result,params);
    }


    /**
     * 国际化
     * 注：通过@Autowired private MessageSource messageSource无法获取
     *
     * @param result
     * @return
     */
    public static String getMessages(String result, Object[] params) {

        messageSource.setCacheSeconds(-1);
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        messageSource.setBasenames("/messages/messages");

        return getMessages(messageSource,result,params);
    }

    private static String getMessages(MessageSource messageSource,String result, Object[] params) {
        String message = "";
        try {
            Locale locale = LocaleContextHolder.getLocale();
            message = messageSource.getMessage(result, params, locale);
            logger.error(message);
        } catch (Exception e) {
            logger.error("parse message error! ", e);
        }
        return message;
    }
}
