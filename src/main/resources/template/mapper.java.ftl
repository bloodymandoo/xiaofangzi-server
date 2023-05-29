package ${package.Mapper};

import ${package.Entity}.${entity};
import ${package.Entity}.responseDto.${entity}ResponseDto;
import ${superMapperClassPackage};
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * ${table.comment!} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */

@Mapper
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

    @Select("select t1.* from ${table.name} t1 " +
    "       ${r"${ew.customSqlSegment}"}")
    Page<${entity}ResponseDto> pageQuery(@Param(Constants.WRAPPER) QueryWrapper<${entity}> wrapper, Page page);

    @Select("select t1.* from ${table.name} t1 " +
    "       where t1.org_id=${r"#{id}"}")
    ${entity}ResponseDto queryById(@Param("id") String id);
}
</#if>
