package queue;

import java.util.Iterator;

//利用链表实现队列逻辑
public class Queue<T> implements Iterable{
    //创建头节点
    public Node head;
    //创建尾节点
    public Node last;
    //计数器,用于返回队列中元素个数(不包含头节点)
    public int N;

    //创建节点类
    public class Node{
        public T t;
        public Node next;
        public Node(T t,Node next){
            this.t = t;
            this.next = next;
        }
    }
    //创建队列对象的同时初始化头节点和N
    public Queue(){
        this.head = new Node(null,null);
        this.last = null;
        this.N = 0;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * 返回队列中的元素
     * @return
     */
    public int getLength(){
        return N;
    }

    /**
     * 向队列中追加元素
     * @param t
     * @return
     */
    public T add(T t){
        if (last == null){
            head.next = new Node(t,null);
            last = head.next;
        }else {
           last.next = new Node(t,null);
           //last后移一位
           last = last.next;
        }
        N++;
        return last.t;
    }
    //从队列中拿出元素
    public T get(){
        //当链表中只有一个元素的时候
        if (N == 1){
            Node p = last;
            last = null;
            N--;
            return p.t;
        }
        //当链表中有多个元素的时候
        if (N > 1){
            //把删除的元素取出来
            Node temp = head.next;
            //head节点指向下一个元素
            head.next = temp.next;
            N--;
            return temp.t;
        }
        else {
            return null;
        }
    }
    @Override
    public Iterator iterator() {
        return new Iter();
    }
    //内部类
    private class Iter implements Iterator{
        private Node p;
        public Iter(){
            this.p = head;
        }

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
