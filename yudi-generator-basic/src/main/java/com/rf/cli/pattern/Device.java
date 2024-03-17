package com.rf.cli.pattern;

import javax.annotation.Resource;

/**
 * 用于接收命令的设备
 *
 * @author rainfall
 * @date 2024/3/17
 */
@Resource
public class Device {

    private String name;

    public Device(String name) {
        this.name = name;
    }

    public void turnOn() {
        System.out.println(name + "设备打开");
    }

    public void turnOff() {
        System.out.println(name + "设备关闭");
    }
}