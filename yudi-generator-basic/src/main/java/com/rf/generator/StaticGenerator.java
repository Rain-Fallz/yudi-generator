package com.rf.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * @author rainfall
 * @date 2024/3/9
 */
public class StaticGenerator {
    /**
     * 递归拷贝文件，将源目录完整的拷贝到目标目录下
     *
     * @param sourcePath 源目录
     * @param destPath   目标目录
     */
    public static void copyFilesByRecursive(String sourcePath, String destPath) {
        File inputFile = new File(sourcePath);
        File outputFile = new File(destPath);
        try {
            copyFileByRecursive(inputFile, outputFile);
        } catch (Exception e) {
            System.err.println("文件复制失败！！！");
            System.out.println(e.getMessage());
        }
    }

    private static void copyFileByRecursive(File inputFile, File outputFile) throws IOException {
        // 区分是目录还是文件
        if (inputFile.isDirectory()) {
            System.out.println(inputFile.getName());
            File destOutputFile = new File(outputFile, inputFile.getName());
            // 如果是目录，首先创建目标目录
            if (!destOutputFile.exists()) {
                boolean isSuccessed = destOutputFile.mkdirs();
                if (!isSuccessed) {
                    System.out.println("创建目录 " + destOutputFile.getAbsolutePath() + " 失败！！！");
                }
            }
            // 获取目录下的所有文件和子目录
            File[] files = inputFile.listFiles();
            if (ArrayUtil.isEmpty(files)) {
                return;
            }
            for (File file : files) {
                // 递归拷贝下一层文件
                copyFileByRecursive(file, destOutputFile);
            }
        } else {
            // 如果是文件，直接复制到目标目录下
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }


    /**
     * 通过 Hutool 的 API 直接完成文件的复制
     *
     * @param sourcePath 源路径
     * @param destPath   目标路径
     */
    public static void copyFilesByHutool(String sourcePath, String destPath) {
        FileUtil.copy(sourcePath, destPath, false);
    }

    public static void main(String[] args) {
        // 获取整个项目的根路径
        String projectPath = System.getProperty("user.dir");
        // 源文件或目录的路径
        String sourcePath = projectPath + File.separator + "yudi-generator-demo-projects" + File.separator + "acm-template";
        // 静态文件生成
        // copyFilesByHutool(sourcePath, projectPath);
        copyFilesByRecursive(sourcePath, projectPath);
    }
}
