package heap;

//对堆排序的实现
public class HeapSort {

    /**
     * 判断堆heap中i和j元素的大小,返回类型为boolean
     * @param heap
     * @param i
     * @param j
     * @return
     */
    public static boolean greater(Comparable[] heap,int i,int j){
        return heap[i].compareTo(heap[j]) > 0;
    }

    /**
     * 交换堆heap中索引下标为i和j的元素的值
     * @param heap
     * @param i
     * @param j
     */
    public static void exchange(Comparable[] heap,int i,int j) {
        Comparable temp;
        temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;

    }

    /**
     * 对堆元素的target位进行下沉算法,使其找到正确的位置,保证第一位是最大的元素,也是保证整个堆从开始的target到range位置的元素是合理摆放的
     * @param heap
     * @param target
     * @param range
     */
    public static void sink(Comparable[] heap,int target,int range){
            //判断target位元素有没有超过当前堆的范围,其实也就是看它有没有子节点
            while(2*target <= range){
                //max是用来确定target位下一层的元素的最大元素的位置
                int max;
                //如果这个target元素有右子节点
                if(2*target+1 <= range){
                    max = greater(heap,2*target,2*target+1) ? 2*target : 2*target+1;

                }else {
                    max = 2*target;
                }

                //如果下面的节点的最大的比target节点还大,就交换位置
                if(greater(heap, max, target)){

                    exchange(heap,target,max);
                    //交换位置后要把原来target元素的位置已经变换了
                    target = max;

                }else {
                    //如果没有交换位置,那么这个元素已经在这个堆中处于合适的位置
                    break;
                }

            }

}

    /**
     * 把无序的source数组变为半有序的heap堆
     * @param source
     * @param heap
     */
    public static void createHeap(Comparable[] source,Comparable[] heap){
        //把source下的元素全部拷贝到搜heap堆中,从heap堆的索引1处开始
        System.arraycopy(source,0,heap,1,source.length);

        //把堆中从倒数第二排 length/2 开始下沉算法,此时堆已经完成初步排序
        for (int i = heap.length/2 ;  i > 0 ; i -- ) {
            sink(heap,i, heap.length-1);
        }

}

    /**
     * 这里对
     * @param source
     */
   public  static  void sort(Comparable[] source){
       //因为堆的底层结构是数组,但是堆的下标是从1开始,所以堆的容量是source的容量加1,这一步创建了一个堆
    Comparable[] heap = new Comparable[source.length+1];
    //我们将数组的数据拷贝到堆里,并且执行粗略排序(使其成为堆的结构)
       createHeap(source,heap);
       //N代表heap,堆元素的数量
       int N = source.length;

       while (N != 1){
           //交换下标为1和最大索引处的位置
           exchange(heap,1,N);

            sink(heap,1,N - 1);
            //堆的个数减去1
            N -- ;


       }
        System.arraycopy(heap,1,source,0,heap.length-1);




   }








}
