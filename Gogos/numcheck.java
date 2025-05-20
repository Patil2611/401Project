//WAP to check a number is positive, negative or zero
import java.util.Scanner;

public class numcheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num=sc.nextInt();

        if(num > 0){
            System.out.println(num + " is Positive number");
        }else if (num < 0){
            System.out.println(num + " Is negative number");
        }else{
            System.out.println(num + " Is Zero");
        }
    }
}