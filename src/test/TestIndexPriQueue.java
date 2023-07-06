package test;

import queue.IndexMinPriorityQueue;

public class TestIndexPriQueue {
    public static void main(String[] args) {
        IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<String>(5);
        queue.insert(0,"A");
        queue.insert(1,"C");
        queue.insert(2,"D");
        queue.change(2,"B");
        queue.insert(3,"E");
        queue.insert(4,"G");

        while (queue.getLength()!= 0){
            System.out.print(queue.delByIndex(queue.minIndex())+" ");
        }
    }
}
