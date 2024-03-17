package com.rf.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.rf.generator.MainGenerator;
import com.rf.model.MainTemplateDataModel;
import lombok.Data;
import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * 代码生成命令
 *
 * @author rainfall
 * @date 2024/3/17
 */
@Data
@CommandLine.Command(name = "generate", description = "代码生成命令", mixinStandardHelpOptions = true)
public class GenerateCommand implements Callable {

    @CommandLine.Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否循环", interactive = true, echo = true)
    private boolean loop = true;

    @CommandLine.Option(names = {"-a", "--author"}, arity = "0..1", description = "作者", interactive = true, echo = true)
    private String author = "rainfall";

    @CommandLine.Option(names = {"-o", "--outputText"}, arity = "0..1", description = "输出文本", interactive = true, echo = true)
    private String outputText = "sum: ";

    @Override
    public Integer call() throws Exception {
        MainTemplateDataModel dataModel = new MainTemplateDataModel();
        BeanUtil.copyProperties(this, dataModel);
        System.out.println("用户输入的动态配置信息： " + dataModel);
        MainGenerator.generateAll(dataModel);
        return 0;
    }
}