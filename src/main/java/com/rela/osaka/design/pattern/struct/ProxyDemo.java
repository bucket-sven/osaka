package com.rela.osaka.design.pattern.struct;

// 代理模式：为其他对象提供一种代理以控制对这个对象的访问。
// 总结：创建类的代理类，间接访问被代理类的过程中对其功能加以控制，例如在某个函数执行前后添加额外功能。（代理例子：买火车票不一定在火车站买，也可以去代售点）。
// 和装饰器模式的区别：代理模式中，代理类对被代理的对象有控制权，决定其执行或者不执行。而装饰模式中，装饰类对代理对象没有控制权，只能为其增加一层装饰，以加强被装饰对象的功能，仅此而已。
public class ProxyDemo {
    public static void main(String[] args) {
        Animals1 dog = new DogProxy(new Dog1());
        dog.run();
    }
}

interface Animals1 {
    void run();
}

class Dog1 implements Animals1 {
    @Override
    public void run() {
        System.out.println("run!");
    }
}

class DogProxy implements Animals1 {
    private Animals1 animals;
    DogProxy(Animals1 animals) {
        super();
        this.animals = animals;
    }

    @Override
    public void run() {
        before();
        animals.run();
        after();
    }
    private void before() {
        System.out.println("before run!");
    }
    private void after() {
        System.out.println("after run!");
    }
}
