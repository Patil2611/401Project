//WAP of display a pattern 2
import java.util.*;
public class pattern2 {
    
    public static void main(String[] args) {
        int num = 5;
        for(int i = num ; i>=1 ; i--){
            for(int j = 1 ; j<=i ; j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}
