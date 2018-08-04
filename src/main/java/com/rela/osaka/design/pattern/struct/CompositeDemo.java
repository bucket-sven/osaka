package com.rela.osaka.design.pattern.struct;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


// 组合模式：将对象组合成树形结构以表示"部分-整体"的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。
// 总结：创建了一个包含自己对象组的类，并提供修改对象组的方法。应用场景，如树形菜单，文件、文件夹的管理。
public class CompositeDemo {
    public static void main(String[] args) {
        Node noder = new Noder("/Users/sven/kotlin");
        try {
            createTree(noder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        noder.display();
    }
    static void createTree(Node node) throws Exception {
        File file = new File(node.name);
        File[] f = file.listFiles();
        for (File fi : f) {
            if (fi.isFile()) {
                Filer filer = new Filer(fi.getAbsolutePath());
                node.addNode(filer);
            }
            if (fi.isDirectory()) {
                Noder noder = new Noder(fi.getAbsolutePath());
                node.addNode(noder);
                createTree(noder);
            }
        }
    }
}

abstract class Node {
    protected String name;
    Node(String name) {
        this.name = name;
    }

    void addNode(Node node) throws Exception {
        throw new Exception("Invalid Exception");
    }

    abstract void display();
}

class Filer extends Node {
    Filer(String name) {
        super(name);
    }

    @Override
    void display() {
        System.out.println(name);
    }
}

class Noder extends Node {
    List<Node> nodeList = new ArrayList<Node>();
    Noder(String name) {
        super(name);
    }

    void addNode(Node node) throws Exception {
        nodeList.add(node);
    }

    @Override
    void display() {
        System.out.println(name);
        for (Node node : nodeList) {
            node.display();
        }
    }
}
