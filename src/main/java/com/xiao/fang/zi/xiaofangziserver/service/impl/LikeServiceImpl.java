package com.xiao.fang.zi.xiaofangziserver.service.impl;

import  com.xiao.fang.zi.xiaofangziserver.entity.Like;
import  com.xiao.fang.zi.xiaofangziserver.entity.queryDto.LikeDto;
import  com.xiao.fang.zi.xiaofangziserver.entity.responseDto.LikeResponseDto;
import com.xiao.fang.zi.xiaofangziserver.mapper.LikeMapper;
import com.xiao.fang.zi.xiaofangziserver.service.LikeService;
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
public class LikeServiceImpl extends ServiceImpl<LikeMapper, Like> implements LikeService {

    @Autowired
    private LikeMapper likeMapper;

    @Override
    public IPage<LikeResponseDto> pageQuery(PageModel<LikeDto> pm) {
        LikeDto con = pm.getCondition();
        QueryWrapper<Like> wrapper = new QueryWrapper<>();
        if (con != null) {

        }
        Page<LikeResponseDto> page = new Page<>();
        page.setCurrent(pm.getCurrent());
        page.setSize(pm.getSize());
        IPage<LikeResponseDto> pageRs = likeMapper.pageQuery(wrapper, page);
        return pageRs;
    }

    @Transactional(rollbackFor = Exception.class)
    @SneakyThrows
    @Override
    public Boolean saveLike(LikeDto likeDto) {
        return this.save(likeDto);
    }

    @Override
    public Boolean updateLike(LikeDto likeDto) {
        return this.updateById(likeDto);
    }

    @Override
    public Boolean deleteById(String id) {
        UpdateWrapper wrapper = new UpdateWrapper();
        wrapper.eq("id", id);
        wrapper.set("status", -1);
        return this.update(wrapper);
    }

    @Override
    public LikeResponseDto queryById(String id) {
        LikeResponseDto likeResponseDto = likeMapper.queryById(id);
        return likeResponseDto;
    }

}
