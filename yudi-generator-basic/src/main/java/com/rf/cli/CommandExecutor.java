package com.rf.cli;

import com.rf.cli.command.ConfigCommand;
import com.rf.cli.command.GenerateCommand;
import com.rf.cli.command.ListCommand;
import picocli.CommandLine;

/**
 * 主命令执行器，作为子命令调用的入口
 *
 * @author rainfall
 * @date 2024/3/17
 */
@CommandLine.Command(name = "executor", description = "主命令执行器", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {

    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand())
                .addSubcommand(new ConfigCommand());
    }

    @Override
    public void run() {
        // 不输入子命令时，给出友好的提示
        System.out.println("请输入具体命令，或者输入 --help 查看命令提示");
    }

    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}