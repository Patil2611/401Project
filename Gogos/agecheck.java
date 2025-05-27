//Write a program that accepts age and checks if the person is eligible to vote (age ≥ 18).
import java.util.*;

public class agecheck {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a age: ");
        int age = sc.nextInt();

        if(age >= 18){
            System.out.println("You are eligible for voting");
        }else{
            System.out.println("You are not eligible for voting");
        }
    }
}
