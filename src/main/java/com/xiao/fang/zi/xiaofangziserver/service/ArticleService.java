package com.xiao.fang.zi.xiaofangziserver.service;


import  com.xiao.fang.zi.xiaofangziserver.entity.Article;
import  com.xiao.fang.zi.xiaofangziserver.entity.queryDto.ArticleDto;
import  com.xiao.fang.zi.xiaofangziserver.entity.responseDto.ArticleResponseDto;
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
public interface ArticleService extends IService<Article> {

  IPage<ArticleResponseDto> pageQuery(PageModel<ArticleDto> pm);

  Boolean saveArticle(ArticleDto articleDto);

  Boolean updateArticle(ArticleDto articleDto);

  Boolean deleteById(String id);

  ArticleResponseDto queryById(String id);

}
