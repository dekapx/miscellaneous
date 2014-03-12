package com.kapx.gof.patterns.behavioral.command;

public class ElectricSwitchController {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        Fan fan = new Fan();
        Command fanOnCommand = new FanOnCommand(fan);
        Command fanOffCommand = new FanOffCommand(fan);

        ElectricSwitch electricSwitch = new ElectricSwitch();

        // test ElectricSwitch with light
        electricSwitch.setCommands(lightOnCommand, lightOffCommand);
        electricSwitch.switchOn();
        electricSwitch.switchOff();

        // test ElectricSwitch with fan
        electricSwitch.setCommands(fanOnCommand, fanOffCommand);
        electricSwitch.switchOn();
        electricSwitch.switchOff();
    }
}
