//Calculater with multiple operation using switch statement.
import java.util.*;

public class cals {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a first number: ");
        int num1 = sc.nextInt();

        System.out.println("Enter a second number: ");
        int num2 = sc.nextInt();

        System.out.println("Enter a operation symbol (+ , - , / , % , *)");
        char symbol = sc.next().charAt(0);
        double result;

        switch (symbol) {
            case '+': result = num1 + num2;
                    System.out.println("Result is: "+ result);
                break;

            case '-': result = num1 - num2;
                    System.out.println("Result is: "+ result);
                break;
        
            case '*': result = num1 * num2;
                    System.out.println("Result is: "+ result);
                break;

            case '/': result = num1 / num2;
                    System.out.println("Result is: "+ result);
                break;

            case '%': result = num1 + num2;
                    System.out.println("Result is: "+ result);
                break;

            default: System.out.println("Invalid Operation");
                break;
        }
    }
}
