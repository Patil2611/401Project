//WAP to demonstrate the method.
import java.util.Scanner;

class Demo{
public int add(int num1, int num2){
    return num1 + num2 ;
}
}
public class method {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num1: ");
        int num1 = sc.nextInt();
        System.out.println("Enter num2: ");
        int num2 = sc.nextInt();

        Demo obj = new Demo();
        int result=obj.add(num1,num2);
        System.out.println(result);
    }

}
