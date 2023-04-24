package test;


import tree.BinaryTree;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.put(3,"南京");
        tree.put(1,"苏州");
        tree.put(2,"泰州");
        tree.put(4,"常州");
        String s = tree.get(1);
        tree.delete(1);
        String s3 = tree.get(3);
        String s2 = tree.get(2);
        String s4 = tree.get(4);
        System.out.println(s+"|"+s2+"|"+s3+"|"+s4);


    }
}
