package user;

import operation.*;

import java.util.Scanner;

public class NormalUser extends User{
    public NormalUser(String name) {

        super(name);
        this.operations = new IOperation[]{new ExitOperate(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation(),
                new DisplayOperation()
        };
    }

    @Override
    public int menu() {
        Scanner sc=new Scanner(System.in);

        System.out.println("**************");
        System.out.println("welcome!");
        System.out.println("1 查找图书");
        System.out.println("2 借阅图书");
        System.out.println("3 归还图书");
        System.out.println("0 退出系统");
        System.out.println("**************");
        int choice=sc.nextInt();
        return choice;
    }
}
