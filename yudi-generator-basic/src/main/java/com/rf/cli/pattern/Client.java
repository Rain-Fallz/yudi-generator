package com.rf.cli.pattern;

/**
 * @author rainfall
 * @date 2024/3/17
 */
public class Client {

    public static void main(String[] args) {
        Device tv = new Device("电视机");
        Device airCondition = new Device("空调");

        TurnOffCommand turnOff = new TurnOffCommand(tv);
        TurnOnCommand turnOn = new TurnOnCommand(airCondition);

        RemoteControl remoteTv = new RemoteControl(turnOff);
        RemoteControl remoteAir = new RemoteControl(turnOn);

        remoteTv.pressButton();
        remoteAir.pressButton();
    }
}