package com.xiao.fang.zi.xiaofangziserver.controller;

import  com.xiao.fang.zi.xiaofangziserver.entity.queryDto.FileDto;
import  com.xiao.fang.zi.xiaofangziserver.entity.responseDto.FileResponseDto;
import com.xiao.fang.zi.xiaofangziserver.service.FileService;
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
@RequestMapping("/file")
public class FileController extends BaseController {

    @Autowired
    private FileService fileService;

    @ApiOperation(value = "条件分页查询接口")
    @PostMapping(value = "/page")
    public CommonResult<IPage<FileResponseDto>> queryByCondition( @RequestBody PageModel<FileDto> pm){
        IPage<FileResponseDto> pageRs = fileService.pageQuery(pm);
        return CommonResult.success(pageRs);
    }

    @ApiOperation(value = "新增", notes = "新增")
    @PostMapping("/save")
    public CommonResult<Boolean> save( @RequestBody FileDto fileDto){
        return CommonResult.success(fileService.saveFile(fileDto));
    }

    @ApiOperation(value = "修改", notes = "修改")
    @PutMapping("/update")
    public CommonResult<Boolean> update(@RequestBody FileDto fileDto) {
        return CommonResult.success(fileService.updateFile(fileDto));
    }

    @ApiOperation(value = "根据id删除", notes = "根据id删除")
    @DeleteMapping("/{id}")
    public CommonResult<Boolean> delete(@PathVariable String id) {
        return CommonResult.success(fileService.deleteById(id));
    }

    @ApiOperation(value = "根据id获取", notes = "根据id获取")
    @GetMapping("/{id}")
    public CommonResult<FileResponseDto> queryById(@PathVariable String id) {
        return CommonResult.success(fileService.queryById(id));
    }
}
