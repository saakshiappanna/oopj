package lab2;

import java.util.Scanner;

interface inter1 {
    void exec();

    default void display() {
        System.out.println("you may choose:");
        System.out.println("1. sign up");
        System.out.println("2. credit amount into account");
        System.out.println("3. debit amount from account");
        System.out.println("4. invest");
    }
}

class Exp extends Exception {
    public Exp(String str) {
        super(str);
    }
}

class user {
    int user_id;
    int passcode;
    int repass;
    String name;
    String email;

    user(int user_id, int passcode) {
        this.user_id = user_id;
        this.passcode = passcode;
    }

    user(int user_id, int passcode, String name, String email) {
        this.user_id = user_id;
        this.passcode = passcode;
        this.name = name;
        this.email = email;
    }

    void signin() {
        System.out.println("welcome:");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user id: ");
        int uid = sc.nextInt();
        System.out.println("Enter passcode");
        int pass = sc.nextInt();
        sc.close();
    }

    void status() {
        System.out.println("name of user : " + this.name);
        System.out.println("user_id of user : " + this.user_id);
        System.out.println("mail_id of the user is : " + this.email);
    }

}

class transaction extends user {

    int bal;
    int amt;

    transaction(int user_id, int passcode, int bal) {
        super(user_id, passcode);
        this.bal = bal;

    }

    void debit(int amt) {
        this.amt = amt;
        System.out.println("The amount to be debited is: " + this.amt);
        this.bal = this.bal - this.amt;
        try {
            if (this.bal == 0) {
                throw new Exp("This is a customized exception");
            } else {
                System.out.println("the amount remaining is " + this.bal);
            }
        } catch (Exp obj) {
            System.out.println("Funds insufficient");
        }
    }

    void credit(int amt) {
        this.amt = amt;

        System.out.println("The amount to be credited is: " + this.amt);
        this.bal = this.bal + this.amt;
        System.out.println("the amount remaining is " + this.bal);
    }

    void status() {
        System.out.println("balance is " + this.bal);
        System.out.println("last transaction was of " + this.amt);
    }

    int show() {
        return this.bal;
    }
}

class investment extends transaction {
    int no;
    int inv;

    investment(int user_id, int passcode, int bal, int inv) {
        super(user_id, passcode, bal);
        this.inv = inv;
    }

    void invest(int inv) {
        if (inv > bal) {
            System.out.println("Funds deficit");
        } else {
            super.debit(inv);
        }
    }
}

public class proj implements inter1 {
    public void exec() {
        System.out.println("please enter valid credentials");
    }

    public static void main(String[] args) {

        String s1 = "Saakshi ";
        String s2 = "Appanna";
        System.out.println(s1.concat(s2));
        System.out.println("Character at given position 0 of first string is:" + s1.charAt(0));
        proj obj = new proj();
        obj.exec();
        obj.display();
        user saakshi = new user(23, 2002, "Saakshi", "saakshiappanna@gmail.com");
        saakshi.signin();
        new NewThread();
        saakshi.status();
        transaction ssukhi = new transaction(23, 2002, 300);
        ssukhi.credit(100);
        ssukhi.status();
        ssukhi.show();
        investment sonu = new investment(28, 2002, 800, 400);
        sonu.invest(400);
        proj1 ob1 = new proj1();
        ob1.message();
        System.out.println("Main thread exiting.");

    }
}
