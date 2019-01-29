package com.joey.service;

import org.springframework.stereotype.Service;

import java.io.File;

/**
 * 〈邮件发送service〉
 *
 * @author Joey
 * @create 2019-01-11
 * @since 1.0.0
 */

public interface EmailService {


    /**
     * 发送简单邮件
     * @param sendTo
     * @param title
     * @param content
     */
    void sendSimpleMail(String sendTo,String title,String content);

    /**
     * 发送带附件的邮件
     * @param sendTo
     * @param title
     * @param content
     */
    void sendAttachMail(String sendTo, String title, String content, File file);

    /**
     * 发送模板邮件
     * @param sendTo
     * @param title
     * @param info
     */
    void sendTemplateMail(String sendTo, String title,String info);

}
