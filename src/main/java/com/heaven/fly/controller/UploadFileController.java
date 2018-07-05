package com.heaven.fly.controller;

import com.heaven.fly.core.api.ApiResponse;
import com.heaven.fly.core.api.ApiResult;
import com.heaven.fly.core.utils.UploadFileUtils;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: heaven
 * @Date: 2018/7/3 17:47
 * @Description:
 */
@RestController
@RequestMapping("/uploadFile")
@Api(tags = {"文件上传"}, description = "UploadFileController")
public class UploadFileController {
    @PostMapping("/upload")
    public ApiResult<List<String>> upload(HttpServletRequest httpServletRequest) throws Exception {
        List<String> list = UploadFileUtils.uploadFile(httpServletRequest);
        return ApiResponse.makeOKRsp(list);
    }

}
