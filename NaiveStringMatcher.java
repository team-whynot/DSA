import java.util.*;
public class NaiveStringMatcher {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("\t\t*****Naive String Matching Algorithm*****\n");
		System.out.printf("Enter the text: ");
		String text = sc.next();
		System.out.printf("Enter the pattern: ");
		String pattern = sc.next();
		boolean exists = false;
		long startTime = System.currentTimeMillis();
		for(int i=0;i<text.length()-pattern.length();i++) {
			int j = 0, shift = i;
			while(j<pattern.length() && text.charAt(shift)==pattern.charAt(j)) {
				shift++;
				j++;
			}
			if(j>=pattern.length()) {
				System.out.println("Pattern "+pattern+" found at index: "+i+" in the text.");
				exists = true;
			}
		}
		float endTime = (float)(System.currentTimeMillis()-startTime)/(float)1000;
		if(exists == false)
			System.out.println("No such pattern found in the text.");
		System.out.println("Time required for searching: "+endTime+" seconds.");
	}

}
