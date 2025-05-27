//WAP to pattern 4
import java.util.*;

public class pattern4 {
    
    public static void main(String[] args) {
        
        int rows = 5;

        for(int i=1 ; i<=rows ; i++){
            for(int j=i ; j<=rows ; j++){
                System.out.print(" ");
            }
            for(int a=1 ; a<=(2*i-1) ; a++){
                System.out.print("*");
            }
            
            System.out.println();
        }
    }
}