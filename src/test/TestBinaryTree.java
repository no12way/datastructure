package test;

import tree.BinaryTree;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree<Integer, String> Tree = new BinaryTree<>();
        Tree.put(3,"南京");
        Tree.put(1,"苏州");
        Tree.put(2,"泰州");
        Tree.put(4,"常州");
        String s = Tree.get(1);
        Tree.delete(1);
        String s3 = Tree.get(3);
        String s2 = Tree.get(2);
        String s4 = Tree.get(4);
        System.out.println(s+"|"+s2+"|"+s3+"|"+s4);
    }
}
