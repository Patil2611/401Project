// WAP to check the year is leap or not
import java.util.*;
public class leapyear {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a year: ");
        int year=sc.nextInt();
        

        if(year % 4 == 0){
            if(year % 100 != 0){
                System.out.println(year +"Leap year");
            }else if(year % 400 == 0){
            System.out.println(year+"Leap year");
        }
    }else{
            System.out.println("This is not leap year");
        }
}
}