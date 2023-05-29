package com.xiao.fang.zi.xiaofangziserver.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "",required=true)
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private Integer id;



    @ApiModelProperty(value = "",required=false)
    @TableField("wx")
    private String wx;



    @ApiModelProperty(value = "",required=false)
    @TableField("img")
    private String img;



    @ApiModelProperty(value = "",required=false)
    @TableField("status")
    private Integer status;



    @ApiModelProperty(value = "",required=false)
    @TableField("name")
    private String name;



    @ApiModelProperty(value = "",required=false)
    @TableField("account")
    private String account;



    @ApiModelProperty(value = "",required=false)
    @TableField("title")
    private String title;




}
