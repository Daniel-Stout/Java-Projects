import java.util.*;

public class Testing {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter size of base: ");
		int size = in.nextInt();
		
		System.out.print("What ASCII character would you like to use? ");
		String s = in.next();
		char c = s.charAt(0);
		
		Pyramid p = new Pyramid(size, c);
		p.print();
		
		in.close();
		
	}
}
