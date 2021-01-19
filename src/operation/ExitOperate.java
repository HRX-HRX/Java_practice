package operation;

import book.BookList;

public class ExitOperate implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统");
        System.exit(1);

    }
}
