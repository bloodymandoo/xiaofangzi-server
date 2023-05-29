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
@TableName("file")
public class File extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "",required=true)
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private Integer id;



    /**
     * 文件名
     */
    @ApiModelProperty(value = "文件名",required=false)
    @TableField("name")
    private String name;



    /**
     * 时间
     */
    @ApiModelProperty(value = "时间",required=false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("time")
    private Date time;



    /**
     * 类型
     */
    @ApiModelProperty(value = "类型",required=false)
    @TableField("type")
    private String type;



    /**
     * 上传人
     */
    @ApiModelProperty(value = "上传人",required=false)
    @TableField("userId")
    private Integer userId;



    /**
     * URL
     */
    @ApiModelProperty(value = "URL",required=false)
    @TableField("url")
    private String url;



    /**
     * 本地路径
     */
    @ApiModelProperty(value = "本地路径",required=false)
    @TableField("path")
    private String path;



    /**
     * 保存方式
     */
    @ApiModelProperty(value = "保存方式",required=false)
    @TableField("saveType")
    private String saveType;



    /**
     * 状态
     */
    @ApiModelProperty(value = "状态",required=false)
    @TableField("status")
    private Integer status;



    /**
     * 业务ID
     */
    @ApiModelProperty(value = "业务ID",required=false)
    @TableField("bizId")
    private Integer bizId;




}
