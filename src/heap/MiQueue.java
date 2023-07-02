package heap;

public class MiQueue<T extends Comparable<T>> {
    //指定最小优先队列使用的数组
    private T[] item;
    //记录队列中元素个数
    private int N;
    public  MiQueue(int capacity){
        //由于堆的实现是数组,数组第一个元素不存值,那么容量要+1
        this.item = (T[]) new Comparable[capacity+1];
        //初始长度为0
        this.N = 0;
    }

    /**
     * 比较数组里两个元素的大小
     * @param i
     * @param j
     * @return
     */
    public boolean greater(int i,int j){
        return  item[i].compareTo(item[j]) > 0;
    }

    /**
     * 交换数组位置i,j的元素
     * @param i
     * @param j
     */
    public void exchange(int i, int j){
        T temp = item[i];
        item[i] = item[j];
        item[j] = temp;

    }

    /**
     * 堆结构下沉,把大的元素下沉,当前元素大于子树中最小的元素,就下沉
     * @param i
     */
    public void sink (int i){
        //记录最子树中最小的元素
        int min = 0;
        //当存在子树的时候
        while(2*i <= N){
            //存在右子树
            if(2*i+1 <= N){
                min = greater(2*i,2*i+1) ? 2*i+1 : 2*i;
            }else{
                min = 2*i;
            }
            //比较当前节点和子节点大小
            if(greater(i,min)){
                //如果当前节点大于树子节点的最小值
                exchange(i,min);
                i = min;
            }else {
                break;
            }
        }

    }

    /**
     * 上浮算法,把新插入的元素上浮到合适位置
     * 规则:如果i/2的元素大于当前节点,那么交换位置
     * @param i
     */
    public void swim (int i){
        while (i/2 >= 1){
            if(greater(i/2,i)){
                exchange(i/2,i);
                i = i/2;
            }else {
                break;
            }
        }


    }

    public int getLength(){
        return N;
    }

    /**
     * 向堆中插入新元素
     * @param t
     */
    public void add(T t){
        item[N+1] = t;
        //堆中的元素个数加1
        N++;
        //新增的元素的索引是N
        swim(N);
    }

    /**
     * 删除最小的值并返回
     * @return
     */
    public T delMin(){
        //把第删除的元素取出来
        T t = item[1];
        //交换第一个元素和最后一个元素
        exchange(1,N);
        //让最后一个元素为空
        item[N] = null;
        //元素个数减去1
        N--;
        //元素下沉
        sink(1);
        //返回t
        return t;

    }



}
