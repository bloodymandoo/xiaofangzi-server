package com.xiao.fang.zi.xiaofangziserver.service;


import  com.xiao.fang.zi.xiaofangziserver.entity.Story;
import  com.xiao.fang.zi.xiaofangziserver.entity.queryDto.StoryDto;
import  com.xiao.fang.zi.xiaofangziserver.entity.responseDto.StoryResponseDto;
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
public interface StoryService extends IService<Story> {

  IPage<StoryResponseDto> pageQuery(PageModel<StoryDto> pm);

  Boolean saveStory(StoryDto storyDto);

  Boolean updateStory(StoryDto storyDto);

  Boolean deleteById(String id);

  StoryResponseDto queryById(String id);

}
