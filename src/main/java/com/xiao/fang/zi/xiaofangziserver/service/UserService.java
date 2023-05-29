package com.xiao.fang.zi.xiaofangziserver.service;


import  com.xiao.fang.zi.xiaofangziserver.entity.User;
import  com.xiao.fang.zi.xiaofangziserver.entity.queryDto.UserDto;
import  com.xiao.fang.zi.xiaofangziserver.entity.responseDto.UserResponseDto;
import com.xiao.fang.zi.xiaofangziserver.model.PageModel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaofangzi
 * @since 2023-05-29
 */
@Service
public interface UserService extends IService<User> {

  IPage<UserResponseDto> pageQuery(PageModel<UserDto> pm);

  Boolean saveUser(UserDto userDto);

  Boolean updateUser(UserDto userDto);

  Boolean deleteById(String id);

  UserResponseDto queryById(String id);

}
