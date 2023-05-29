package com.xiao.fang.zi.xiaofangziserver.service;


import  com.xiao.fang.zi.xiaofangziserver.entity.File;
import  com.xiao.fang.zi.xiaofangziserver.entity.queryDto.FileDto;
import  com.xiao.fang.zi.xiaofangziserver.entity.responseDto.FileResponseDto;
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
public interface FileService extends IService<File> {

  IPage<FileResponseDto> pageQuery(PageModel<FileDto> pm);

  Boolean saveFile(FileDto fileDto);

  Boolean updateFile(FileDto fileDto);

  Boolean deleteById(String id);

  FileResponseDto queryById(String id);

}
