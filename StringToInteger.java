import java.util.Scanner;

//题意描述：将输入的字符串转化为整形输出，题目要求考虑所有输入情况，但没有明确说明哪些情况，总结有以下情况：
//1. 符串前面的空格；
//2. 然后可能有正负号（注意只取一个，如果有多个正负号，那么说这个字符串是无法转换的，返回0。比如测试用例里就有个“+-2”）；
//3. 字符串可以包含0~9以外的字符，如果遇到非数字字符，那么只取该字符之前的部分，如“-00123a66”返回为“-123”；
//4. 如果超出int的范围，返回边界值（2147483647或-2147483648）


public class StringToInteger {
	
	private static int myAtoi(String str) {
		str = str.trim();//删除字符串中的空白符
		
		if(str==null||str.length()==0)
			return 0;//字符串为空或null的情况		
		
		boolean sign = true;//符号位
		int i = 0;
		if(str.charAt(i) == '+')
			i++;
		else if(str.charAt(i) == '-'){
			sign = false;
			i++;
		}
		
		double result = 0;
		for(; i<str.length(); i++){
			int temp = str.charAt(i) - '0';
			if(temp<0||temp>9)
				break;
			if(sign){
				result = result * 10 + temp;
				if(result > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
			}else{
				result = result * 10 - temp;
				if(result < Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
			}
		}
		
		return (int)result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			System.out.println(myAtoi(str));
		}
	}	
}
