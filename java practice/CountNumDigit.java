//10. Write a C program to count number of digits in a number.
import java.util.Scanner;
public class CountNumDigit {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int count = 0;
        while (num != 0){
            num = num / 10;
            count++;
        }
        System.out.println("Number of digits is " + count);
    }
    
}
