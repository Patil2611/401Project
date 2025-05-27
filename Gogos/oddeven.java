import java.util.Scanner;


public class oddeven {
   
	public static void main(String args[]) {

		System.out.println("Enter a value: ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();

		if (a % 2 == 0) {
			System.out.println(a + " Even Number");
		} else {
			System.out.println(a + " odd Number");
		}
	}

}
