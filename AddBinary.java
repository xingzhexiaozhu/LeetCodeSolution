import java.util.Scanner;

//题意描述：给定两个二进制字符串，返回字符串二进制求和后的字符串
//如：str1="11",str2="1",返回"100"

public class AddBinary {

	//解题思路一：将字符串转换为整型，相加后转换为二进制字符串返回
	private static String addBinary(String str1, String str2) {
		int num1 = Integer.parseInt(str1,2);//二进制字符串转十进制
		int num2 = Integer.parseInt(str2,2);
		
		return Integer.toBinaryString(num1 + num2);
	}

	//上面的解题方法当字符串输入过长（比如超过int表示的范围）就会失效
	//解题思路二：下面采用字符串处理方式，从低位开始逐位相加，carry表进位
	private static String addBinary1(String str1, String str2){
		int index1 = str1.length()-1;
		int index2 = str2.length()-1;
		int carry = 0;      //进位
		String result = ""; //结果

		while(index1>=0 && index2>=0){//处理两个字符串公共长度部分
			int bitSum = (str1.charAt(index1)-'0') + (str2.charAt(index2)-'0') + carry;
			carry = bitSum/2;
			bitSum = bitSum%2;
			
			result = (char)(bitSum+'0') + result;			
			--index1;
			--index2;
		}
		
		//处理较长的字符串
		while(index1>=0){
			int bitSum = (str1.charAt(index1)-'0') + carry;
			carry = bitSum/2;
			bitSum = bitSum%2;
			
			result = (char)(bitSum+'0') + result;
			--index1;
		}
		while(index2>=0){
			int bitSum = (str2.charAt(index2)-'0') + carry;
			carry = bitSum/2;
			bitSum = bitSum%2;
			
			result = (char)(bitSum+'0') + result;
			--index2;
		}
		
		return (carry==0) ? result : "1"+result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str1 = sc.next();
			String str2 = sc.next();
			System.out.println(addBinary(str1,str2) + " " + addBinary1(str1, str2));
		}
	}

}
