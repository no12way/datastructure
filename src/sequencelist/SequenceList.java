package sequencelist;


import java.util.Iterator;

public class SequenceList<T> implements Iterable<T> {
    //创建T类型的一个数组
    private T[] sequence;

    //表示元素个数
    int N;

    public SequenceList(int capacity) {
        //初始化数组容量,由于泛型的擦边,先创建一个Object类型的数组,然后强制转换成T类型数组
        sequence = (T[]) new Object[capacity];
        //初始化数组元素为0
        this.N = 0;
    }

    /**
     * 清空数组元素
     */
    public void clear() {
        this.N = 0;
    }

    /**
     * 获取数组的长度
     */
    public int getLength() {
        return N;
    }

    /**
     * 增加元素t
     * @param t
     */
    public void add(T t) {
        //判断数组元素有没有达到最大容量(扩容)
        if(N == sequence.length){
            resize((int)(sequence.length*1.5));
        }
        //把元素增加到数组中去(N++)代表索引,但是N的值增大一(N代表数组元素个数要比真实最大索引大1)
        sequence[N++] = t;
    }
    /**
     * 在索引i的位置插入t元素
     * @param i
     * @param t
     */
    public void insert(int i,T t){
        //先判数组容量是否还有空间,没有则扩容1.5倍
        if(N == sequence.length){
            resize((int)(sequence.length*1.5));
        }
        //把索引i的元素插入到数组中,此时要把后面的每一个元素后移一位
        for (int j = N-1; j >= i; j--) {
            sequence[j+1] = sequence[j];
        }
        sequence[i] = t;
        //元素个数加1
        N++;
    }
    /**
     * 删除指定索引的元素
     * @param i
     */
    public void delete(int i){
        //不需要判断数组是否还有空间,如果不到数组长度的1/4,则容量缩短1/2
        if(N <= sequence.length/4){
            resize(sequence.length/2);
        }
        //之间把数组后面的每个元素前移一位,覆盖掉i处原来的元素
        for (int j = i; j < N-1 ; j++) {
            sequence[j] = sequence[j+1];
        }
        //元素个数减1
        N--;
    }

    /**
     * 查找元素第一次出现的索引
     * @param t
     */
    public int firstExit(T t){
        //遍历,找到第一个索引的位置就跳出
        for (int i = 0; i < N; i++) {
            if(t.equals(sequence[i]))
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * 重置数组的容量
     * @param resize
     */
    public void resize(int resize){

        T[] objects = (T[])new Object[resize];
        for (int i = 0; i < sequence.length; i++) {
            objects[i] = sequence[i];
        }
        sequence = objects;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIter();
    }

    private class SIter implements Iterator{
        int cur;
        public SIter(){
            this.cur = -1;
        }
        //判断cur下一位是否有元素,把指针的后移一位,然后判断有没有超过最大索引
        @Override
        public boolean hasNext() {
            return ++cur <= N-1;
        }

        @Override
        public Object next() {
            return sequence[cur];
        }
    }
}
