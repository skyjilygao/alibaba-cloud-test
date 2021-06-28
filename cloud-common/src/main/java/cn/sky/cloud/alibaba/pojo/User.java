package cn.sky.cloud.alibaba.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Long id;
    private Integer age;
    private String name;
}
