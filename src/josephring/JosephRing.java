package josephring;

public class JosephRing {
    public static void main(String[] args) {
        //创建7个节点
        Node<Integer> i1 = new Node<>(1, null);
        Node<Integer> i2 = new Node<>(2, null);
        Node<Integer> i3 = new Node<>(3, null);
        Node<Integer> i4 = new Node<>(4, null);
        Node<Integer> i5 = new Node<>(5, null);
        Node<Integer> i6 = new Node<>(6, null);
        Node<Integer> i7 = new Node<>(7, null);
        //把7个节点连接起来
        i1.next = i2;
        i2.next = i3;
        i3.next = i4;
        i4.next = i5;
        i5.next = i6;
        i6.next = i7;
        //在此处形成闭环
        i7.next = i3;
        boolean circle = isCircle(i1);
        System.out.println(circle);
        System.out.println("=============================================");
        int gate = gate(i1);
        System.out.println(gate);
        System.out.println("约瑟夫环问题==============================================");
//================================================================方法1
        //指针first,指向头节点
        Node<Integer> first = null;
        //指针p,指向前一个节点
        Node<Integer> p = null;
        for (int i = 1; i <= 41 ; i++) {
            if (i == 1){
                //创建头节点,并且把p指向头节点
                first = new Node<>(i,null);
                p = first;
                continue;
            }
            //如果不是第一个节点
            //创建一个新节点
            Node<Integer> newNode = new Node<>(i, null);
            //因为p指向新节点的前一个节点
            p.next = newNode;
            //p指针后移
            p = p.next;
            //如果是第41个节点,就把下一位设为1形成循环
            if(i == 41){
                newNode.next = first;
            }
        }
//==========================================================解决约瑟夫环问题
        //p1指针从头指针开始,顺序后移
        Node p1 = first;
        //pre1指向当前节点的前一个节点
        Node pre1 = null;
        int count = 1;
        while (p1.next != p1){
            //表示p1当前的位置
            if(count == 3){
                //pre1指向的元素即前一个元素指向p1下一个元素(完成元素的删除)
                Object remove = p1.t;
                pre1.next = p1.next;
                //输出此时被淘汰的点
                System.out.print(remove+" ");
                //p1指针后移,后移之后其实p1指针指在第一个元素的位置
                p1 = p1.next;
                count = 1;
            }
            if(count != 3){
                //pre1指针指向p指针指向的元素
                pre1 = p1;
                //p1指针后移一位
                p1 = p1.next;
                //count的初始值是1,表示p1从第一个节点开始,没后移一次count+1
                //count != 3时,p1后移一次,count+1
                count++;
            }

        }
        //输出最后一个元素
        System.out.println(p1.t);

    }

//=======================================================================方法(2)
    /**
     * 创建约瑟夫环
     */
    public static Node<Integer> create(){
        Node<Integer> head = new Node<>(1,null);
        int i = 2;
        Node second = createImp(head, i);
        head.next = second;
        return head;
    }
    /**
     * 创建从第2个元素指向后一个元素的节点,一直指向41号元素,把41号元素指向1号元素就是头节点
     * 通过递归创建约瑟夫环
     */
    public static Node createImp(Node<Integer> head,int i){
        //如果是第41个元素,会创建一个尾节点
        if (i == 4){
            return new Node<>(41, head);
        }
        createImp(head,i+1);
        return new Node<Integer>(i,createImp(head,i+1));
    }
//===========================================================================================
    /**
     * 通过快慢指针找到环的入口节点
     * @param first
     * @return
     */
    //Node<Integer>表示参数中的泛型只能是Integer类型的
    public static int gate(Node<Integer> first){
        Node p = first;
        //快慢指针同时从头节点开始走
        //快指针,每次走两步
        Node fast = first;
        //慢指针,每次走一步
        Node slow = first;
        //定义一个计数器,代表第几个元素时环形入口
        int count = 1;
        //快指针不能为空,且快指针的下一位不能为空(假想一下,快指针后两位为空,后一位不为空)
        while (fast != null && fast.next != null){
            //快指针后移两步
            fast = fast.next.next;
            //慢指针后移一步
            slow = slow.next;
            if (fast.t.equals(slow.t)){
                //当快慢指针指向同一个位置时,停止循环
                break;
            }
        }
        //当快慢指针指向同一个位置,并且此时p指针从头节点(存放数据)开始,每次后移一位,当p和slow相遇的地方就是环入口(公理)
        //假设第一个元素是入口,直接返回count,假设第一个不是p,slow后移,count代表p所在节点的位置
        while (p != slow){
            p = p.next;
            slow = slow.next;
            count++;
        }
        return count;
    }
//================================================================================================
    /**
     * 判断链表是否是闭环,first代表第一个节点(并且存放数据)
     * @param first
     * @return
     */
    public static boolean isCircle(Node<Integer> first){
        //快慢指针同时从头节点开始走
        //快指针,每次走两步
        Node fast = first;
        //慢指针,每次走一步
        Node slow = first;
        //快指针不能为空,且快指针的下一位不能为空(假想一下,快指针后两位为空,后一位不为空)
        while (fast != null && fast.next != null){
            //快指针后移两步
            fast = fast.next.next;
            //慢指针后移一步
            slow = slow.next;
            if (fast.t.equals(slow.t)){
                return true;
            }
        }
        return false;
    }
 //==========================================================================================================
    //创建一个数据节点(内部类可以看作一个类成员)
    public static class Node<T>{
        private T t;
        private Node next;
        public Node(T t,Node next){
            this.t = t;
            this.next = next;
        }
    }
}
