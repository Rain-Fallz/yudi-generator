package com.rf.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * 交互式输入示例
 *
 * @author rainfall
 * @date 2024/3/17
 */
class Login implements Callable<Integer> {

    @Option(names = {"-u", "--user"}, description = "User name")
    String user;

    @Option(names = {"-p", "--password"}, arity = "0..1", description = "Password Passphrase", interactive = true)
    String password;

    @Option(names = {"-c", "--check-password"}, arity = "0..1", description = "Check passphrase", interactive = true)
    String checkPassword;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Login()).execute("-u", "rainfall", "-p", "-c", "123xxx");
        System.exit(exitCode);
    }

    public Integer call() throws Exception {
        System.out.println("User name: " + user);
        System.out.println("Password Passphrase: " + password);
        System.out.println("Check passphrase: " + checkPassword);
        return 0;
    }
}