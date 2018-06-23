package ${basePackageServiceImpl};

import ${basePackageDao}.${modelNameUpperCamel}Mapper;
import ${basePackageModel}.${modelNameUpperCamel};
import ${basePackageService}.${modelNameUpperCamel}Service;
import ${basePackage}.core.common.AbsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @Description: ${modelNameUpperCamel}Service接口实现类
* @author ${author}
* @date ${date}
*/
@Service
public class ${modelNameUpperCamel}ServiceImpl extends AbsService<${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service {

    @Resource
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

}