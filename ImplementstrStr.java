import java.util.Scanner;

//题意描述：求一个字符串是否是另一个字符串的子串，如果是则返回第一次出现的下标，如果不是则返回-1

public class ImplementstrStr {

	//解题思路一：。最容易想到的方法就是依次比较以当前字符开始的字符串1、以字符串2的长度为长度的子串
	//与字符串2是否相等，相等则返回下标，否则继续遍历至len1-len位置
	private static int strStr(String haystack, String needle) {
		if(haystack==null || needle==null)
			return -1;
		
		int len1 = haystack.length();
		int len2 = needle.length();
		
		if(len2 > len1)
			return -1;

		for(int i=0; i<=len1-len2; i++){//需要"<="
			if(haystack.subSequence(i, i+len2).equals(needle))
				return i;
		}
		
		return -1;
	}
	
	//解题思路二：KMP算法
	private static int strStr1(String haystack, String needle){
		if(haystack==null || needle==null)
			return -1;
		
		int len1 = haystack.length();
		int len2 = needle.length();
		if(len2 > len1)
			return -1;
		
		int[] next = getNext(needle);
		
		int i = 0;
		while(i <= len1-len2){
			int success = 1;
			for(int j=0; j<len2; j++){
				if(needle.charAt(0) != haystack.charAt(i)){
					success = 0;
					i++;
					break;
				}else if(needle.charAt(j) != haystack.charAt(i+j)){
					success = 0;
					i = i+j-next[j-1];
					break;
				}
			}
			if(success == 1)
				return i;
		}
		return -1;
	}
	private static int[] getNext(String str){
		int[] next = new int[str.length()];
		next[0] = 0;
		for(int i=1; i<str.length(); i++){
			int index = next[i-1];
			while(index>0 && str.charAt(index)!=str.charAt(i))
				index = next[index-1];
			if(str.charAt(index) == str.charAt(i))
				next[i] = next[i-1] + 1;
			else next[i] = 0;
		}
		return next;
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String haystack = sc.next();
			String needle = sc.next();
			System.out.println(strStr(haystack, needle) + "\t" + strStr1(haystack, needle));
		}
	}

}
