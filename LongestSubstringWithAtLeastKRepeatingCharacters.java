import java.util.Scanner;

//题意描述：求每个字符至少出现k次的最长子字符串
//Input:
//s = "aaabb", k = 3
//Output:
//3
//The longest substring is "aaa", as 'a' is repeated 3 times.

//Input:
//s = "ababbc", k = 2
//Output:
//5
//The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

public class LongestSubstringWithAtLeastKRepeatingCharacters {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.next();
			int k = sc.nextInt();
			System.out.println(getRes2(str,k));
		}
	}

	private static int getRes(String str, int k) {		
		int[] ch = new int[26];//辅助空间统计字符出现次数
		int[] count = new int[str.length()];//求解数组，从头依次统计到当前字符一共出现的次数
		int cur=0,res = 0;
		
		for(int i=0; i<ch.length; i++)
			ch[i] = 0;
		
		for(int i=0; i<str.length(); i++){
			count[i] = ++ch[str.charAt(i)-'a'];
		}		
		
		for(int i=0; i<count.length; i++){
			if(count[i] >= k)
				cur += count[i];
			else{
				res = Math.max(res, cur);
				cur = 0;
			}
		}
		
		return res;		
	}
	
	public static int getRes2(String s, int k) {
	    if (s.length() < k)
	        return 0;
	    int[] count = new int[128];
	    for (char c : s.toCharArray())
	        ++count[c];
	    char rare = s.charAt(0);
	    for (char c='a'; c<='z'; c++)
	        if (count[c] > 0 && count[c] < count[rare])
	            rare = c;
	    if (count[rare] >= k)
	        return s.length();
	    int max = 0;
	    for (String t : s.split(rare + ""))
	        max = Math.max(max, getRes2(t, k));
	    return max;
	}
}
