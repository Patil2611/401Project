//Create a program that accepts a user’s marks and prints the grade (A, B, C,Fail).
import java.nio.channels.ScatteringByteChannel;
import java.util.*;

public class marks{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a marks: ");
        int mark = sc.nextInt();

        if((mark <= 100 ) && (mark >= 80)){
            System.out.println("You got A grade");
        }else if((mark < 80) && (mark >= 60)){
            System.out.println("You got B grade");
        }else if((mark < 60) && (mark >= 35)){
            System.out.println("You got C grade");
        }else{
            System.out.println("You are fail");
        }
    }
}
