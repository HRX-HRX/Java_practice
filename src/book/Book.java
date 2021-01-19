package book;

public class Book {
    private  String name;
    private String auther;
    private int price;
    private String type;
    private String status;


    public Book(String name, String auther, int price, String type,String status) {
        this.name = name;
        this.auther = auther;
        this.price = price;
        this.type = type;
        this.status=status;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String  isStatus() {
        return status;
    }

    public void setStatus(String  status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "book{" +
                "name='" + name + '\'' +
                ", auther='" + auther + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", status=" + status +
                '}';
    }
}
