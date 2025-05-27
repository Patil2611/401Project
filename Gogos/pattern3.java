//WAP to pattern 3
import java.util.*;

public class pattern3 {
    
    public static void main(String[] args) {
        
        for(int i=1 ; i<=5 ; i++){
            for(int j=1 ; j<=i ; j++){
                System.out.print(" ");
            }
            for(int a=1 ; a<=5-i ; a++){
                System.out.print("*");
            }
            for(int b=i ; b<=5 ; b++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
