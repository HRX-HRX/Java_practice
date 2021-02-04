class Node {
    public int val;
    public Node next;
    public Node() {

    }
    public Node(int val) {
        this.val = val;
    }
}

public class MyLinkedList {

    public Node head;//表示当前链表的头 默认是null

    public void createLinked() {
        this.head = new Node(12);
        Node node2 = new Node(22);
        Node node3 = new Node(32);
        Node node4 = new Node(42);
        this.head.next = node2;
        node2.next = node3;
        node3.next = node4;
    }

    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print (cur.val +" ");
         
            cur = cur.next;
        }
        System.out.println();
    }


    public Node findLastNode() {
        if(this.head == null) {
            System.out.println("head == null");
            return null;
        }
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

   

    public Node findN(int n) {
        if(this.head == null) {
            System.out.println("单链表为空！");
            return null;
        }
        if(n <= 0) {
            System.out.println("n太小了！");
            return null;
        }
        if(n > size()) {
            System.out.println("n太大了");
            return null;
        }
        int count = 1;
        Node cur = this.head;
        while (count != n) {
            count++;//1
            cur = cur.next;
        }
        return cur;
    }

    //得到单链表的长度
    public int size(){
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;//2
            cur = cur.next;
        }
        return count;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //头插法
    public void addFirst(int data) {
        //0、首先你得有个节点
        Node node = new Node(data);
        //1、判断链表是不是空的
        if(this.head == null) {
            this.head = node;
        }else {
            //2、插入
            node.next = this.head;
            this.head = node;
        }
        //0、首先你得有个节点
       /* Node node = new Node(data);
        //1、判断链表是不是空的
        node.next = this.head;
        this.head = node;*/
    }




    //尾插法
    public void addLast(int data) {
        //0、new
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
        }else {
            //1、cur 找尾巴
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            //2、插入
            cur.next = node;
        }
    }

    /**
     * 该函数是找到index-1位置的节点的引用
     * @param index
     * @return
     */
    public Node moveIndex(int index) {
        Node cur = this.head;
        int count = 0;
        while (count != index-1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        if(index < 0 || index > size()) {
            System.out.println("index不合法");
            return;
        }
        //头插法
        if(index == 0) {
            addFirst(data);
            return;
        }
        //尾插法
        if(index == size()) {
            addLast(data);
            return;
        }
        Node cur = moveIndex(index);
        //cur保存的是 index-1位置的节点的引用
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
    }

    /**
     * 找到关键key的前驱，如果有返回前驱节点的引用
     * 如果没有返回null
     * @param key
     * @return
     */
    public Node searchPrev(int key) {
        Node cur = this.head;

        while (cur.next != null) {
            if(cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if(this.head == null) {
            return;
        }
        if(this.head.val == key) {
            this.head = this.head.next;
            return;
        }
        Node prev = searchPrev(key);
        if(prev == null) {
            System.out.println("没有这个key的前驱");
        }else {
            Node del = prev.next;
            prev.next = del.next;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node prev = this.head;
        Node cur = prev.next;
        while (cur != null) {
            if(cur.val == key) {
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        if(this.head.val == key) {
            this.head = this.head.next;
        }
    }


    public void clear() {
        this.head = null;
    }


    public Node reverseList() {
        Node cur = this.head;
        Node prev = null;
        Node newHead = null;
        while (cur != null) {
            Node curNext = cur.next;
            if(curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public Node middleNode1() {
        int len = size()/2;
        Node cur = this.head;
        int count = 0;
        while (count != len) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    public Node middleNode() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
