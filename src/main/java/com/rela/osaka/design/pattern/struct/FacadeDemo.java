package com.rela.osaka.design.pattern.struct;

// 外观模式：为子系统中的一组接口提供一个一致的界面，外观模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
// 总结：在客户端和复杂系统之间再加一层，在这一层中将调用顺序、依赖关系等处理好。提供一个容易使用的外观层。
public class FacadeDemo {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.start();
    }
}

class CPU {
    void start() {
        System.out.println("CPU is start!");
    }

    void shutdown() {
        System.out.println("CPU shutdown!");
    }
}

class Disk {
    void start() {
        System.out.println("put in disk!");
    }

    void shutdown() {
        System.out.println("disk shutdown");
    }
}

class Computer {
    private CPU cpu;
    private Disk disk;

    Computer() {
        cpu = new CPU();
        disk = new Disk();
    }

    void start() {
        System.out.println(" Computer start begin");
        disk.start();
        cpu.start();
        System.out.println(" Computer start end");
    }

    void shutdown() {
        System.out.println("Computer shutdown begin");
        disk.shutdown();
        cpu.shutdown();
        System.out.println("Computer shutdown end");
    }
}