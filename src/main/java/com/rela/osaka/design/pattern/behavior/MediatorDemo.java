package com.rela.osaka.design.pattern.behavior;

import java.util.Date;

// 中介者模式：用一个中介对象来封装一系列的对象交互，中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
// 总结：中介者对象，用来封装关联对象之间的交互操作，使关联对象之间耦合度松散；例如，MVC模式中"控制器"就是"模型"和"视图"的中介者；与适配器模式的区别：适配器模式为了桥接互不兼容的接口，中介者为了分离原始结构和交互行为。
public class MediatorDemo {
    public static void main(String args[]) {
        User user1 = new User("小明");
        User user2 = new User("小红");
        user1.sendMessage("My Name is 小明");
        user2.sendMessage("My Name is 小红");
    }
}

class User {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    User(String name) {
        this.name = name;
    }

    void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}

class ChatRoom {
    static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + " [" + user.name + "] : " + message);
    }
}
