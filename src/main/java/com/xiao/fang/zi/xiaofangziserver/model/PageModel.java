package com.xiao.fang.zi.xiaofangziserver.model;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;

public class PageModel<T> {

    private T condition;

    @ApiModelProperty(value = "页码", required = true, example = "1")
    private Long current = 1L;

    @ApiModelProperty(value = "页长", required = true, example = "10")
    private Long size = 10L;

    public Page<T> parsePage() {
        return new Page(this.current, this.size);
    }

    public T getCondition() {
        return this.condition;
    }

    public Long getCurrent() {
        return this.current;
    }

    public Long getSize() {
        return this.size;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageModel)) {
            return false;
        } else {
            PageModel<?> other = (PageModel)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$condition = this.getCondition();
                    Object other$condition = other.getCondition();
                    if (this$condition == null) {
                        if (other$condition == null) {
                            break label47;
                        }
                    } else if (this$condition.equals(other$condition)) {
                        break label47;
                    }

                    return false;
                }

                Object this$current = this.getCurrent();
                Object other$current = other.getCurrent();
                if (this$current == null) {
                    if (other$current != null) {
                        return false;
                    }
                } else if (!this$current.equals(other$current)) {
                    return false;
                }

                Object this$size = this.getSize();
                Object other$size = other.getSize();
                if (this$size == null) {
                    if (other$size != null) {
                        return false;
                    }
                } else if (!this$size.equals(other$size)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof PageModel;
    }



    @Override
    public String toString() {
        return "PageModel(condition=" + this.getCondition() + ", current=" + this.getCurrent() + ", size=" + this.getSize() + ")";
    }

    public PageModel() {
    }

    public PageModel(T condition, Long current, Long size) {
        this.condition = condition;
        this.current = current;
        this.size = size;
    }

}
