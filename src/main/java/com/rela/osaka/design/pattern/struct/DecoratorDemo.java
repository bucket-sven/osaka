package com.rela.osaka.design.pattern.struct;

// 装饰器模式：动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活。
// 总结：创建类的装饰类，对被装饰类增强功能。装饰模式是继承的一个替代模式。
public class DecoratorDemo {
    public static void main(String[] args) {
        Animals dog = new AnimalsDecorator(new Dog());
        dog.run();
    }
}

interface Animals {
    void run();
}

class Dog implements Animals {
    @Override
    public void run() {
        System.out.println("dog run");
    }
}

class AnimalsDecorator implements Animals {
    private Animals animals;
    AnimalsDecorator(Animals animals) {
        this.animals = animals;
    }

    @Override
    public void run() {
        animals.run();
        System.out.println("fast!");
    }
}
