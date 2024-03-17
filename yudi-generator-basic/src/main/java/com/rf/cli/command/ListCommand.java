package com.rf.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;

import java.io.File;
import java.util.List;

/**
 * 打印源文件名
 *
 * @author rainfall
 * @date 2024/3/17
 */
@CommandLine.Command(name = "list", description = "打印源文件名", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable {

    @Override
    public void run() {
        // 获取整个项目的根路径
        String projectPath = System.getProperty("user.dir");
        // 源文件或目录的路径
        String filePath = projectPath + File.separator + "yudi-generator-demo-projects" + File.separator + "acm-template";
        // 遍历文件，并打印
        List<File> files = FileUtil.loopFiles(filePath);
        for (File file : files) {
            System.out.println(file);
        }
    }
}