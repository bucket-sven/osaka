package com.rela.osaka.design.pattern.behavior;

// 访问者模式：主要将数据结构与数据操作分离。
// 总结：在被访问的类里面加一个对外提供接待访问者的接口（如下面例子的accept()方法）。访问者封装了对被访问者结构的一些杂乱操作，避免这些操作"污染"被访问者，解耦结构与算法，同时具有优秀的扩展性。
public class VisitorDemo {
    public static void main(String []args) {
        Computer computer = new Computer("Raphael's Computer");
        computer.accept(new ComputerVisitor());
    }
}

class Computer {
    private String computerName;

    public String getComputerName() {
        return computerName;
    }

    Computer(String computerName) {
        this.computerName = computerName;
    }

    void accept(ComputerVisitor cv) {
        cv.visit(this);
    }
}

class ComputerVisitor {
    void visit(Computer computer) {
        System.out.println("访问" + computer + "的name属性: " + computer.getComputerName());
    }
}