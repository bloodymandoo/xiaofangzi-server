package com.xiao.fang.zi.xiaofangziserver.service.impl;

import  com.xiao.fang.zi.xiaofangziserver.entity.File;
import  com.xiao.fang.zi.xiaofangziserver.entity.queryDto.FileDto;
import  com.xiao.fang.zi.xiaofangziserver.entity.responseDto.FileResponseDto;
import com.xiao.fang.zi.xiaofangziserver.mapper.FileMapper;
import com.xiao.fang.zi.xiaofangziserver.service.FileService;
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
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public IPage<FileResponseDto> pageQuery(PageModel<FileDto> pm) {
        FileDto con = pm.getCondition();
        QueryWrapper<File> wrapper = new QueryWrapper<>();
        if (con != null) {

        }
        Page<FileResponseDto> page = new Page<>();
        page.setCurrent(pm.getCurrent());
        page.setSize(pm.getSize());
        IPage<FileResponseDto> pageRs = fileMapper.pageQuery(wrapper, page);
        return pageRs;
    }

    @Transactional(rollbackFor = Exception.class)
    @SneakyThrows
    @Override
    public Boolean saveFile(FileDto fileDto) {
        return this.save(fileDto);
    }

    @Override
    public Boolean updateFile(FileDto fileDto) {
        return this.updateById(fileDto);
    }

    @Override
    public Boolean deleteById(String id) {
        UpdateWrapper wrapper = new UpdateWrapper();
        wrapper.eq("id", id);
        wrapper.set("status", -1);
        return this.update(wrapper);
    }

    @Override
    public FileResponseDto queryById(String id) {
        FileResponseDto fileResponseDto = fileMapper.queryById(id);
        return fileResponseDto;
    }

}
