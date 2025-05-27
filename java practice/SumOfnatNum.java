// 6. Write a C program to find sum of all natural numbers between 1 to n.
import java.util.Scanner;
public class SumOfnatNum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int sum = 0;
        int i = 1;
        while(i <= num){
            sum = sum + i;
            i++;

        }
        System.out.println("Sum of natrual numb is " +sum);

    }
    
}
