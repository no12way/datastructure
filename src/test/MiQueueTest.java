package test;

import heap.MiQueue;

/**
 * 最小优先队列的测试
 */
public class MiQueueTest {
    public static void main(String[] args) {
        MiQueue<String> miQ = new MiQueue<>(8);
        miQ.add("A");
        miQ.add("B");
        miQ.add("C");
        miQ.add("E");
        miQ.add("D");
        miQ.add("H");
        miQ.add("G");
        miQ.add("F");
        while (miQ.getLength() != 0){
            System.out.print(miQ.delMin()+" ");
        }

    }
}
