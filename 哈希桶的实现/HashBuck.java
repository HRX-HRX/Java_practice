import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2021-02-05
 * Time: 11:51
 */
public class HashBuck {
    static class Node {
        public int key;
        public int val;
        public Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    public Node[] array;
    public int usedSize;

    public HashBuck() {
        this.array = new Node[8];
    }


    public void push(int key,int val) {
        Node node = new Node(key,val);
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if(cur.key == key) {
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        //开始进行头插法  实际上JDK8  是尾插法
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
        if(loadFactor() >= 0.75) {
            resize();
        }
    }

    /**
     * 求负载因子
     * @return
     */
    public double loadFactor() {
        return this.usedSize*1.0 / this.array.length;
    }

    /**
     * 超过了负载因子 我们需要进行扩容
     * 作业：去看源码当中的，如果 超过了负载因子，扩容是怎么样扩容？
     */
    public void resize() {
        Node[] newArray = new Node[2*array.length];
        //遍历原来的数组，把原来数组里面的每个元素都进行重新哈希
        for (int i = 0; i < array.length; i++) {
            //cur是每个数组元素，下标对象的链表的头
            Node cur = array[i];
            while (cur != null) {
                int index = cur.key % newArray.length;//确定的是新数组的位置
                Node curNext = cur.next;//保存一份
                cur.next = newArray[index];//开始头插
                newArray[index] = cur;
                cur = curNext;
            }
        }
        //原来数组当中的数据 全部哈希到了 新的数组当中
        array = newArray;
    }

    public int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if(cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;//没找到
    }

    public static void main(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.push(1,1);
        hashBuck.push(2,2);
        hashBuck.push(10,10);
        hashBuck.push(4,4);
        hashBuck.push(5,5);
        hashBuck.push(6,6);//这个元素放完后就要扩容了
        hashBuck.push(7,7);
        System.out.println(hashBuck.get(6));

        HashMap<String,Integer> map = new HashMap<>();

    }



}
