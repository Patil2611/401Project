//Check  the character is vowel or  consonant.
import java.util.Scanner;
public class charcheck {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a characher: ");
        String ch = sc.next(); 

        if(ch.equals("a") || ch.equals("e") || ch.equals("i") || ch.equals("o") || ch.equals("u")){
            System.out.println(ch+ " This is Vowel");
        }else{
            System.out.println(ch+ " This is Consonant");
        }

    }
}