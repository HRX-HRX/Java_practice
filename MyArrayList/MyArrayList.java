import java.util.Arrays;

public class MyArrayList {
    /*public int[] elem = new int[10];
    public int usedSize = 0;
    */
    private int[] elem;//null
    private int usedSize;

    public MyArrayList() {
        this.elem = new int[5];
    }

    public MyArrayList(int capacity) {
        this.elem = new int[capacity];
    }

    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    public boolean isFull() {
        if(this.usedSize == this.elem.length) {
            return true;
        }
        return false;
    }
    public void resize( ) {
        this.elem =
                Arrays.copyOf(this.elem,2*this.elem.length);
    }

    //在 pos 位置新增元素
    public void add(int pos, int data) {
        //顺序表是否满
        if(isFull()) {
            //System.out.println("顺序表为满！");
            resize();
        }
        //pos是否合法
        if(pos < 0 || pos > this.usedSize) {
            System.out.println("pos位置不合法！");
            return;
        }
        //移动元素
        for (int i = this.usedSize-1; i >= pos  ; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }
    //默认插入到数组的最后
    public void add2(int data) {
        //顺序表是否满
        if(isFull()) {
            resize();
        }
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }


    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }

    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos < 0 || pos >= this.usedSize) {
            return -1;
        }
        return -1;
    }

    // 给 pos 位置的元素修改为 value
    public void setPos(int pos, int value) {
        if(pos < 0 || pos >= this.usedSize) {
            return;
        }
        this.elem[pos] = value;
    }

    //删除第一次出现的关键字key
    public void remove(int key) {
        //1、查找是否有2  index
        int index = search(key);
        if(index == -1) {
            System.out.println("没有啊！老铁");
            return;
        }
        //2、i = index     i <   usdSize-1
        for(int i = index;i < this.usedSize-1;i++) {
            this.elem[i] = this.elem[i+1];
        }
        //3、this.usedSize--;
        this.usedSize--;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }

 }
