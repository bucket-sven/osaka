package com.rela.osaka.design.pattern.behavior;

import java.util.ArrayList;
import java.util.List;

// 备忘录模式：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。
// 总结：创建一个备忘录类，用来存储原始类的信息；同时创建备忘录仓库类，用来存储备忘录类，当然，原始类与备忘录类的对应关系要处理好。
public class MementoDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("123");
        System.out.println("初始化状态: " + originator.getState());
        MementoStorage mementoStorage = new MementoStorage();
        mementoStorage.add(originator.createMemento());
        originator.setState("321");
        System.out.println("修改后的状态: " + originator.getState());
        originator.restoreMemento(mementoStorage.get(0));
        System.out.println("还原后的状态: " + originator.getState());
    }
}

class Memento {
    private String state;
    Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class MementoStorage {
    private List<Memento> mementoList = new ArrayList<>();
    void add(Memento memento) {
        mementoList.add(memento);
    }

    Memento get(int index) {
        return mementoList.get(index);
    }
}

class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    Memento createMemento() {
        return new Memento(state);
    }

    void restoreMemento(Memento memento) {
        state = memento.getState();
    }
}
