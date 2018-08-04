package com.rela.osaka.design.pattern.construct;

// 原型模式：用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
// 总结：将对象复制了一份并返还给调用者，对象需继承Cloneable并重写clone()方法
public class PrototypeDemo implements Cloneable {
    private String message = "hello";

    @Override
    protected Object clone() throws CloneNotSupportedException {
        PrototypeDemo prototype = (PrototypeDemo)super.clone();
        prototype.message += " world!";
        return prototype;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypeDemo p = (PrototypeDemo)new PrototypeDemo().clone();
        System.out.println(p.message);
    }
}
