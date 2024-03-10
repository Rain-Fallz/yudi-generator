package com.rf.model;

import lombok.Data;

/**
 * freemarker模板数据模型：用于生成 ACM 文件
 *
 * @author rainfall
 * @date 2024/3/10
 */
@Data
public class MainTemplateDataModel {

    /**
     * 是否循环
     */
    private boolean loop;

    /**
     * 字符串替换（author）
     */
    private String author;

    /**
     * 字符串替换（outputText）
     */
    private String outputText;
}