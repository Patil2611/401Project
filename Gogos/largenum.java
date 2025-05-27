//Accept three numbers from the user and find the largest among them.
import  java.util.Scanner;
public class largenum {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first num:  ");
        int num1 = sc.nextInt();
        System.out.println("Enter second num: ");
        int num2 = sc.nextInt();
        System.out.println("Enter third num: ");
        int num3 = sc.nextInt();

        if(num1 >= num2 && num1 >= num3){
            System.out.println(num1 + " Is larger num");
        }else if(num2 >= num1 && num2 >= num3){
            System.out.println(num2 + " Is larger num");
        }else{
            System.out.println(num3 + " Is larger num");
        }
    }
}