package com.xiao.fang.zi.xiaofangziserver.service.impl;

import  com.xiao.fang.zi.xiaofangziserver.entity.Story;
import  com.xiao.fang.zi.xiaofangziserver.entity.queryDto.StoryDto;
import  com.xiao.fang.zi.xiaofangziserver.entity.responseDto.StoryResponseDto;
import com.xiao.fang.zi.xiaofangziserver.mapper.StoryMapper;
import com.xiao.fang.zi.xiaofangziserver.service.StoryService;
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
public class StoryServiceImpl extends ServiceImpl<StoryMapper, Story> implements StoryService {

    @Autowired
    private StoryMapper storyMapper;

    @Override
    public IPage<StoryResponseDto> pageQuery(PageModel<StoryDto> pm) {
        StoryDto con = pm.getCondition();
        QueryWrapper<Story> wrapper = new QueryWrapper<>();
        if (con != null) {

        }
        Page<StoryResponseDto> page = new Page<>();
        page.setCurrent(pm.getCurrent());
        page.setSize(pm.getSize());
        IPage<StoryResponseDto> pageRs = storyMapper.pageQuery(wrapper, page);
        return pageRs;
    }

    @Transactional(rollbackFor = Exception.class)
    @SneakyThrows
    @Override
    public Boolean saveStory(StoryDto storyDto) {
        return this.save(storyDto);
    }

    @Override
    public Boolean updateStory(StoryDto storyDto) {
        return this.updateById(storyDto);
    }

    @Override
    public Boolean deleteById(String id) {
        UpdateWrapper wrapper = new UpdateWrapper();
        wrapper.eq("id", id);
        wrapper.set("status", -1);
        return this.update(wrapper);
    }

    @Override
    public StoryResponseDto queryById(String id) {
        StoryResponseDto storyResponseDto = storyMapper.queryById(id);
        return storyResponseDto;
    }

}
