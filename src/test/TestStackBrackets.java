package test;

import stack.Stack;

public class TestStackBrackets {
    public static void main(String[] args) {
        String test = "((南京)是江苏的省会)";
        System.out.println("字符串中括号是否格式是否正确:"+isMatch(test));
    }
    public static boolean isMatch(String str){
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            String chr = String.valueOf(str.charAt(i));
            if(chr.equals("(")){
                stringStack.push(chr);
            }
            if (chr.equals(")")){
                String pop = stringStack.pop();
                if (pop == null){
                    return false;
                }
            }
        }
        if (stringStack.N == 0){
        return true;
        }
        else {
            return false;
        }
    }
}
