import java.util.Scanner;

//题意描述：给定一个字符串，返回反转后的字符串
//For example,
//Given s = "the sky is blue",
//return "blue is sky the".

public class ReverseWordsInAString {

	//解题思路：先将字符串划分为字符数组，然后拼接
	private static String reverseWords(String s) {
		String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder("");
        for(int i=str.length-1; i>=0; i--){
        	if(!str[i].equals(""))
        		sb.append(str[i]).append(" ");
        }
            
        return sb.toString().trim();
	}	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			System.out.println(reverseWords(str));
		}
	}

}
