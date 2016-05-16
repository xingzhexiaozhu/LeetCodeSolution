import java.util.Scanner;

//题意描述：给定一个字符串，确定它是否是回文，只考虑字母、数字字符和忽略大小写。如：
//"A man, a plan, a canal: Panama" 是一个回文串
//"race a car" 不是一个回文串

public class ValidPalindrome {

	private static boolean isAlphanumeric(char ch){
		if((ch>='a' && ch<='z') || (ch>='0'&&ch<='9'))
			return true;
		return false;
	}
	
	//解题思路一：本题和之前的题目判断字符串是否为回文的区别就是该题目加入了空格等标点符号，
	//因此解题思路为将原字符串中的数字和字母筛选出来组成新串，再判断是否为回文
	private static boolean isPalindrome(String str) {
		if(str==null || str.length()<=0)
			return true;
		
		str = str.toLowerCase().trim();
		String s = "";
		for(int i=0; i<str.length(); i++){
			if(isAlphanumeric(str.charAt(i)))
				s += str.charAt(i);
		}

		return new StringBuilder(s).reverse().toString().equals(s);
	}

	//解题思路二：分别从两端开始逐位判断
	private static boolean isPalindrome1(String str) {		
		if(str == null || str.length() <= 0)
			return true;
		
		str = str.toLowerCase().trim();
		
		for(int i=0,j=str.length()-1; i<j; i++, j--){
			while(!isAlphanumeric(str.charAt(i)) && i<j)
				i++;
			while(!isAlphanumeric(str.charAt(j)) && i<j)
				j--;
			if(str.charAt(i) != str.charAt(j))
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			System.out.println(isPalindrome(str) + " " + isPalindrome1(str));
		}
	}
	
}
