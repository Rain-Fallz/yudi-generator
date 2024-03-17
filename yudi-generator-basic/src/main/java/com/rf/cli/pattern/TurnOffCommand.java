package com.rf.cli.pattern;

/**
 * @author rainfall
 * @date 2024/3/17
 */
public class TurnOffCommand implements Command {

    private Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}