package queue;

/**
 * 最小索引优先队列
 */
public class IndexMinPriorityQueue<T extends Comparable<T>>{
    //用于存放元素,index从0开始
    //元素除增删不需要动
    private T[] items;
    //用于存放items中记录元素的索引,堆结构排序
    //通过修改pq,修改qp达到快速定位的目的
    private int[] pq;
    //用于存放pq中的元素,也就是item中的索引
    private int[] qp;
    //记录堆元素中的个数
    private int N;

    //通过构造函数来确定三个数组中的容量
    public IndexMinPriorityQueue(int capacity){
        //index从0开始
        this.items = (T[])new Comparable[capacity];
        //index从1开始
        this.pq = new int[capacity+1];
        //index从0开始
        this.qp = new int[capacity];
        //初始化元素个数
        this.N = 0;

        //让qp中元素都为-1
        for (int i = 0; i < qp.length; i++) {
            qp[i] = -1;
        }
    }

    /**
     * 返回元素个数
     * @return
     */
    public int getLength(){
        return N;
    }

    /**
     * 判断元素个数(优先队列)是否为空
     * @return
     */
    public boolean isEmpty(){
        return N==0;
    }

    /**
     * 判断堆中的第i和第j个元素的大小关系
     * @param i
     * @param j
     * @return
     */
    public boolean greater(int i,int j){
        //pq中的元素存放的是item中的索引
        return items[pq[i]].compareTo(items[pq[j]]) >= 0;
    }

    /**
     * 交换堆中index为i和index为j的元素
     * @param i
     * @param j
     */
    public void exchange(int i,int j){
        //交换pq中元素的位置
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        //更新qp中元素的数据
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    /**
     * 判断元素是否存在
     * @param i
     * @return
     */
    boolean contain(int i){
       return qp[i] != -1;
    };

    /**
     * 返回堆的最小元素关联索引
     * @return
     */
    public int minIndex(){
        return pq[1];
    };

    /**
     * 向item中插入元素
     * @param i
     * @param t
     */
    public void insert(int i,T t){
        if(contain(i)){
            return;
        }
        //元素个数+1
        N++;
        //元素存储在item的i处
        items[i] = t;
        //i存在pq中
        pq[N] = i;
        //把pq逆序存在qp中
        qp[i] = N;
        //通过上浮完成堆调整
        swim(N);
    }

    /**
     * 删除堆中的最小元素,返回索引
     * @return
     */
    public int delMin(){
        //获取最小索引
        int min = pq[1];
        //处理堆中的元素
        exchange(1,N);
        //删除item中元素
        items[min] = null;
        //qp中元素为-1
        qp[pq[1]] = -1;
        //pq中被置换的元素值为-1
        pq[N] = -1;
        //个数减一
        N--;
        sink(1);
        return min;
    }

    /**
     * 删除索引i对应的元素
     * @param i
     * @return
     */
    public T delByIndex(int i){
        //如果不存在索引index对应值,返回null
        if(!contain(i)){
            return null;
        }
        //找到pq中对应的元素index
        int num = qp[i];

        T t = items[i];

        exchange(num,N);
        qp[pq[N]] = -1;
        pq[N] = -1;

        items[i] = null;
        N--;
        //堆调整
        swim(num);
        sink(num);
        return t;
    }

    /**
     * 修改索引i位置的元素为t
     * @param t
     * @param i
     */
    public void change(int i,T t){
        //修改items中的元素
        items[i] = t;
        int i1 = qp[i];
        swim(i1);
        sink(i1);
    }
    //上浮算法,让索引在一个正确的位置
    public void swim(int k){
        while (k>1){
            if (greater(k/2,k)){
                exchange(k/2,k);
            }
            k = k/2;
        }

    }

    public void sink(int k){
        //存在左子节点
        while (2*k <= N){
            int min = 0;
            //存在右子节点,找到较小的节点的索引
            if(2*k+1 <= N){
                min = greater(2*k,2*k+1)? 2*k+1 : 2*k ;
            }else {
                min = 2*k ;
            }
            if (!greater(k,min)){
                break;
            }else{
                exchange(k,min);
                k = min;
            }



        }



    }


}
