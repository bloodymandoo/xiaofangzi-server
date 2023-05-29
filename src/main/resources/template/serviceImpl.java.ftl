package ${package.ServiceImpl};

import  ${package.Entity}.${entity};
import  ${package.Entity}.queryDto.${entity}Dto;
import  ${package.Entity}.responseDto.${entity}ResponseDto;
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import com.xiao.fang.zi.xiaofangziserver.model.PageModel;
import com.xiao.fang.zi.xiaofangziserver.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import lombok.SneakyThrows;

/**
* <p>
    * ${table.comment!} 服务实现类
    * </p>
*
* @author ${author}
* @since ${date}
*/
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Autowired
    private ${table.mapperName} ${table.mapperName?uncap_first};

    @Override
    public IPage<${entity}ResponseDto> pageQuery(PageModel<${entity}Dto> pm) {
        ${entity}Dto con = pm.getCondition();
        boolean empty = StringUtils.isEmptyWithFilterNull(con);
        QueryWrapper<${entity}> wrapper = new QueryWrapper<>();
        //wrapper.eq("t1.is_delete", 0);
        if (!empty) {
        //if (!StringUtils.isEmptyWithFilterNull(con.getOrgName())) {
        // wrapper.like("t1.org_name", con.getOrgName());
        //}
        }
        Page<${entity}ResponseDto> page = new Page<>();
        page.setCurrent(pm.getCurrent());
        page.setSize(pm.getSize());
        IPage<${entity}ResponseDto> pageRs = ${entity?uncap_first}Mapper.pageQuery(wrapper, page);
        return pageRs;
    }

    @Transactional(rollbackFor = Exception.class)
    @SneakyThrows
    @Override
    public Boolean save${entity}(${entity}Dto ${entity?uncap_first}Dto) {
        QueryWrapper<${entity}> wrapper = new QueryWrapper<>();
        //wrapper.eq("org_name", ${entity?uncap_first}Dto.getOrgName());
        //wrapper.eq("is_delete", 0);
        //List<${entity}> list = this.list(wrapper);
        //if (list != null && list.size() > 0) {
        // throw new ValidationException("登记号已存在，请修改");
        //}
        return this.save(${entity?uncap_first}Dto);
    }

    @Override
    public Boolean update${entity}(${entity}Dto ${entity?uncap_first}Dto) {
        return this.updateById(${entity?uncap_first}Dto);
    }

    @Override
    public Boolean deleteById(String id) {
        UpdateWrapper wrapper = new UpdateWrapper();
        wrapper.eq("org_id", id);
        wrapper.set("is_delete", 1);
        return this.update(wrapper);
    }

    @Override
    public ${entity}ResponseDto queryById(String id) {
        ${entity}ResponseDto ${entity?uncap_first}ResponseDto = ${entity?uncap_first}Mapper.queryById(id);
        return ${entity?uncap_first}ResponseDto;
    }

}
</#if>
