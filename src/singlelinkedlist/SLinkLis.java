package singlelinkedlist;


import javax.print.DocFlavor;
import java.util.Iterator;

//关于单链表的实现,我们把头节点的数据设为空,链表元素放在头节点后面
public class SLinkLis<T> implements Iterable<T>{
    //属性,声明节点
    public Node head;
    //元素个数,N表示元素个数
    public int N;


    //内置一个节点类
    public class Node{
        private T t;
        private Node next;
        public Node(T t,Node next){
            this.t = t;
            this.next = next;
        }

    }
    //对通过外部类构造函数,构造元素节点(初始化头节点)
    public SLinkLis(){
        this.head = new Node(null,null);
        this.N = 0;
    }

    /**
     * 清空链表
     */
    public void clear(){
        head.next = null;
        N = 0;
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * 获取第i个元素
     * @param i
     */
    public T getByIndex(int i){
        //声明一个变量指向头节点
        Node n = head;
        for (int j = 0; j <= i; j++) {
         //节点n的next指向的节点赋给n节点,即n指向n的下一个节点
            n = n.next;
        }
        return n.t;
    }

    /**
     * 添加一个节点,元素为t
     * @param t
     */
    public void add(T t){
        //利用一个指针遍历所有节点,把指针放到最后一个元素,在末尾插入元素
        Node p = head;
        while (p.next != null){
            p = p.next;
        }
        //理解为p此时指向最后一个元素,调用此元素的next属性,把新节点添加到最后
        p.next = new Node(t,null);
        N ++;
    }

    /**
     * 在第i个节点插入元素t
     * @param i
     * @param t
     */
    public void insert(int i,T t){
        //同样的,创建一个引用(指针),然后指向被替换元素的前面一位
        Node p = head;
        for (int j = 0; j < i ; j++) {
            //p指针从头节点开始,头节点我们默认不算链表的索引(也可以默认为-1)
            p = p.next;
        }//此时我们的p指针指向了i之前的一个元素
        //p.next代表第i个元素,新节点的下一个节点指向第i个元素
        Node node = new Node(t, p.next);
        //我们把第i个之前的元素的指向这个插入的新节点
        p.next = node;
        //插入完记得元素个数加1
        N++;
    }
    /**
     * 这里我们删除第i个元素
     * @param i
     */
    public void deleteById(int i){
        //老规矩,声明一个引用(指针),指向头节点
        Node p = head;
        for (int j = 0; j < i; j++) {
            p = p.next;
        }//此时我们找到了第i个节点前一个节点
        //p.next代表第i+1个元素,p.next指向第i+1个元素
        p.next = p.next.next;
        //中间的元素不需要去管
        N--;
    }
    /**
     * 查找元素第一次出现的位置
     * @param t
     */
    public int firstExit(T t){
        //创建一个指针指向头节点
        Node p = head;
        int index = -1;
        //我们把链表全部遍历一遍
        while (p.next != null){
            //指针后移
            p = p.next;
            //index表示索引
            index++;
            if (p.t.equals(t)){
                return index;
            }
        }
        return -1;
    }
    @Override
    public Iterator iterator() {
        return new Iter();
    }
    private class Iter implements Iterator{
        Node p;
        public Iter(){
            //初始化指针指向头节点
            p = head;
        }
        @Override
        public boolean hasNext() {
            //指针的下一位非空的话
            return p.next != null;
        }

        @Override
        public T next() {
            //指针后移,取出元素
            p = p.next;
            return p.t;
        }
    }
    //======================================================
    //增加链表的反转功能

    /**
     * 这里是对单链表反转方法
     */
    public void reverse(){
        Node p = head.next;
        reverseImp(p);
    }

    public void reverseImp(Node current){
        //从第一个元素开始,找到最后一个元素,并把头指针指向最后一个元素,退出
        if (current.next == null){
            head.next = current;
            return;}
        //指针反复后移,直到最后一位
        reverseImp(current.next);
        //想象一下,最后一个数据处理完毕,这里的next是倒数第二个元素
        //current.next代表倒数第一个元素
        current.next.next = current;
        //注意把目前元素的next滞空,否则会造成a.next指向b,b.next指向a的循环
        current.next = null;
    }

}
