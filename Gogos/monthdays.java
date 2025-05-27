//Write a program that accepts a month number and displays the number of days in that month.
import java.util.*;

public class monthdays {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a month: ");
        int month = sc.nextInt();

        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 : System.out.println("This month has 31 Days"); 
                
                break;

            case 4, 6, 9, 11 : System.out.println("This month has 30 Days"); 
                
                break;
            
            case 2 : System.out.println("This month has 28 Days but in leapyear has 29"); 
                
                break;

            default: System.out.println("Enter valid month number");
                break;
        }
    }
}
