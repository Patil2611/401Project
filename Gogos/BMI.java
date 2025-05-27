//WAP that calculate BMI and  prints the health status.
import java.util.*;

public class BMI {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a weight: ");
        double weight = sc.nextDouble();

        System.out.println("Enter a height: ");
        double height = sc.nextDouble();

        Double BMI = weight / (height * height);

        if(BMI < 18.5){
            System.out.println("Underweight");
        }else if(BMI >= 18.5 && BMI <= 24.9){
            System.out.println("Normal");
        }else if(BMI >= 25 && BMI <= 29.9){
            System.out.println("Overweight");
        }else if(BMI >= 30){
            System.out.println("Obese");
        }
    }
}
