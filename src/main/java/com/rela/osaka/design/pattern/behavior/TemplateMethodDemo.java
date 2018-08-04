package com.rela.osaka.design.pattern.behavior;

// 模板方法模式：定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
// 总结：将一些固定步骤、固定逻辑的方法封装成模板方法。调用模板方法即可完成那些特定的步骤。例如，spring中对Hibernate的事务管理，开启session、关闭session等固定步骤不需重复写，直接丢给一个实体保存。
public class TemplateMethodDemo {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
    }
}

abstract class Game {
    abstract void init();
    abstract void startPlay();
    abstract void endPlay();

    final void play() {
        init();
        startPlay();
        endPlay();
    }
}

class Cricket extends Game {
    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void init() {
        System.out.println("Cricket Game Init! Start Playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy!");
    }
}