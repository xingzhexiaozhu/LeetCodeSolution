import java.util.Scanner;
import java.util.Stack;

//题意描述：给定一个只包含小写字母的字符串，删除字符串中重复的字符，然后返回新的字符串是字典顺序排中最小的（不能打乱其原本的相对位置）
//如：给定 "bcabc"，返回 "abc"
//  给定 "cbacdcbc"，返回 "acdb"

public class RemoveDuplicateLetters {

	//解题思路：声明char[26]出过过就标记1，最后由1组成字符串
	//下面的解法是去掉重复的字母后完全重新排序（不合题意）
//	private static String removeDuplicateLetters(String str) {
//		if(str==null || str.length()==0)
//			return null;
//				
//		char[] ch = new char[26];
//		Arrays.fill(ch, '0');
//		for(int i=0; i<str.length(); i++){
//			ch[str.charAt(i)-'a'] = str.charAt(i);
//		}
//	
//		String res = "";
//		for(int i=0; i<ch.length; i++){
//			if(ch[i] != '0')
//				res += ch[i];
//		}
//
//		return res;
//	}

	//解题思路：首先统计出每个字符出现的次数，用visited数组永不一个字母是否被访问过，如果访问过则说明该字母在结果字符串中的位置已安排并继续循环，
	//如果没有访问过，我们和结果中最后一个字母比较，如果该字母的ASCII码小并结果中的最后一个字母在统计数组中的值不为0（说明后面还会出现这个字母），
	//那么我们此时就要在结果中删去最后一个字母且将其标记为未访问，然后加上当前遍历到的字母，并且 将其标记为已访问，以此类推直遍历完整个字符串
	//以“bcabc”为例：
	//对于第一个字符b，因为b第一次出现，则保留下来，res="b";
	//对于第二个字符c，因为c第一次出现，而且比b大，则保留下来，res="bc"
	//对于第三个字符a，因为a第一次出现，所以应该保留，但a比b和c都小，则分为两种情况：
	//	如果在原字符串中，a后面还有b则应该把b移除，则把a放在c的后面,res="ca"；有c时同理，res="a";
	//	如果在原字符串中，a后面没有b和c，则只能把a放在bc后面，res="bca"
	private static String removeDuplicateLetters(String str){
		if(str==null)
			return null;
		
		int[] count = new int[26];//统计每个字符出现次数
		for(int i=0; i<str.length(); i++)
			count[str.charAt(i)-'a']++;		
		
		Stack<Character> stack = new Stack<>();
		boolean[] visited  = new boolean[26];//标记数组，标记每个字符是否被访问过。默认初始化为false
		for(int i=0; i<str.length(); i++){
			count[str.charAt(i)-'a']--;			
			
			if(visited[str.charAt(i)-'a'])
				continue;
			
			while(!stack.isEmpty() && stack.peek() > str.charAt(i) && count[stack.peek()-'a']>0){
				visited[stack.peek()-'a'] = false;
				stack.pop();
			}
			stack.push(str.charAt(i));
			visited[str.charAt(i)-'a'] = true;
		}
		
		StringBuilder res = new StringBuilder();
		for(char ch : stack)
			res.append(ch);
		
		return res.toString();
	}
	
	//解题思路二：递归解法。先记录每个字母出现次数，再遍历给定的字符串，找出最小的字母，每比较一个字母，在统计数组中值就减1，
	//如果此时为0了就不继续遍历了，此时我们记录了一个位置，把字符串str中左边的字字母全删掉，右边所有再出现的该字母也删掉
	//递归调用此函数
	private static String removeDuplicateLetters2(String str){
		int[] count = new int[26];		
		for(int i=0; i<str.length(); i++)
			count[str.charAt(i)-'a']++;//统计每个字符出现次数
		
		int pos = 0;
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) < str.charAt(pos))
				pos = i;
			if(--count[str.charAt(i)-'a'] == 0)
				break;//当一个字符计数到0时，表示该字符必须出现
		}		
		
		return str.length()==0 ? "":str.charAt(pos) + removeDuplicateLetters2(str.substring(pos + 1).replaceAll("" + str.charAt(pos), ""));
	}
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);		
		while(sc.hasNext()){
			String str = sc.next();
			System.out.println(removeDuplicateLetters(str) + "\t" + removeDuplicateLetters2(str));
		}
	}
	
}
