package console;

import java.util.Scanner;

public class ScannerClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the user name");
        String userName = sc.nextLine();
        System.out.println("username ---"+ userName);
    }
}
