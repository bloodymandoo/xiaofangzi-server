package com.xiao.fang.zi.xiaofangziserver.mapper;

import com.xiao.fang.zi.xiaofangziserver.entity.User;
import com.xiao.fang.zi.xiaofangziserver.entity.responseDto.UserResponseDto;
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
public interface UserMapper extends BaseMapper<User> {

    @Select("select t1.* from user t1 " +
    "       ${ew.customSqlSegment}")
    Page<UserResponseDto> pageQuery(@Param(Constants.WRAPPER) QueryWrapper<User> wrapper, Page page);

    @Select("select t1.* from user t1 " +
    "       where t1.id=#{id}")
    UserResponseDto queryById(@Param("id") String id);
}
