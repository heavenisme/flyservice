package com.heaven.fly.controller;

import com.heaven.fly.core.api.ApiResponse;
import com.heaven.fly.core.api.ApiResult;
import com.heaven.fly.core.constant.MailConstant;
import com.heaven.fly.core.utils.GlobalUtils;
import com.heaven.fly.model.Mail;
import com.heaven.fly.service.MailService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: heaven
 * @Date: 2018/7/4 09:45
 * @Description:
 */
@RestController
@RequestMapping("/mail")
@Api(tags = {"邮件发送"}, description = "MailController")
public class MailController {
    @Resource
    private MailService mailService;

    /**
     * 发送注册验证码
     * @param mail
     * @return 验证码
     * @throws Exception
     */
    @PostMapping("/sendTemplateMail")
    public ApiResult<String> sendTemplateMail(Mail mail) throws Exception {
        mail.setTo(new String[]{"heavenisme@aliyun.com"});
        String identifyingCode = GlobalUtils.getNumStringRandom(6);
        mail.setSubject("欢迎注册初晨");
        mail.setTemplateName(MailConstant.RETGISTEREMPLATE);
        Map<String,String> map = new HashMap<>();
        map.put("identifyingCode",identifyingCode);
        map.put("to",mail.getTo()[0]);
        mail.setTemplateModel(map);
        mailService.sendTemplateMail(mail);

        return ApiResponse.makeOKRsp(identifyingCode);
    }

    @PostMapping("/sendAttachmentsMail")
    public ApiResult<String> sendAttachmentsMail(Mail mail,HttpServletRequest request) throws Exception {
        mail.setSubject("测试附件");
        mailService.sendAttachmentsMail(mail, request);
        return ApiResponse.makeOKRsp();
    }
}
