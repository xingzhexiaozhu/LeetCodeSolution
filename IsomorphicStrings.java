import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//题意描述：给定两个字符串，判断它们是否为同构字符串，如下：
//Given "egg", "add", return true.
//Given "foo", "bar", return false.
//Given "paper", "title", return true.

public class IsomorphicStrings {

	//解题思路：相当于考察两个字符串的形式是否相同，想到利用map表这个特殊的数据结构，str1中的每个字符对应str2中的每个字符
	//提交失败"aa""ab"=>false（是对的）;"ab""aa"=>true（错误），所以方法应该验证字符之间的一一对应关系
	//验证字符之间一一对应的关系，利用set
	private static boolean isIsomorphic(String s, String t) {
		if(s.length() != t.length())//两字符串长度不相等
			return false;
		
		Map<Character, Character> map = new HashMap<Character, Character>();
		Set<Character> set = new HashSet<Character>();
		
		for(int i=0; i<s.length(); i++){
			char ch = s.charAt(i);
			if(map.containsKey(ch)){
				if(!map.get(ch).equals(t.charAt(i)))
					return false;
			}else{
				if(set.contains(t.charAt(i)))
					return false;
				map.put(s.charAt(i), t.charAt(i));
				set.add(t.charAt(i));
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1, str2;
		while(sc.hasNext()){
			str1 = sc.next();
			str2 = sc.next();
			System.out.println(isIsomorphic(str1, str2));
		}
	}

}
