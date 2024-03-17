package com.rf.cli.pattern;

/**
 * @author rainfall
 * @date 2024/3/17
 */
public class TurnOnCommand implements Command {

    private Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}