package com.kapx.gof.patterns.behavioral.command;

public class ElectricSwitch {
    private Command commandOn;
    private Command commandOff;

    public ElectricSwitch() {
        this.commandOn = new NoCommand();
        this.commandOff = new NoCommand();
    }

    public void setCommands(Command commandOn, Command commandOff) {
        this.commandOn = commandOn;
        this.commandOff = commandOff;
    }

    public void switchOn() {
        commandOn.execute();
    }

    public void switchOff() {
        commandOff.execute();
    }
}
