package com.heaven.fly.controller;

import com.heaven.fly.core.api.ApiResponse;
import com.heaven.fly.core.api.ApiResult;
import com.heaven.fly.core.constant.ExcelConstant;
import com.heaven.fly.core.utils.ExcelUtils;
import com.heaven.fly.model.ExcelData;
import com.heaven.fly.model.UserInfo;
import com.heaven.fly.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("excel")
public class ExcelController {

    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/test")
    public ApiResult<Integer> test(){
        int rowIndex = 0;
        List<UserInfo> list = userInfoService.selectAlla(0, 0);
        ExcelData data = new ExcelData();
        data.setName("hello");
        List<String> titles = new ArrayList();
        titles.add("ID");
        titles.add("userName");
        titles.add("password");
        data.setTitles(titles);

        data.setRows(addRows(list));
        try{
            rowIndex = ExcelUtils.generateExcel(data, ExcelConstant.FILE_PATH + ExcelConstant.FILE_NAME);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ApiResponse.makeOKRsp(Integer.valueOf(rowIndex));
    }

    @GetMapping("/test2")
    public void test2(HttpServletResponse response){
        int rowIndex = 0;
        List<UserInfo> list = userInfoService.selectAlla(0, 0);
        ExcelData data = new ExcelData();
        data.setName("hello");
        List<String> titles = new ArrayList();
        titles.add("ID");
        titles.add("userName");
        titles.add("password");
        data.setTitles(titles);

        data.setRows(addRows(list));
        try{
            ExcelUtils.exportExcel(response,"test2",data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private List<List<Object>> addRows(List<UserInfo> list) {
        List<List<Object>> rows = new ArrayList();
        if(list != null) {
            for(int i = 0, length = list.size();i<length;i++){
                UserInfo userInfo = list.get(i);
                List<Object> row = new ArrayList();
                row.add(userInfo.getId());
                row.add(userInfo.getUserName());
                row.add(userInfo.getPassword());
                rows.add(row);
            }
        }
        return rows;
    }

}
