package ATM_Project;

import java.util.HashMap;
import java.util.Scanner;



class DATA{
    float balance;
}

class ATM{
    float balance;
    Scanner in=new Scanner(System.in);
    HashMap<Integer,DATA>map=new HashMap<>();
    public ATM(){
        System.out.println("Welcome to our ATM");
        op();
    }
    public void op(){
        System.out.println("Enter your pincode");
        int pincode= in.nextInt();
        if(map.containsKey(pincode)==true){
            DATA obj=map.get(pincode);
            menu(obj);
            System.out.println("----------------------------------------------------------------------");
        }
        else {
            System.out.println("Please create account first");
            System.out.println("Enter Your PinCode");
            int pin=in.nextInt();
            DATA obj=new DATA();
            map.put(pin,obj);
            menu(obj);
        }
    }
    public void menu(DATA obj){
        System.out.println("---------------------------------------------------------------");
        System.out.println("Please enter valid number");
        System.out.println("1.Check Balance");
        System.out.println("2.Deposite Money");
        System.out.println("3.Withdraw Money");
        System.out.println("4.Check another account");
        System.out.println("5.Exit");

        int x= in.nextInt();

        if(x==1){
            check_balance(obj);
        }
        else if(x==2){
            deposite(obj);
        }
        else if(x==3){
            withdraw(obj);
        }
        else if(x==4){
            op();
        }
        else if(x==5){
            System.out.println("Thank You");
        }
        else{
            System.out.println("Enter Valid Number");
            menu(obj);
        }
    }
    public void check_balance(DATA obj){
        System.out.println("Your balance is"+obj.balance);
        menu(obj);
    }
    public void deposite(DATA obj){
        float a= in.nextFloat();
        obj.balance=obj.balance+a;
        System.out.println("Amount Deposited sucessfully");
        menu(obj);
    }
    public void withdraw(DATA obj){
        float a= in.nextFloat();
        if(obj.balance>=a){
            obj.balance=obj.balance-a;
            System.out.println("Amount withdraw sucessfully");
            menu(obj);
        }
        else{
            System.out.println("Insufficient Balance");
            menu(obj);
        }
    }
}

public class Atm_Machine {
    public static void main(String[] args) {
        ATM obj=new ATM();
    }
}

