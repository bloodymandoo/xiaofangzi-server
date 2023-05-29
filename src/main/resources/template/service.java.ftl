package ${package.Service};


import  ${package.Entity}.${entity};
import  ${package.Entity}.queryDto.${entity}Dto;
import  ${package.Entity}.responseDto.${entity}ResponseDto;
import com.xiao.fang.zi.xiaofangziserver.model.PageModel;
import ${superServiceClassPackage};
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

  IPage<${entity}ResponseDto> pageQuery(PageModel<${entity}Dto> pm);

  Boolean save${entity}(${entity}Dto ${entity?uncap_first}Dto);

  Boolean update${entity}(${entity}Dto ${entity?uncap_first}Dto);

  Boolean deleteById(String id);

  ${entity}ResponseDto queryById(String id);

}
</#if>
