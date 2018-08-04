package com.rela.osaka.design.pattern.construct;

// 抽象工厂模式：提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
// 总结：工厂模式 >> 一种工厂，多种对象 ； 抽象工厂模式 >> 一种抽象工厂，多种工厂，每个工厂又可以生产多种对象
public class AbstractFactoryDemo {
    static AbstractFactory getFactory(String factoryName) {
        if (factoryName.equalsIgnoreCase("animals")) {
            return new AnimalsFactory2();
        } else if (factoryName.equalsIgnoreCase("others")) {
            return new OthersFactory();
        }
        return null;
    }

    public static void main(String args[]) {
        AbstractFactory animalsFactory = getFactory("animals");
        Animals cat = animalsFactory.getAnimals("cat");
        cat.name();
    }
}

abstract class AbstractFactory {
    abstract public Animals getAnimals(String name);
    abstract public Object getObject();
}

class AnimalsFactory2 extends AbstractFactory {
    @Override
    public Animals getAnimals(String name) {
        if (name.equalsIgnoreCase("cat")) {
            return new Cat();
        }
        return null;
    }

    @Override
    public Object getObject() {
        return null;
    }
}

class OthersFactory extends AbstractFactory {
    @Override
    public Animals getAnimals(String name) {
        return null;
    }

    @Override
    public Object getObject() {
        return null;
    }
}