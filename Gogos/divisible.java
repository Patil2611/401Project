//Accept a number from the user and check if it is divisible by both 5 and 11.
import java.util.Scanner;
public class divisible {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        if((num % 5 == 0 ) && ( num % 11==0 )){
            System.out.println("It is divisible by 5 & 11");
        }
        else{
            System.out.println("Its not divisible by 5 & 11");
        }
    }
}
