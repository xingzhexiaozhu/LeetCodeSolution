import java.util.Scanner;

//题意描述：给定一个整数字符串，反转各个位上的数字.比如：
//x = 123, return 321
//x = -123, return -321


public class ReverseInteger {

	//解题思路：只需考虑数字的正负，然后统一做正数处理，对最终的结果再乘符号位
	private static int reverse(int num) {
		int sign = 1;
		if(num<0) sign = -1;
		
		int temp = Math.abs(num);
		double result = 0;		
		
		while(temp > 0){
			int bit = temp%10;
			result = result * 10 + bit;		
			if(result > Integer.MAX_VALUE)
				return 0;
			temp = temp/10;
		}					
		
		return (int) ((int)sign*result);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int num = sc.nextInt();
			System.out.println(reverse(num));
		}

	}
}
