package ${package.Controller};

import  ${package.Entity}.${entity};
import  ${package.Entity}.queryDto.${entity}Dto;
import  ${package.Entity}.responseDto.${entity}ResponseDto;
import ${package.Service}.${table.serviceName};
import com.xiao.fang.zi.xiaofangziserver.model.PageModel;
import com.xiao.fang.zi.xiaofangziserver.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.xiao.fang.zi.xiaofangziserver.util.CommonResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Slf4j
@Api(value = "${table.comment!}接口",tags = "${table.comment!}接口")
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Autowired
    private ${table.serviceName} ${table.serviceName?uncap_first};

    @ApiOperation(value = "${table.comment}条件分页查询接口")
    @PostMapping(value = "/page")
    public CommonResult<IPage<${entity}ResponseDto>> queryByCondition( @RequestBody PageModel<${entity}Dto> pm){
        IPage<${entity}ResponseDto> pageRs = ${table.serviceName?uncap_first}.pageQuery(pm);
        return CommonResult.success(pageRs);
    }

    @ApiOperation(value = "新增${table.comment}", notes = "新增${table.comment}")
    @PostMapping("/save")
    public CommonResult<Boolean> save( @RequestBody ${entity}Dto ${entity?uncap_first}Dto){
        return CommonResult.success(${table.serviceName?uncap_first}.save${entity}(${entity?uncap_first}Dto));
    }

    @ApiOperation(value = "修改${table.comment}", notes = "修改${table.comment}")
    @PutMapping("/update")
    public CommonResult<Boolean> update(@RequestBody ${entity}Dto ${entity?uncap_first}Dto) {
        return CommonResult.success(${table.serviceName?uncap_first}.update${entity}(${entity?uncap_first}Dto));
    }

    @ApiOperation(value = "根据id删除${table.comment}", notes = "根据id删除${table.comment}")
    @DeleteMapping("/{id}")
    public CommonResult<Boolean> delete(@PathVariable String id) {
        return CommonResult.success(${table.serviceName?uncap_first}.deleteById(id));
    }

    @ApiOperation(value = "根据id获取${table.comment}", notes = "根据id获取${table.comment}")
    @GetMapping("/{id}")
    public CommonResult<${entity}ResponseDto> queryById(@PathVariable String id) {
        return CommonResult.success(${table.serviceName?uncap_first}.queryById(id));
    }
}
</#if>
