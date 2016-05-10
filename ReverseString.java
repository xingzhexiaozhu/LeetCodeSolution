import java.util.Scanner;

//字符串逆序:将输入的字符串反转

public class ReverseString {

	//方法一：调用JavaAPI中的StringBuilder的方法的reverse()  
	public static String reverse1(String s){
		return new StringBuilder(s).reverse().toString();
	}
	
	//方法二：上面的方法调用了Java的API，如果不调用API应该这样做  
	//先将字符串先转化为字符数组，然后依次拼接成新的逆序字符串  
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
		System.out.println(reverse(str) + "\t" + reverse1(str));
	}
}
