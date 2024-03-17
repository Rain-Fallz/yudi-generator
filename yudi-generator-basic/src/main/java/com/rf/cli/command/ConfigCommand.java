package com.rf.cli.command;

import picocli.CommandLine;

import java.lang.reflect.Field;

/**
 * 打印代码生成器可以接收的动态参数
 *
 * @author rainfall
 * @date 2024/3/17
 */
@CommandLine.Command(name = "config", description = "打印代码生成器可以接收的动态参数", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {

    @Override
    public void run() {
        System.out.println("查看参数信息");

        // 通过反射机制获取参数
        Class<GenerateCommand> clazz = GenerateCommand.class;
        Field[] fields = clazz.getDeclaredFields();

        // 遍历并打印每个字段的类型和名称
        for (Field field : fields) {
            System.out.println(field.getType() + ": " + field.getName());
        }
    }
}