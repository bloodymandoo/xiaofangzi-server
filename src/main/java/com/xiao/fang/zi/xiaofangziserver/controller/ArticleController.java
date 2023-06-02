package com.xiao.fang.zi.xiaofangziserver.controller;

import  com.xiao.fang.zi.xiaofangziserver.entity.queryDto.ArticleDto;
import  com.xiao.fang.zi.xiaofangziserver.entity.responseDto.ArticleResponseDto;
import com.xiao.fang.zi.xiaofangziserver.service.ArticleService;
import com.xiao.fang.zi.xiaofangziserver.model.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import com.xiao.fang.zi.xiaofangziserver.util.CommonResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaofangzi
 * @since 2023-05-29
 */
@Slf4j
@Api(value = "接口",tags = "接口")
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "条件分页查询接口")
    @PostMapping(value = "/page")
    public CommonResult<IPage<ArticleResponseDto>> queryByCondition( @RequestBody PageModel<ArticleDto> pm){
        IPage<ArticleResponseDto> pageRs = articleService.pageQuery(pm);
        return CommonResult.success(pageRs);
    }

    @ApiOperation(value = "新增", notes = "新增")
    @PostMapping("/save")
    public CommonResult<Boolean> save(@RequestBody ArticleDto articleDto){
        return CommonResult.success(articleService.saveArticle(articleDto));
    }

    @ApiOperation(value = "修改", notes = "修改")
    @PutMapping("/update")
    public CommonResult<Boolean> update(@RequestBody ArticleDto articleDto) {
        return CommonResult.success(articleService.updateArticle(articleDto));
    }

    @ApiOperation(value = "根据id删除", notes = "根据id删除")
    @DeleteMapping("/{id}")
    public CommonResult<Boolean> delete(@PathVariable String id) {
        return CommonResult.success(articleService.deleteById(id));
    }

    @ApiOperation(value = "根据id获取", notes = "根据id获取")
    @GetMapping("/{id}")
    public CommonResult<ArticleResponseDto> queryById(@PathVariable String id) {
        return CommonResult.success(articleService.queryById(id));
    }
}
