//WAP to find the middle of three numbers
import java.util.*;

public class middlenum {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a first num: ");
        int num1 = sc.nextInt();

        System.out.println("Enter a second num: ");
        int num2 = sc.nextInt();

        System.out.println("Enter a third num: ");
        int num3 = sc.nextInt();

        if (num1 > num2 && num1 < num3){
            System.out.println("Middle number is : "+num1);
        }else if(num2 > num1 && num2 < num3){
            System.out.println("Middle number is : "+num2);
        }else{
            System.out.println("Middle number is : "+num3);
        }
    }
}
