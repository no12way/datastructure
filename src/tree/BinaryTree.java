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
        put(root,key,value);
    }

    /**
     * 追加元素的真正实现方法
     * @param x
     * @param key
     * @param value
     */
    public Node put(Node x,Key key,Value value){
        //找到合适的位置存放新节点
        if(x == null){
            return new Node(key,value,null,null);
        }
        int result = key.compareTo(x.key);
        //查找key,value对应节点位置
        if (result > 0){
            x.left = put(x.left,key,value);
        }
        if(result < 0 ){
            x.right = put(x.right,key,value);
        }
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
        if (result > 0){
            return get(x.left,key);
        }
        if(result < 0 ){
            return get(x.right,key);
        }
        else {
            return x.value;
        }

    }
    //删除树中key对应的value
    public void delete(Key key) {
        delete(root, key);
    }

    //删除指定树x中的key对应的value，并返回删除后的新树
    public Node delete(Node x, Key key) {
        //x树为null
        if (x==null){
            return null;
        }

        //x树不为null
        int cmp = key.compareTo(x.key);
        if (cmp>0){
            //如果key大于x结点的键，则继续找x结点的右子树
            x.right = delete(x.right,key);

        }else if(cmp<0){
            //如果key小于x结点的键，则继续找x结点的左子树
            x.left = delete(x.left,key);
        }else{
            //如果key等于x结点的键，完成真正的删除结点动作，要删除的结点就是x；

            //让元素个数-1
            N--;
            //得找到右子树中最小的结点
            if (x.right==null){
                return x.left;
            }

            if (x.left==null){
                return x.right;
            }

            Node minNode = x.right;
            while(minNode.left!=null){
                minNode = minNode.left;
            }

            //删除右子树中最小的结点
            Node n = x.right;
            while(n.left!=null){
                if (n.left.left==null){
                    n.left=null;
                }else{
                    //变换n结点即可
                    n = n.left;
                }
            }

            //让x结点的左子树成为minNode的左子树
            minNode.left = x.left;
            //让x结点的右子树成为minNode的右子树
            minNode.right = x.right;
            //让x结点的父结点指向minNode
            x = minNode;



        }

        return x;
    }

}
