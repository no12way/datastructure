package test;

import queue.Queue;

//对列的测试
public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> integerQueue = new Queue<>();
        integerQueue.add(1);
        integerQueue.add(2);
        integerQueue.add(3);
        for (Object o : integerQueue) {
            System.out.println(o);
        }
        System.out.println("==================================================");
        System.out.println(integerQueue.get());
        System.out.println(integerQueue.get());
        System.out.println(integerQueue.get());
        System.out.println(integerQueue.get());
    }
}
