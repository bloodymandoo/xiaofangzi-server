package com.xiao.fang.zi.xiaofangziserver.mapper;

import com.xiao.fang.zi.xiaofangziserver.entity.Article;
import com.xiao.fang.zi.xiaofangziserver.entity.responseDto.ArticleResponseDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiaofangzi
 * @since 2023-05-29
 */

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    @Select("select t1.* from article t1 " +
    "       ${ew.customSqlSegment}")
    Page<ArticleResponseDto> pageQuery(@Param(Constants.WRAPPER) QueryWrapper<Article> wrapper, Page page);

    @Select("select t1.* from article t1 " +
    "       where t1.id=#{id}")
    ArticleResponseDto queryById(@Param("id") String id);
}
