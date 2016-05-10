package NewCoder;

import java.util.Scanner;

//题意描述：请实现一个函数，将一个字符串中的空格替换成“%20”。
//例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

public class ReplaceSpace {

	//解题思路一：借助Java API中的replaceAll函数直接实现替换
	public static String replaceSpace(String str) {
		String regex = " ";
		return str.replaceAll(regex, "%20");
	}
	
	//解题思路二：遍历字符串，遇到空格就替换
	public static String replaceSpace1(String str){
		StringBuilder sb = new StringBuilder(str);
		for(int i=0; i<sb.length(); i++){
			if(sb.charAt(i) == ' ')
				sb.replace(i, i+1, "%20");
		}
		return sb.toString();	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			System.out.println(replaceSpace(str) + "\t" + replaceSpace1(str));
		}
	}
}
