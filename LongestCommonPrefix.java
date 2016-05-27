import java.util.Scanner;

//题意描述：找出所有字符串的最长公共前缀

public class LongestCommonPrefix {

	//解题思路一（横向比较：两两字符串逐一比较）：求两字符串公共最长前缀时，公共最长前缀长度肯定不会大于较短字符串的长度
	//同理，对于多个字符串先比较前两个字符串得到的公共串再与下一个串求公共长度
	//如果字符串数组长度为0，公共串为null；
	//如果存在一个字符串长度为0，则公共串长度为null；
	private static String longestCommonPrefix(String[] strs) {		
		if(strs == null )//整个字符串数组为空
			return null;
		
		if(strs.length==0 || strs[0].length()==0)//字符串数组为空字符串
			return "";
		
		String commonPrefix = strs[0];		
		
		for(int i=1; i<strs.length; i++){
			int len = Math.min(commonPrefix.length(), strs[i].length());
			
			if(len <= 0)
				return "";
			
			int index = 0;
			while(index < len){
				if(commonPrefix.charAt(index) != strs[i].charAt(index))
					break;
				++index;
			}
			
			commonPrefix = commonPrefix.substring(0, index);
		}
		
		return commonPrefix;
	}
	
	//解题思路二：（纵向比较）对n个字符串的，从index=0开始比较，当有不一样的字符时就返回前面已比较过相同的字符
	private static String longestCommonPrefix1(String[] strs){
		if(strs.length == 0)
			return "";
		
		for(int i=0; i<strs[0].length(); i++){
			for(int j=1; j<strs.length; j++){
				if(strs[j].length()<=i || strs[0].charAt(i) != strs[j].charAt(i))
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] strs = {"", "", ""};
		while(sc.hasNext()){
			for(int i=0; i<3; i++)
				strs[i] = sc.next();
			System.out.println(longestCommonPrefix(strs) + "\t" + longestCommonPrefix1(strs));
		}
	}	

}
