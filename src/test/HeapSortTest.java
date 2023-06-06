package test;

import heap.Heap;
import heap.HeapSort;

//关于堆排序的
public class HeapSortTest {
    public static void main(String[] args) {
        Comparable[] comparables = new Comparable[]{1,8,3,6,8,2,3,6,8,22,11,31,12};
        HeapSort.sort(comparables);
        for (Comparable comparable : comparables) {
            System.out.print(comparable+" ");
        }
    }
}
