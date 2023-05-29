package com.xiao.fang.zi.xiaofangziserver.service.impl;

import  com.xiao.fang.zi.xiaofangziserver.entity.Article;
import  com.xiao.fang.zi.xiaofangziserver.entity.queryDto.ArticleDto;
import  com.xiao.fang.zi.xiaofangziserver.entity.responseDto.ArticleResponseDto;
import com.xiao.fang.zi.xiaofangziserver.mapper.ArticleMapper;
import com.xiao.fang.zi.xiaofangziserver.service.ArticleService;
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
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public IPage<ArticleResponseDto> pageQuery(PageModel<ArticleDto> pm) {
        ArticleDto con = pm.getCondition();
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        if (con != null) {

        }
        Page<ArticleResponseDto> page = new Page<>();
        page.setCurrent(pm.getCurrent());
        page.setSize(pm.getSize());
        IPage<ArticleResponseDto> pageRs = articleMapper.pageQuery(wrapper, page);
        return pageRs;
    }

    @Transactional(rollbackFor = Exception.class)
    @SneakyThrows
    @Override
    public Boolean saveArticle(ArticleDto articleDto) {
        return this.save(articleDto);
    }

    @Override
    public Boolean updateArticle(ArticleDto articleDto) {
        return this.updateById(articleDto);
    }

    @Override
    public Boolean deleteById(String id) {
        UpdateWrapper wrapper = new UpdateWrapper();
        wrapper.eq("id", id);
        wrapper.set("status", -1);
        return this.update(wrapper);
    }

    @Override
    public ArticleResponseDto queryById(String id) {
        ArticleResponseDto articleResponseDto = articleMapper.queryById(id);
        return articleResponseDto;
    }

}
