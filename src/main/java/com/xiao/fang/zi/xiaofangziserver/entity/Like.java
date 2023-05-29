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
@TableName("like")
public class Like extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "",required=true)
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private Integer id;



    /**
     * 业务ID
     */
    @ApiModelProperty(value = "业务ID",required=false)
    @TableField("bizId")
    private Integer bizId;



    /**
     * 时间
     */
    @ApiModelProperty(value = "时间",required=false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("time")
    private Date time;



    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID",required=false)
    @TableField("userId")
    private Integer userId;



    /**
     * 类型
     */
    @ApiModelProperty(value = "类型",required=false)
    @TableField("type")
    private String type;



    /**
     * 状态
     */
    @ApiModelProperty(value = "状态",required=false)
    @TableField("status")
    private Integer status;




}
