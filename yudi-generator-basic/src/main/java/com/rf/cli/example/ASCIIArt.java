package com.rf.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
// some exports omitted for the sake of brevity

/**
 * picocli 官方示例
 *
 * @author rainfall
 * @date 2024/3/17
 */
@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
public class ASCIIArt implements Runnable {

    @Option(names = {"-s", "--font-size"}, description = "Font size")
    int fontSize = 19;

    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
            description = "Words to be translated into ASCII art.")
    private String[] words = {"Hello", "picocli"};

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ASCIIArt()).execute(args);
        System.exit(exitCode);
    }

    /**
     * 实现自己的业务逻辑，在 main 方法中调用 execute 时，会执行 run 方法
     */
    @Override
    public void run() {
        // The business logic of the command goes here...
        // In this case, code for generation of ASCII art graphics
        // (omitted for the sake of brevity).
        System.out.println("Font size: " + fontSize);
        System.out.println("Words: " + String.join(", ", words));
    }
}