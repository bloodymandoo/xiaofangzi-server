package com.xiao.fang.zi.xiaofangziserver.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;


}
