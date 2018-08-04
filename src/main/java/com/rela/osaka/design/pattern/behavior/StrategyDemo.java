package com.rela.osaka.design.pattern.behavior;

// 策略模式：定义一系列的算法,把它们一个个封装起来, 并且使它们可相互替换。
// 总结：统一接口下的一系列算法类（多种策略），用一个类将其封装起来，使它们(多种策略)可动态切换。和工厂模式的区别：工厂模式是创建型模式，是为了创建不同对象；而策略模式是行为模式，为了选择不同的行为。
public class StrategyDemo {
    public static void main(String[] args) {
        OperationStrategy os = new OperationStrategy(new OperationAdd());
        os.executeStrategy(1, 2);
    }
}

interface Operation {
    void doOperation(int a, int b);
}

class OperationAdd implements Operation {
    @Override
    public void doOperation(int a, int b) {
        System.out.println(a + "+" + b + "=" + (a + b));
    }
}

class OperationMinus implements Operation {
    @Override
    public void doOperation(int a, int b) {
        System.out.println(a + "-" + b + "=" + (a - b));
    }
}

class OperationStrategy {
    private Operation operation;
    OperationStrategy(Operation operation) {
        this.operation = operation;
    }

    void executeStrategy(int a, int b) {
        operation.doOperation(a, b);
    }
}
