import java.util.Scanner;

//题意描述：实现一个函数来匹配包含'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，'*'表示它前面的字符可以出现任意次（包含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。
//例如：字符串"aaa"与模式"a.a"和"ab*ac*a"匹配;但与"aa.a"和"ab*a"均不匹配

//解题思路：(递归实现)分别在str和pattern中取一个字符进行匹配，如果匹配则匹配下一个字符，否则返回不匹配
//如果pattern当前字符与str当前字符匹配，则存在以下三种情况：
//(1)pattern当前字符能匹配str中的0个字符：match(str,pattern+2);
//(2)pattern当前字符能匹配str中的1个字符：match(str+1,pattern+2);
//(3)pattern当前字符能匹配str中的多个 字符:match(str+1,pattern);
//如果pattern当前字符和str的当前字符不匹配：
//pattern当前字符能匹配str中的0个字符:(str,pattern+1)，如果模式匹配字符的下一个字符不是'*',进行逐字符匹配；
//对于'.'的情况比较简单，和一个字符匹配match(str+1,pattern+1)
//

public class MatchString {

	private static boolean isMatch(char[] str, char[] pattern) {
		if(str == null || pattern == null)
			return false;
		
		return matchCore(str, 0, pattern, 0);
	}

	private static boolean matchCore(char[] str, int s, char[] pattern, int p) {
		if(str.length <= s && pattern.length <= p)
			return true;//匹配完了
		
		if(str.length > s && pattern.length <= p)
			return false;//模式串完了，字符串还没结束
		
		if(p+1 < pattern.length && pattern[p+1] == '*'){
			if(s >= str.length)
				return matchCore(str, s+1, pattern, p+2) 
						|| matchCore(str, s+1, pattern, p) 
						|| matchCore(str, s, pattern, p+2);
		}else
			return matchCore(str, s, pattern, p+2);
		
		if(s >= str.length)
			return false;
		else{
			if(str[s] == pattern[p] || pattern[p] =='.')
				return matchCore(str, s+1, pattern, p+1);
		}
		return false;
	}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String string = sc.next();
			String pattern = sc.next();
			System.out.println(isMatch(string.toCharArray(), pattern.toCharArray()));
		}
	}

}
