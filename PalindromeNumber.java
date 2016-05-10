import java.util.Scanner;

//题意描述：判断一个数字是否为回文数字

public class PalindromeNumber {

	//解题思路一：将整数转化为字符串，再逆序字符串判断是否为回文串
	private static boolean isPalindrome(int x) {
		String str = Integer.toString(x);		
		return str.equals(new StringBuilder(str).reverse().toString());
	}
	
	//解题思路二：处理数字，首先负数不是回文数字，其次反转各个位数，如果变换后数字与原数字相等则说明是回文
	private static boolean isPalindrome1(int x){
		if(x < 0)
			return false;
		int num = 0;
		int temp= x;
		while(temp != 0){
			num = num*10 + (temp%10);
			temp = temp/10;
		}
		return num==x;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int x = sc.nextInt();
			System.out.println(isPalindrome(x) + " " + isPalindrome1(x));
		}
	}
}
