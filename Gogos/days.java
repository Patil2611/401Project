//Write a program to display the day of the week based on a number (1 for Monday, 2 for Tuesday, etc.).
import java.util.*;

public class days {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a days: ");
        int days = sc.nextInt();

        switch (days) {
            case 1: System.out.println("Monday");
                break;
            
            case 2: System.out.println("Tuesday");
                break;

            case 3: System.out.println("Wednsday");
                break;

            case 4: System.out.println("Thursday");
                break;

            case 5: System.out.println("Friday");
                break;

            case 6: System.out.println("Saturday");
                break;

            case 7: System.out.println("Sunday");
                break;

            default: System.out.println("Please enter valid days");
                break;
        }
    }
    
}