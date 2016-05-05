import java.util.Scanner;

//题意描述：判断一个数字是否为回文数字

public class PalindromeNumber {

	//解题思路一：将整数转化为字符串，再逆序字符串判断是否为回文串
	private static boolean isPalindrome(int x) {
		String str = Integer.toString(x);		
		return str.equals(new StringBuilder(str).reverse().toString());
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int x = sc.nextInt();
			System.out.println(isPalindrome(x));
		}
	}
}
