package heap;

import java.util.IllegalFormatCodePointException;

//堆的index从1开始,左右子树大小不做固定排位
//泛型T继承comparable接口,使得元素t可以进行比较
public class Heap<T extends Comparable<T>> {
    //堆的元素个数
    private int N;
    //堆的内置数组
    private T[] item;

    //通过构造函数,对数组进行初始化,capacity+1是因为堆的第一个元素的index是从1开始的
    public Heap(int capacity){
        this.item = (T[])new Comparable[capacity+1];
        this.N = 0;
    }

    //将堆底层结构数组的index i 和 j 进行比较.返回类型为boolean

    /**
     * 实现i和j处索引的元素的大小比较
     * @param i
     * @param j
     * @return
     */
    public boolean greater(int i,int j){
        return item[i].compareTo(item[j])> 0;
    }

    /**
     * 实现元素索引i和j处的元素互相交换
     * @param i
     * @param j
     */
    public void exchange(int i, int j){
        T temp;
        temp = item[i];
        item[i] = item[j];
        item[j] = temp;
    }

    /**
     * 对k元素的位置进行上浮算法,使得k能找到自己合适的位置
     * @param k
     */
    public void swim(int k){
        //如果k大于1的化,和父节点进行比较
        while(k > 1){
            //把子节点和父节点比较
            if (greater(k,k/2)) {
                //如果子节点的值大于父节点的值,就将两个点的值互换
                exchange(k,k/2);
                //只有进行互换了才能进行下次比较
                k = k/2;
            }else {
                //否则跳出比较
                break;
            }
        }
    }

    /**
     * 下沉算法将节点k和子节点比较大的比较(只要比其中一个元素小)
     * @param k
     */
    public void sink(int k){
        //用max来接收较大值的索引
        int max = 0;
        //如果2k小于n表示有左子节点
        while (2*k <= N){
            //此时表示该节点有右子节点
            if(2*k+1 <= N){
                max = greater(2*k,2*k + 1) ? 2*k : 2*k+1;
                if(greater(max,k)){
                    exchange(max,k);
                }
                //否则确定k的位置
                else {break;}
            }
            //如果没有右子节点
            else {
                if(greater(2*k , k)){
                    exchange(2*k , k);
                }
                //否则确定k的位置
                else {break;}
            }
            k = 2*k;

        }


    }

    /**
     * 向栈中追加元素
     * @param t
     * @return
     */
    public void add(T t){
        //这里的意思是元素个数加一的同时
        //因为堆是从下标为一开始的,N同时也表示最后一个元素的索引
        item[++N] = t;
        //使用上浮方法确定元素t的位置
        swim(N);
    }

    /**
     * 从堆中删除最大元素(我们把最后一个元素的位置放到被删除元素的位置)
     *
     */
    public T del(){
        //把末尾元素放到第一个节点
        //同时删除末尾节点,元素个数减一
        T max = item[1];
        item[1] = item[N];
        item[N--] = null;
        sink(1);
        return max;
    }


}
