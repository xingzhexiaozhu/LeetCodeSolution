import java.util.Arrays;
import java.util.Scanner;

public class FirstUniqueCharacterInAString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.next();
			System.out.println(firstUniqueChar(str));
		}
	}

	private static int firstUniqueChar(String str) {
		int index = -1;
		if(str == null || str.length() <= 0)
			return index;
		
		int[] ch = new int[26];
		Arrays.fill(ch, 0);
		
		for(int i=0; i<str.length(); i++){
			ch[str.charAt(i)-'a'] += 1;
		}		
		
		for(int i=0; i<str.length(); i++){
			if(ch[str.charAt(i)-'a'] == 1){
				index = i;
				break;
			}
		}
		
		return index;
	}

}
