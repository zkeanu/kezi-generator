package com.keanu.cli.pattern;

/**
 *
 *
 * @author <a href="https://github.com/Li-Keanu">keanu</a>
 * @since 2025/2/27 21:47
 */
public class Device {

    private String name;

    public Device(String name) {
        this.name = name;
    }

    public void turnOff() {
        System.out.println(name + " 设备关闭");
    }

    public void turnOn() {
        System.out.println(name + " 设备打开");
    }
}
