package test;

import queue.Queue;
import tree.BinaryTree;

public class TestTreeScan {
    public static void main(String[] args) {
        BinaryTree<String, String> tree = new BinaryTree<>();
        //往树中添加数据
        tree.put("E", "5");
        tree.put("B", "2");
        tree.put("G", "7");
        tree.put("A", "1");
        tree.put("D", "4");
        tree.put("F", "6");
        tree.put("H", "8");
        tree.put("C", "3");
        Queue<String> stringQueue = tree.preScan();
        System.out.println("先序遍历");
        for (Object o : stringQueue) {
            System.out.print(o+" ");
        }
        System.out.println("=====================");
        Queue<String> midScan = tree.midScan();
        System.out.println("中序遍历");
        for (Object o : midScan) {
            System.out.print(o+" ");
        }
        Queue<String> lastScan = tree.lastScan();
        System.out.println("=====================");
        System.out.println("后续遍历");
        for (Object o : lastScan) {
            System.out.print(o+" ");
        }
        System.out.println("=====================");
        String min = tree.min();
        System.out.println(min);
        String max = tree.max();
        System.out.println(max);
        System.out.println("深度=================================");
        System.out.println(tree.getDepth());

    }
}
