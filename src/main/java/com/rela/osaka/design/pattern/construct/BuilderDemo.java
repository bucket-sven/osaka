package com.rela.osaka.design.pattern.construct;

// 建造者模式：将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。
// 总结：将一些不会变的基本组件，通过builder，组合，构建复杂对象，实现分离
public class BuilderDemo {
    public static void main(String[] args) {
        PriceBuilder priceBuilder = new PriceBuilder();
        System.out.println("Car1和Car2:" + priceBuilder.Car1AndCar2());
        System.out.println("Car1和Bus:" + priceBuilder.Car1AndBus());
    }
}

interface Car {}

class Car1 implements Car {
    int price = 20;
}

class Car2 implements Car {
    int price = 90;
}

class Bus implements Car {
    int price = 500;
}

class PriceBuilder {
    public int Car1AndCar2() {
        int priceOfCar1 = new Car1().price;
        int priceOfCar2 = new Car2().price;
        return priceOfCar1 + priceOfCar2;
    }

    public int Car1AndBus() {
        int priceOfCar1 = new Car1().price;
        int priceOfBus = new Bus().price;
        return priceOfCar1 + priceOfBus;
    }
}
