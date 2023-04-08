package doublylinkedlist;

import java.util.Iterator;

//双向链表的数据结构
public class DouLikList<T> implements Iterable{
    //头指针,创建头节点,并把头指针指向它
    public Node head;
    //N用于计算元素的个数
    public int N;
    //尾指针,指向最后一个元素
    public Node last;


    //节点类,用于储存数据,指向上一个或下一个数据
    public class Node{
        public Node pre;
        public T t;
        public Node next;
        public Node(Node pre,T t,Node next){
            this.pre = pre;
            this.t = t;
            this.next = next;
        }
    }
    //在创建DouLinklist对象时会自动调用无参构造,默认创建一个不带数据的头节点,属性head指向它
    public DouLikList(){
        this.head = new Node(null,null,null);
        this.last = null;
        this.N = 0;
    }

    /**
     * 清空双向链表
     */
    public void clear(){
        //头节点的下一位滞空,考虑到last指向尾节点,我们把尾节点滞空,同时,用于计数的N设为0
        head.next = null;
        last = null;
        N = 0;
    }

    /**
     * 获取链表的长度
     * @return
     */
    public int getLength(){
        return N;
    }

    /**
     * 获取第一个元素
     * @return
     */
    public T getFirst(){
        if(head.next == null){
            return null;
        }
        return head.next.t;
    }
    /**
     * 获取最后一个元素
     * @return
     */
    public T getLast(){
        if (head.next == null){
            return null;
        }
        return last.t;
    }
    /**
     * 把元素追加到链表尾部
     * @param t
     */
    public void add(T t){
        //这里创建一个临时变量(指针),指向头节点
        Node p = head;
        //循环走完,p会指向最后一个元素
        while (p.next != null){
            p = p.next;
        }
        //这一步我们把新节点的pre设为p
        Node node = new Node(p, t, null);
        //把p的下一位指向,被追加的元素
        p.next = node;
        //末指针指向node
        last = node;
        N++;
    }
    /**
     * 在第i个元素的位置上插入t
     * @param i
     * @param t
     */
    public void insert(int i,T t){
        //设置一个p变量(指针)指向head(头节点),(头节点不放数据),可以理解为索引的-1
        Node p = head;
        //在这个for循环中,我们把p指针移动到i前一位
        for (int j = 0; j < i; j++) {
            p = p.next;
        }
        if(i >N-1 ){
            add(t);
        }else {
        //创建出需要插入的节点node
        Node node = new Node(null, t, null);
        //让i+1元素前驱指向被插入元素node
        p.next.pre = node;
        //让被插入元素node前一位指向第i位前一位元素
        node.pre = p;
        //被插入元素node的后驱指向i后一位的元素
        node.next = p.next;
        //第i位前一位元素后驱指向node
        p.next = node;
        N++;
        }
    }

    /**
     * 获取第i个元素
     * @param i
     * @return
     */
    public T getIndex(int i) {
        Node p = head;
        for (int j = 0; j <= i; j++) {
            //让p指向它的下一个节点
            p = p.next;
        }
        return p.t;
    }

    /**
     * 找到t元素第一次出现的位置
     * @param t
     * @return
     */
    public int firstExit(T t){
        Node p = head;
        int i = 0;
        while (p.next != null){
            //后移同时刷新计数器
            p = p.next;
            i++;
            //每后移一次,比较一下元素是否相等
            if(p.t.equals(t)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除第i个元素
     * @param i
     * @return
     */
    public T deleteIndex(int i){
        Node p = head;
        for (int j = 0; j < i; j++) {
            p = p.next;
        }
        if (i < N-1) {
            //取出删除节点的元素
            Node forDelete = p.next;
            //p.next.next表示i后面一位的元素
            Node node = p.next.next;
            //p.next指向被删除后一位的节点
            p.next = node;
            //被删除后一位的节点前驱指向p
            node.pre = p;
            N--;
            return forDelete.t;
        }
        //此时p指向第i-1位元素
        if (i == N-1){
            //取出删除的节点
            Node forDelete = p.next;
            p.next = null;
            //此时我们要把尾指针指向最后一个元素
            last = p;
            N--;
            return forDelete.t;
        }
        return null;
    }
    //对迭代器进行实现
    @Override
    public Iterator iterator() {
        return new Iter();
    }
    private class Iter implements Iterator{
        //设置一个临时指针
        Node p;
        public Iter(){
            p = head;
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
