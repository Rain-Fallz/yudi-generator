package com.rf.generator;

import com.rf.model.MainTemplateDataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 静态文件 + 动态文件 生成
 *
 * @author rainfall
 * @date 2024/3/10
 */
public class MainGenerator {

    public static void main(String[] args) throws TemplateException, IOException {


        MainTemplateDataModel dataModel = new MainTemplateDataModel();
        dataModel.setAuthor("rainfall");
        dataModel.setOutputText("The sum is");
        dataModel.setLoop(false);

        generateAll(dataModel);
    }

    public static void generateAll(MainTemplateDataModel dataModel) throws TemplateException, IOException {
        // 1.静态文件生成
        // 获取整个项目的根路径
        String projectPath = System.getProperty("user.dir");
        // 源文件或目录的路径
        String staticSourcePath = projectPath + File.separator + "yudi-generator-demo-projects" + File.separator + "acm-template";
        // 静态文件生成
        StaticGenerator.copyFilesByRecursive(staticSourcePath, projectPath);

        // 2.动态文件生成
        String dynamicInputPath = projectPath + File.separator + "yudi-generator-basic\\src\\main\\resources\\templates\\MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template" + File.separator + "DynamicTemplate.java";
        DynamicGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, dataModel);
    }
}