//WAP to display a number 1 to 10
import java.util.*;

public class withoutloop {
    
    static void series(int x){
        if(x<=10){
            System.out.println(x);
            series(x+1);
        }
        
    }
    public static void main(String[] args) {
        
        series(1);
    }
}
