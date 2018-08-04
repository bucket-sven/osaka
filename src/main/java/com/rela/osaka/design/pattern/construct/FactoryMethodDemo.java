package com.rela.osaka.design.pattern.construct;

// 工厂方法模式：定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。
// 总结： 通过对象工厂灵活地生产多种对象
public class FactoryMethodDemo {
    public static void main(String[] args) {
        Animals cat = AnimalsFactory.getAnimal("cat");
        cat.name();
        Animals dog = AnimalsFactory.getAnimal("dog");
        dog.name();
    }
}

interface Animals {
    void name();
}

class Cat implements Animals {
    @Override
    public void name() {
        System.out.println("This is a cat");
    }
}

class Dog implements Animals {
    @Override
    public void name() {
        System.out.println("This is a dog");
    }
}

class AnimalsFactory {
    static Animals getAnimal(String name) {
        if (name.equalsIgnoreCase("cat")) {
            return new Cat();
        } else if (name.equalsIgnoreCase("dog")) {
            return new Dog();
        }
        return null;
    }
}