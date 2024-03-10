package com.rf.generator;

import com.rf.model.MainTemplateDataModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


/**
 * ACM 动态模版生成器
 *
 * @author rainfall
 * @date 2024/3/10
 */
public class DynamicGenerator {

    public static void main(String[] args) throws TemplateException, IOException {
        // 动态文件生成
        String projectPath = System.getProperty("user.dir");
        String dynamicInputPath = projectPath + File.separator + "yudi-generator-basic\\src\\main\\resources\\templates\\MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "MainTemplate.java";

        MainTemplateDataModel dataModel = new MainTemplateDataModel();
        dataModel.setAuthor("rainfall");
        dataModel.setOutputText("The sum is");
        dataModel.setLoop(false);

        doGenerate(dynamicInputPath, dynamicOutputPath, dataModel);
    }

    /**
     * 动态文件生成
     *
     * @param inputPath  输入路径
     * @param outputPath 输出路径
     * @param dataModel  数据模型
     */
    public static void doGenerate(String inputPath, String outputPath, MainTemplateDataModel dataModel) throws IOException, TemplateException {
        // new 一个 freemarker 的 Configuration 对象，参数为对应的版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模版文件所在路径
        File templateDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);

        // 设置模版文件所用的字符集
        configuration.setDefaultEncoding("utf-8");

        // 加载指定模版
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        // 生成
        Writer out = new FileWriter(outputPath);
        template.process(dataModel, out);

        // 流关闭
        out.close();
    }


}