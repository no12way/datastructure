package test;

import heap.Heap;

public class HeapTest {
    public static void main(String[] args) {
        Heap<String> stringHeap = new Heap<>(7);
        stringHeap.add("A");
        stringHeap.add("B");
        stringHeap.add("C");
        stringHeap.add("D");
        stringHeap.add("E");
        stringHeap.add("F");
        stringHeap.add("G");

        String del;
        while ((del = stringHeap.del()) != null){
            System.out.print(del+" ");
        }
    }
}
