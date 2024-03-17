package com.rf.cli.pattern;

/**
 * @author rainfall
 * @date 2024/3/17
 */
public class RemoteControl {

    private Command command;

    public RemoteControl(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}