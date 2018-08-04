package com.rela.osaka.design.pattern.construct;

// 单例模式：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
// 总结：在类内部创造单一对象，通过设置构造方法权限，使类外部无法再创造对象
public class SingletonDemo {
    public static void main(String[] args) {
        Earth earth = Earth.getEarth();
        System.out.println(earth.getAge());
    }
}

class Earth {
    private static Earth earth = new Earth();
    private int age = 100;
    private Earth() {}
    static Earth getEarth() {
        return earth;
    }

    public int getAge() {
        return age;
    }
}
