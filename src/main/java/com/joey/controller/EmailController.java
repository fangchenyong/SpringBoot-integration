package com.joey.controller;

import com.joey.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

/**
 * 〈邮件Controller〉
 *
 * @author Joey
 * @create 2019-01-11
 * @since 1.0.0
 */
@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/simple")
    @ResponseBody
    public String sendSimpleEmail(){
        emailService.sendSimpleMail("511393136@qq.com","邮件发送测试标题","邮件发送测试内容 --by joey");
        return "Simple";
    }

    @RequestMapping("/attach")
    @ResponseBody
    public String sendAttachEmail() {
        File file = new File("src/main/resources/static/java.jpg");
        emailService.sendAttachMail("511393136@qq.com", "邮件发送测试标题", "邮件发送测试内容 --by joey", file);
        return "Attach";
    }

    @RequestMapping("/template")
    @ResponseBody
    public String sendTemplateEmail(){
        emailService.sendTemplateMail("511393136@qq.com", "邮件发送测试标题","info.html");
        return "Template";
    }
}
