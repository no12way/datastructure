package test;

import tree.BinaryTree;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree<Integer, String> Tree = new BinaryTree<>();
        Tree.put(3,"南京");
        Tree.put(1,"苏州");
        Tree.put(2,"泰州");
        String s = Tree.get(3);
        Tree.delete(3);
        String s1 = Tree.get(1);
        String s2 = Tree.get(2);
        System.out.println(s+"|"+s1+"|"+s2);
    }
}
