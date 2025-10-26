package it.unibo.design.robot.components.api;

public interface CommandableRobotPart extends RobotPart{
    boolean sendCommand(String command);
    String[] availableCommands();
}
