package Crypto;
import java.util.Scanner;

public class crypto {
	public static void main(String[] Args) {
		Scanner scanner = new Scanner(System.in);
		
		String nomaliseResult = normaliseText();
		System.out.println(nomaliseResult);
		
		System.out.println("How many characters to offset text by? ");
		int ceaserNumber = scanner.nextInt();
		String ceaserResult = ceaserify(nomaliseResult, ceaserNumber);
		System.out.println(ceaserResult);
		
		System.out.println("Enter a number to group the by: ");
		int groupNumber = scanner.nextInt();
		String groupResult = groupify(ceaserResult, groupNumber);
		System.out.println(groupResult);

		
	}
	
	public static String normaliseText(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your text: ");
		
		String inputText = scanner.nextLine();
		inputText = inputText.trim().toUpperCase().replaceAll("\\W", "");
		return inputText;
	}
	
	public static String ceaserify(String text, int x) {
		
		int start = 0;
	    String result = "";
	    for(int i=0; i < text.length(); i++) {
	        char c = text.charAt(i);
	        
	        if(x > 0){
	            start = (((int) c + x -65)%26)+65;
	        }
	        else {
	            start = (((int) c + x-90)%26)+90;
	        }
	        result = result + (char)start;
	    }
	    return result;
	}
	
	public static String groupify(String text, int x) {
		String result = "", temp ="";
		
		for (int i=0; i < text.length(); i++) {
			char c = text.charAt(i);
			
			if ((i % x == 0) && (i != 0)) {
			result += " ";
			temp = "";
			}
			
			temp += c;
			result += c;
		}
		
		if((result.replaceAll(" ","")).length() % x != 0) {
			for (int i= temp.length(); i < x; i++) {
				result += "x";
			}
		}
		return result;
	}
}
