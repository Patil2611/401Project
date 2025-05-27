//11. Write a C program to find first and last digit of a number
import java.util.Scanner;
public class FirstLastDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int LastDigit = num % 10;
        int firstDigit  = num;

        while(firstDigit >= 10){
            firstDigit = firstDigit /10;

        }
        System.out.println("First digit is " + firstDigit);
        System.out.println("Last digit is " + LastDigit);
}
}
