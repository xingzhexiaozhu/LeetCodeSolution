import java.util.Scanner;

//题意描述：给定整数n，返回第n个序列（字符串）
//(字符串的加解密问题)1, 11, 21, 1211, 111221, ...
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.

public class CountAndSay {

	//解题思路：可以看到对于该字符序列，下一个字符串是对上一个字符串的解读.
	//比如：11--前一个字符序列由1个1组成；21--前一外字符序列由2个1组成；1211--前一个字符序列由1个2、1个1组成
	//111221--前一个字符序列由1个1、1个2、2个1组成
	private static String countAndSay(int n){
		String preString = "1";
		while(--n > 0){
			StringBuilder str = new StringBuilder();
			for(int i=0; i<preString.length(); i++){
				int count = 1;
				while((i+1)<preString.length() && preString.charAt(i)==preString.charAt(i+1)){
					++count;
					++i;
				}
				str.append(String.valueOf(count) + preString.charAt(i));
			}
			preString = str.toString();
		}
		
		return preString;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(countAndSay(n));
		}
	}

}
