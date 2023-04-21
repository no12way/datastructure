package tree;

public class BinaryTree<Key extends Comparable,Value> {
    //根节点
    public Node root;
    //记录节点个数
    public int N = 0;
    //Node类作为节点,储存数据
    public class Node{
        public Node left;
        public Node right;
        public Key key;
        public Value value;

        public Node(Key key, Value value,Node left, Node right) {
            this.left = left;
            this.right = right;
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 向二叉树中追加元素
     * @param key
     * @param value
     */
    public void put(Key key,Value value){
        //个人理解,由于栈的结构,最后返回的节点一定是根节点
        root = put(root,key,value);
    }

    /**
     * 追加元素的真正实现方法
     * @param x
     * @param key
     * @param value
     */
    //个人认为Node类型在递归中很好创建了新节点并把其安插成在旧树的左右树
    public Node put(Node x,Key key,Value value){
        //找到合适的位置存放新节点
        if(x == null){
            N++;
            return new Node(key,value,null,null);
        }
        int result = key.compareTo(x.key);
        //查找key,value对应节点位置
        if (result > 0){
            //假设数据在最后一个节点的左子树的位置,(x.left=)在创建节点的同时巧妙的把节点成为x的左子树
            x.left = put(x.left,key,value);
        }
        if(result < 0 ){
            //假设数据在最后一个节点的左子树的位置,(x.left=)在创建节点的同时巧妙的把节点成为x的右子树
            x.right = put(x.right,key,value);
        }
        //如果key的值和当前x节点相等,那么替换掉x节点的value
        else {
            x.value = value;
        }
        return x;
    }

    /**
     *  查找key对应的value
     * @param key
     * @return
     */
    public Value get(Key key){
        return get(root, key);
    }
    public Value get(Node x, Key key){
        if (x == null){
            return null;
        }
        int result = key.compareTo(x.key);
        //查找key,value对应节点位置
        //查找x树的左子树
        if (result > 0){
            //return之前会执行方法
            return get(x.left,key);
        }
        //查找x树的右子树
        if(result < 0 ){
            //return之前会执行方法
            return get(x.right,key);
        }
        //恰好key的值和x节点的key相等
        else {
            //方法到这里结束,会把值返回给上一级方法
            return x.value;
        }

    }

    /**
     * 删除key节点
     * @param key
     */
    public void delete(Key key){
        root = delete(root,key);
    }

    /**
     * 这里是递归,代码的真正实现
     * @param x
     * @param key
     * @return
     */
    public Node delete(Node x,Key key){
        //如果没有相匹配的树,返回空值,代表删除失败
        if(x == null){
            return null;
        }
        int result = key.compareTo(x.key);
        //查找节点在当前x节点的右边,继续查找树的左子树
        if(result > 0){
            x.right = delete(x.right,key);
        }
        //查找节点在当前x节点的左边,继续查找树的左子树
        if(result < 0){
            x.left = delete(x.left,key);
        }
        //当找到key值对应的树的时候
        else{
            //如果当前树的左子树不存在
            if(x.left == null){
            //直接返回他的右子树,他的右子树会被上一层的x.left或者x.right巧妙嫁接
                return x.right;
        }
            //如果当前树的右子树不存在
            if(x.right == null){
                //直接返回他的左子树,他的左子树会被上一层的x.left或者x.right巧妙嫁接
                return x.left;
            }
            //如果当前节点的左右子树都存在
            else {
                //创建指针节点,用于找到x树的右子树的最小叶子节点,让它成为新的节点
                //从被删除的节点的右子树开始遍历
                Node p = x.right;
                //指针p1用于指向最小节点的上一个节点
                Node p1 = x.right;
                while (p.left != null){
                    p = p.left;
                }
                //此时已经找到了替换的节点
                Node exchange = p;
                //我们这一步需要把指针p1移动到被删除节点的上一个节点
                while (p1.left.left != null){
                    p1 = p1.left;
                }
                //将删除的元素滞空,等于删除元素
                p1.left = null;
                //把x节点替换为新节点
                exchange.left = x.left;
                exchange.right = x.right;
                //因为上一层的x.left/x.left的作用,返回的节点自动被拼接在原来的位置
                N--;
                return exchange;
            }
        }
        return x;
    }

}
