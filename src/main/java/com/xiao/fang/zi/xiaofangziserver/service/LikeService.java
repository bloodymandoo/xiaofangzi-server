package com.xiao.fang.zi.xiaofangziserver.service;


import  com.xiao.fang.zi.xiaofangziserver.entity.Like;
import  com.xiao.fang.zi.xiaofangziserver.entity.queryDto.LikeDto;
import  com.xiao.fang.zi.xiaofangziserver.entity.responseDto.LikeResponseDto;
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
public interface LikeService extends IService<Like> {

  IPage<LikeResponseDto> pageQuery(PageModel<LikeDto> pm);

  Boolean saveLike(LikeDto likeDto);

  Boolean updateLike(LikeDto likeDto);

  Boolean deleteById(String id);

  LikeResponseDto queryById(String id);

}
