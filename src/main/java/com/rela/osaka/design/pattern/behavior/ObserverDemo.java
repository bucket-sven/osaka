package com.rela.osaka.design.pattern.behavior;

import java.util.ArrayList;
import java.util.List;

// 观察者模式：定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
// 总结：一个对象（被观察者）状态变化时，通知所有依赖于它的对象（观察者）；这种依赖方式具有双向性：观察者指定被观察的对象，或者被观察对象添加观察者，下面例子采用后者方式
public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new Observer1(subject);
        new Observer2(subject);
        subject.setState(1);
        subject.setState(10);
    }
}

class Subject {
    private List<SubjectObserver> subjectObservers = new ArrayList<>();
    int state;

    void setState(int state) {
        this.state = state;
        notifyAllSubjectObservers();
    }

    void addSubjectObserver(SubjectObserver subjectObserver) {
        this.subjectObservers.add(subjectObserver);
    }

    void notifyAllSubjectObservers() {
        for (SubjectObserver so : subjectObservers) {
            so.update();
        }
    }
}

abstract class SubjectObserver {
    protected Subject subject;
    abstract void update();
}

class Observer1 extends SubjectObserver {
    Observer1(Subject subject) {
        this.subject = subject;
        this.subject.addSubjectObserver(this);
    }

    @Override
    void update() {
        System.out.println("Observer1: subject updated. state = " + subject.state);
    }
}

class Observer2 extends SubjectObserver {
    Observer2(Subject subject) {
        this.subject = subject;
        this.subject.addSubjectObserver(this);
    }

    @Override
    void update() {
        System.out.println("Observer2: subject updated. state = " + subject.state);
    }
}
