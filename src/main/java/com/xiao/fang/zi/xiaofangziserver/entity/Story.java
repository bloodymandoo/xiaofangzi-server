package com.xiao.fang.zi.xiaofangziserver.entity;

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
import org.springframework.format.annotation.DateTimeFormat;

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
@TableName("story")
public class Story extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "",required=true)
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private Integer id;



    /**
     * 内容
     */
    @ApiModelProperty(value = "内容",required=false)
    @TableField("content")
    private String content;



    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间",required=false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("time")
    private Date time;



    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人",required=false)
    @TableField("userId")
    private Integer userId;



    /**
     * 状态
     */
    @ApiModelProperty(value = "状态",required=false)
    @TableField("status")
    private Integer status;




}
