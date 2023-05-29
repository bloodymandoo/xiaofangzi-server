package com.xiao.fang.zi.xiaofangziserver.service.impl;

import  com.xiao.fang.zi.xiaofangziserver.entity.User;
import  com.xiao.fang.zi.xiaofangziserver.entity.queryDto.UserDto;
import  com.xiao.fang.zi.xiaofangziserver.entity.responseDto.UserResponseDto;
import com.xiao.fang.zi.xiaofangziserver.mapper.UserMapper;
import com.xiao.fang.zi.xiaofangziserver.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiao.fang.zi.xiaofangziserver.model.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import lombok.SneakyThrows;

/**
* <p>
    *  服务实现类
    * </p>
*
* @author xiaofangzi
* @since 2023-05-29
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<UserResponseDto> pageQuery(PageModel<UserDto> pm) {
        UserDto con = pm.getCondition();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (con != null) {

        }
        Page<UserResponseDto> page = new Page<>();
        page.setCurrent(pm.getCurrent());
        page.setSize(pm.getSize());
        IPage<UserResponseDto> pageRs = userMapper.pageQuery(wrapper, page);
        return pageRs;
    }

    @Transactional(rollbackFor = Exception.class)
    @SneakyThrows
    @Override
    public Boolean saveUser(UserDto userDto) {
        return this.save(userDto);
    }

    @Override
    public Boolean updateUser(UserDto userDto) {
        return this.updateById(userDto);
    }

    @Override
    public Boolean deleteById(String id) {
        UpdateWrapper wrapper = new UpdateWrapper();
        wrapper.eq("id", id);
        wrapper.set("status", -1);
        return this.update(wrapper);
    }

    @Override
    public UserResponseDto queryById(String id) {
        UserResponseDto userResponseDto = userMapper.queryById(id);
        return userResponseDto;
    }

}
