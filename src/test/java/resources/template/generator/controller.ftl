package ${basePackageController};

import ${basePackage}.core.api.ApiResult;
import ${basePackage}.core.api.ApiResponse;
import ${basePackage}.core.utils.GlobalUtils;
import ${basePackageModel}.${modelNameUpperCamel};
import ${basePackageService}.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: ${modelNameUpperCamel}Controller类
* @author ${author}
* @date ${date}
*/
@RestController
@RequestMapping("/${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {

    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping("/insert")
    public ApiResult<Integer> insert(${modelNameUpperCamel} ${modelNameLowerCamel}) throws Exception{
        ${modelNameLowerCamel}.setId(GlobalUtils.getUUID());
        Integer state = ${modelNameLowerCamel}Service.insert(${modelNameLowerCamel});
        return ApiResponse.makeOKRsp(state);
    }


    @PostMapping("/deleteById")
    public ApiResult<Integer> deleteById(@RequestParam String id) throws Exception {
            Integer state = ${modelNameLowerCamel}Service.deleteById(id);
            return ApiResponse.makeOKRsp(state);
    }

    @PostMapping("/update")
    public ApiResult<Integer> update(${modelNameUpperCamel} ${modelNameLowerCamel}) throws Exception {
            Integer state = ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
            return ApiResponse.makeOKRsp(state);
    }

    @PostMapping("/selectById")
    public ApiResult<${modelNameUpperCamel}> selectById(@RequestParam String id) throws Exception {
            ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.selectById(id);
             return ApiResponse.makeOKRsp(${modelNameLowerCamel});
    }
    /**
    * @Description: 分页查询
    * @param page 页码
    * @param size 每页条数
    * @Reutrn ApiResult<PageInfo<${modelNameUpperCamel}>>
    */
    @PostMapping("/list")
    public ApiResult<PageInfo<${modelNameUpperCamel}>> list(@RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.selectAll();
        PageInfo<${modelNameUpperCamel}> pageInfo = new PageInfo<${modelNameUpperCamel}>(list);
        return ApiResponse.makeOKRsp(pageInfo);
    }
 }
