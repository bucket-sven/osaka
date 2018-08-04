package com.rela.osaka.design.pattern.behavior;

import java.util.ArrayList;
import java.util.List;

// 命令模式：将一个请求封装成一个对象，从而使您可以用不同的请求对客户进行参数化。
// 总结：三种角色（调用者→接受者→命令）；解耦行为请求者和行为实现着，实现请求和执行分开；调用者选择命令发布，命令指定执行者。
public class CommandDemo {
    public static void main(String[] args) {
        Receiver receiver = new Receiver("小明");

        Command shootCommand = new ShootCommand(receiver);
        Command otherCommand = new OtherCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.addCommand(shootCommand);
        invoker.addCommand(otherCommand);
        invoker.sendCommands();
    }
}

interface Command {
    void execute();
}

class Receiver {
    String name;
    Receiver(String name) {
        this.name = name;
    }

    void action(){
        System.out.println(name + " received the command");
    }
}

class Invoker {
    List<Command> commandList = new ArrayList<>();
    void addCommand(Command command) {
        this.commandList.add(command);
    }

    void sendCommands() {
        for (Command command : commandList) {
            command.execute();
            System.out.println();
        }
        commandList.clear();
    }
}

class ShootCommand implements Command {
    private Receiver receiver;
    ShootCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("shootCommand is execute:");
        receiver.action();
    }
}

class OtherCommand implements Command {
    private Receiver receiver;
    OtherCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("otherCommand is execute:");
        receiver.action();
    }
}
