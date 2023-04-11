package test;

import stack.Stack;

//逆波兰表达式的测试
public class TestRePolNotation {
    public static void main(String[] args) {
        String[] notation = new String[]{"18","9","/","7","+","3","/"};
        System.out.println(rePol(notation));
    }
    public static Integer rePol(String[] notation){
        Stack<Integer> integerStack = new Stack<>();
        //用来接收最后结果
        int res = 0;
        //遍历字符串数组
        for (int i = 0; i < notation.length; i++) {
            //从栈中取出倒数第一个元素
            Integer o1;
            //从栈中取出倒数第二个元素
            Integer o2;
            //最终的结果
            Integer result;
            String str = notation[i];
            switch (str){
                    //如果是＋号,就把两个元素相加
                case "+":
                    o1 = integerStack.pop();
                    o2 = integerStack.pop();
                    result = o1+o2;
                    integerStack.push(result);
                    break;
                //如果是-号,就把两个元素减
                case "-":
                    o1 = integerStack.pop();
                    o2 = integerStack.pop();
                    //注意,o1是倒数第一个元素,也就是减项
                    //注意,o2是倒数第一个元素,也就是被减项
                    result = o2-o1;
                    integerStack.push(result);
                    break;
                //如果是*号,就把两个元素相加
                case "*":
                    o1 = integerStack.pop();
                    o2 = integerStack.pop();
                    result = o1*o2;
                    integerStack.push(result);
                    break;
                //如果是/号,就把两个元素相加
                case "/":
                    o1 = integerStack.pop();
                    o2 = integerStack.pop();
                    //注意,o1是倒数第一个元素,也就是除项
                    //注意,o2是倒数第一个元素,也就是被除项
                    result = o2/o1;
                    integerStack.push(result);
                    break;
                    //如果不是符号,就把元素压入栈中
                default:
                    //先将元素转为int类型
                    int intI = Integer.parseInt(str);
                    integerStack.push(intI);
                    break;
            }
        }
        res = integerStack.pop();
        return res;
    }
}
