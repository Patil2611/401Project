// WAP to calculate a bill discount
import java.util.Scanner;
public class bill {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a bill amount: ");
        int bill_amt=sc.nextInt();
        int total = bill_amt;
        if(bill_amt<200){
            total = bill_amt;
        }else if(bill_amt >= 200 && bill_amt <= 500 ){
            total = (int) (bill_amt -(bill_amt * 0.01));
        }else if(bill_amt >= 500 && bill_amt<=1000){
            total = (int) (bill_amt -(bill_amt* 0.05));
        }
        System.out.println(total);  
    }
}
