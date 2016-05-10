import java.util.Scanner;

//题意描述：返回字符串中最后一个单词的长度

public class LengthOfLastWord {

	//解题思路一：借助JavaAPI，先分词再返回最后一个单词长度
	private static int lengthOfLastWord(String s) {
		if(s.trim().equals("")||s.length()==0)//字符串判空
			return 0;
		String[] strs = s.split(" ");
		return strs[strs.length-1].length();
	}
	
	//解题思路二：上面的解法如果字符串过长，则会浪费太多的空间。方法二就是直接从最后一个非空格字符开始计数，
	//遇到第一个空格时计数结束，返回的长度即为最后一个单词的长度
	private static int lengthOfLastWord1(String s){
		if(s.trim().equals("")||s.length()==0)//字符串判空
			return 0;
		
		int len = 0;
		s = s.trim();//先预处理字符串
		for(int i=s.length()-1;i>=0 && s.charAt(i)!=' '; i--)
			len++;
		
		return len;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		while(sc.hasNext()){
			String str = sc.nextLine();
			System.out.println(lengthOfLastWord(str) + " " + lengthOfLastWord1(str));
		}		
	}

}
