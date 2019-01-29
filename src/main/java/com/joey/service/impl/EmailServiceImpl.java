package com.joey.service.impl;

import com.joey.config.EmailConfig;
import com.joey.service.EmailService;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈邮箱service接口〉
 *
 * @author Joey
 * @create 2019-01-11
 * @since 1.0.0
 */

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailConfig emailConfig;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Override
    public void sendSimpleMail(String sendTo, String title, String content) {
        //简单邮件发送
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailConfig.getEmailFrom());
        message.setTo(sendTo);
        message.setSubject(title);
        message.setText(content);
        System.out.println(message.toString());
        mailSender.send(message);
    }

    @Override
    public void sendAttachMail(String sendTo, String title, String content, File file) {
        MimeMessage message = mailSender.createMimeMessage();
        try{
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
            messageHelper.setFrom(emailConfig.getEmailFrom());
            messageHelper.setTo(sendTo);
            messageHelper.setSubject(title);
            messageHelper.setText(content);
            //添加附件
            FileSystemResource resource = new FileSystemResource(file);
            messageHelper.addAttachment("附件",resource);

        }catch (Exception e){
            e.printStackTrace();
        }

        mailSender.send(message);
    }

    @Override
    public void sendTemplateMail(String sendTo, String title, String info) {
        MimeMessage message = mailSender.createMimeMessage();
        try{
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
            messageHelper.setFrom(emailConfig.getEmailFrom());
            messageHelper.setTo(sendTo);
            messageHelper.setSubject(title);

            //封装模板使用数据
            Map<String,Object> map= new HashMap<>();
            map.put("username","joey");

            //得到模板
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate(info);
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
            messageHelper.setText(html,true);
        }catch (Exception e){
            e.printStackTrace();
        }

        mailSender.send(message);
    }
}
