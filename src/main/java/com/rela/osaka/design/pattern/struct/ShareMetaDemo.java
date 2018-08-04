package com.rela.osaka.design.pattern.struct;

import java.util.HashMap;

// 享元模式：运用共享技术有效地支持大量细粒度的对象。
// 总结：重用现有的同类对象，若未找到匹配的对象，则创建新对象。例如，数据库的连接池。减少对象的创建，降低系统内存，提高效率。
public class ShareMetaDemo {
    public static void main(String[] args) {
        Circle2 c1 = CircleFactory.getCircle("red");
        c1.draw();

        for (int i = 0; i < 2; i++) {
            Circle2 c2 = CircleFactory.getCircle("green");
            c2.draw();
        }
    }
}

class Circle2 {
    private String color;

    Circle2(String color) {
        this.color = color;
    }

    void draw() {
        System.out.println(color + " Circle!");
    }
}

class CircleFactory {
    private static final HashMap<String, Circle2> map = new HashMap<>();
    static {
        map.put("red", new Circle2("red"));
    }

    static Circle2 getCircle(String color) {
        Circle2 circle = map.get(color);
        if (circle == null) {
            circle = new Circle2(color);
            map.put(color, circle);
            System.out.println("new a circle of color: " + color);
        }
        return circle;
    }
}
