package com.rela.osaka.design.pattern.struct;

// 桥接模式：将抽象部分与实现部分分离，使它们都可以独立的变化。
// 总结：通过对Bridge类的调用，实现了对同一接口下不同实现类的调用；建立一个继承于同一抽象的不同实现类之间的关联关系，这个关系由Bridge类桥接起来。
public class BridgeDemo {
    public static void main(String[] args) {
        Color white = new White();
        Shape square = new Square();
        square.setColor(white);
        square.draw();
    }
}

interface Color {
    void paint(String shape);
}

abstract class Shape {
    Color color;
    abstract void draw();

    void setColor(Color color) {
        this.color = color;
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        color.paint("圆形");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        color.paint("长方形");
    }
}

class Square extends Shape {
    @Override
    void draw() {
        color.paint("正方形");
    }
}

class White implements Color {
    @Override
    public void paint(String shape) {
        System.out.println("白色的" + shape);
    }
}

class Gray implements Color {
    @Override
    public void paint(String shape) {
        System.out.println("灰色的" + shape);
    }
}

class Black implements Color {
    @Override
    public void paint(String shape) {
        System.out.println("黑色的" + shape);
    }
}
