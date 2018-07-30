package com.heaven.fly.core.config;

import com.heaven.fly.core.language.MyLocaleResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

/**
 * @Auther: heaven
 * @Date: 2018/7/30 16:56
 * @Description:
 */
@Configuration
public class I18nConfig {
    private static Logger logger = LoggerFactory.getLogger(I18nConfig.class);

    @Bean(name = "localeResolver")
    public MyLocaleResolver myLocaleResolver(){
        logger.info("#####cookieLocaleResolver---create");

        MyLocaleResolver myLocaleResolver = new MyLocaleResolver();
        myLocaleResolver.setDefaultLocale(Locale.ENGLISH);
        logger.info("#####cookieLocaleResolver:");
        return myLocaleResolver;
    }
}
