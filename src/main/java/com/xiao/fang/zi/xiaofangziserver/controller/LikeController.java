package com.xiao.fang.zi.xiaofangziserver.controller;

import  com.xiao.fang.zi.xiaofangziserver.entity.queryDto.LikeDto;
import  com.xiao.fang.zi.xiaofangziserver.entity.responseDto.LikeResponseDto;
import com.xiao.fang.zi.xiaofangziserver.service.LikeService;
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
@RequestMapping("/like")
public class LikeController extends BaseController {

    @Autowired
    private LikeService likeService;

    @ApiOperation(value = "条件分页查询接口")
    @PostMapping(value = "/page")
    public CommonResult<IPage<LikeResponseDto>> queryByCondition( @RequestBody PageModel<LikeDto> pm){
        IPage<LikeResponseDto> pageRs = likeService.pageQuery(pm);
        return CommonResult.success(pageRs);
    }

    @ApiOperation(value = "新增", notes = "新增")
    @PostMapping("/save")
    public CommonResult<Boolean> save( @RequestBody LikeDto likeDto){
        return CommonResult.success(likeService.saveLike(likeDto));
    }

    @ApiOperation(value = "修改", notes = "修改")
    @PutMapping("/update")
    public CommonResult<Boolean> update(@RequestBody LikeDto likeDto) {
        return CommonResult.success(likeService.updateLike(likeDto));
    }

    @ApiOperation(value = "根据id删除", notes = "根据id删除")
    @DeleteMapping("/{id}")
    public CommonResult<Boolean> delete(@PathVariable String id) {
        return CommonResult.success(likeService.deleteById(id));
    }

    @ApiOperation(value = "根据id获取", notes = "根据id获取")
    @GetMapping("/{id}")
    public CommonResult<LikeResponseDto> queryById(@PathVariable String id) {
        return CommonResult.success(likeService.queryById(id));
    }
}
