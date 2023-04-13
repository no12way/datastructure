package symboltable;

public class SymbolTable<Key,Value>{
    //属性头节点,不存放数据
    private Node head;
    //计数器,用于记录符号表的元素个数(不包括头节点)
    private int N;
    //节点类,用于存放key和value
    public class Node{
        private Key key;
        private Value value;
        private Node next;
        public Node(Key key,Value value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    //构造方法初始化符号表
    public SymbolTable(){
        //头节点数据滞空
        head = new Node(null,null,null);
        //符号表的长度为0
        this.N = 0;
    }

    /**
     * 向表中追加(在头部追加)键值对
     * @param key
     * @param value
     */
    public void add(Key key,Value value){
        //设置一个指针指向头节点(空数据)
        Node p = head;
        //如果链表中有key的数据,更新value
        while (p.next != null){
            p = p.next;
            if(p.key == key){
                p.value = value;
                return;
            }
        }
        //如果链表中没有key的数据,只要在头节点之后插入就行
        Node newNode = new Node(key, value, null);
        newNode.next = head.next;
        head.next = newNode;
        //元素个数加1
        N++;
    }

    /**
     * 删除key的节点
     * @param key
     */
    public void delete(Key key){
        //设置p指针指向头节点
        Node p = head;
        while (p.next !=null){
            //找到被删除的节点的前一个元素,如果它的下一个节点的key相等
            if(p.next.key.equals(key)){
                //则p的next的指向p下面的下面一个节点
                p.next = p.next.next;
                N--;
                return;
            }
            p = p.next;
        }
    }
    /**
     * 从符号表中获取key对应的value值
     * @param key
     * @return
     */
    public Value get(Key key){
        Node p = head;
        while (p.next != null){
            p = p.next;
            if (p.key.equals(key)){
                return p.value;
            }
        }
        return null;
    }

}
