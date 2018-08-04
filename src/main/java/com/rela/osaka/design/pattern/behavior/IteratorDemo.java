package com.rela.osaka.design.pattern.behavior;

// 迭代器模式：提供一种方法顺序访问一个聚合对象中各个元素, 而又无须暴露该对象的内部表示。
// 总结：Java中的iterator的简单实现原理。将聚合类中遍历各个元素的行为分离出来，封装成迭代器，让迭代器来处理遍历的任务；使简化聚合类，同时又不暴露聚合类的内部。
public class IteratorDemo {
    public static void main(String args[]) {
        NameRepository nameRepository = new NameRepository();
        for (Iterator iter = nameRepository.getIterator(); iter.hasNext();) {
            String name = (String)iter.next();
            System.out.println("name : " + name);
        }
    }
}

interface Iterator {
    boolean hasNext();
    Object next();
}

interface Container {
    Iterator getIterator();
}

class NameRepository implements Container {
    String names[] = { "Robert", "John", "Julie", "Lora" };
    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}