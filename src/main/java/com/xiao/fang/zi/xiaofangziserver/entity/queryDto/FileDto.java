package com.xiao.fang.zi.xiaofangziserver.entity.queryDto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.xiao.fang.zi.xiaofangziserver.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.experimental.Accessors;
import com.xiao.fang.zi.xiaofangziserver.entity.File;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaofangzi
 * @since 2023-05-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class FileDto extends File {



}
