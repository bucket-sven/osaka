package com.rela.osaka.design.pattern.behavior;

// 状态模式：允许对象在内部状态发生改变时改变它的行为，对象看起来好像修改了它的类。
// 总结：对象具有多种状态，且每种状态具有特定的行为；应用场景: 行为随状态改变而改变的场景。代码形式似乎也和哪种设计模式相似，还是那句话，设计模式提倡的是思想，而不是形式。
public class StateDemo {
    public static void main(String []args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);
        System.out.println(context.getState());

        StopState stopState = new StopState();
        stopState.doAction(context);
        System.out.println(context.getState());
    }
}

interface State {
    void doAction(Context context);
}

class Context {
    private State state;
    Context() {
        state = null;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}

class StartState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Start State";
    }
}

class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Stop State";
    }
}
