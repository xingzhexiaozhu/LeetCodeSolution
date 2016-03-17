import java.util.Scanner;

//字符串逆序:将输入的字符串反转

public class ReverseString {
	public static String reverse(String s){
		char[] ch = s.toCharArray();//将字串转换为数组
		s = "";
		for(int i=ch.length-1; i >= 0; i--)
			s += ch[i];
		return s;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("请输入字符串:");
		String str = in.nextLine();
		System.out.print("字符串的逆序为:");
		System.out.println(reverse(str));
	}
}
