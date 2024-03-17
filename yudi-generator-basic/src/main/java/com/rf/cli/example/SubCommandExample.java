package com.rf.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * 子命令示例
 *
 * @author rainfall
 * @date 2024/3/17
 */
@Command(name = "mainCommand", mixinStandardHelpOptions = true)
public class SubCommandExample implements Runnable {

    public static void main(String[] args) {
        // String[] myArgs = {};
        // String[] myArgs = {"--help"};
        // // 执行子命令
        // String[] myArgs = {"add"};
        // String[] myArgs = {"add", "--help"};
        // // 执行不存在的子命令
        String[] myArgs = {"update"};

        int execute = new CommandLine(new SubCommandExample()).addSubcommand(new AddCommand())
                .addSubcommand(new DeleteCommand()).addSubcommand(new QueryCommand()).execute(myArgs);
        System.exit(execute);
    }

    @Override
    public void run() {
        System.out.println("执行主命令！");
    }

    @Command(name = "add", mixinStandardHelpOptions = true)
    static class AddCommand implements Runnable {
        @Override
        public void run() {
            System.out.println("执行 Add 子命令！");
        }
    }

    @Command(name = "delete", mixinStandardHelpOptions = true)
    static class DeleteCommand implements Runnable {
        @Override
        public void run() {
            System.out.println("执行 Delete 子命令！");
        }
    }

    @Command(name = "query", mixinStandardHelpOptions = true)
    static class QueryCommand implements Runnable {
        @Override
        public void run() {
            System.out.println("执行 Query 子命令！");
        }
    }
}