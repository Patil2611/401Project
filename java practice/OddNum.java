//5. Write a C program to print all odd number between 1 to 100.

import java.util.Scanner;

public class OddNum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int i = 1;
        while(i <= num)
{
            if(i%2 !=0){
                System.out.print(" " + i +  " ");
            }
            i++;
}    }
    
}
