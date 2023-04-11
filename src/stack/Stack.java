package stack;

import java.util.Iterator;

public class Stack<T> implements Iterable{
    //设置头节点(不存放数据)
    private Node head;
    //设置计数器,计算栈中元素个数
    public int N;
    public class Node{
        T t;
        Node next;
        public Node(T t, Node next){
            this.t = t;
            this.next = next;
        }
    }

    public Stack(){
        head = new Node(null,null);
        N = 0;
    }

    /**
     * 把元素从栈中拿出
     * @return
     */
    public T pop(){
        //如果第一个元素存在
        if(head.next != null){
            //取出头节点后面的第一个元素
            Node first = head.next;
            head.next = first.next;
            N--;
            return first.t;
        }
        return null;
    }

    /**
     * 把元素压入栈
     * @param t
     * @return
     */
    public T push(T t){
        //创建要入栈的元素
        Node node = new Node(t, null);
        //拿到头节点后面一个元素
        Node second = head.next;
        //要插入的元素的下一个指向原来第一个元素
        node.next = second;
        //头节点指向要插入的元素
        head.next = node;
        N++;
        return t;
    }
    @Override
    public Iterator iterator() {
        return new Iter();
    }
    private class Iter implements Iterator{
        Node p = head;

        @Override
        public boolean hasNext() {
            return p.next != null;
        }

        @Override
        public Object next() {
            p = p.next;
            return p.t;
        }
    }

}
