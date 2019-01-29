package com.joey.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 〈获取邮箱配置〉
 *
 * @author Joey
 * @create 2019-01-11
 * @since 1.0.0
 */
@Component
public class EmailConfig {

    @Value("${spring.mail.username}")
    private String emailFrom;

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }



}
