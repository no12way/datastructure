package test;

import stack.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        stringStack.push("南京");
        stringStack.push("苏州");
        stringStack.push("上海");
        for (Object o : stringStack) {
            System.out.println(o);
        }
        System.out.println(stringStack.N);

    }
}
