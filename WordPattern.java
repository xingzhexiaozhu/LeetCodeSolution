import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//题意描述：字符与字符串的映射，一个字符对应一个字符串，并且对应关系是一对一的关系
//Examples:
//1.pattern = "abba", str = "dog cat cat dog" should return true.
//2.pattern = "abba", str = "dog cat cat fish" should return false.
//3.pattern = "aaaa", str = "dog cat cat dog" should return false.
//4.pattern = "abba", str = "dog dog dog dog" should return false.

public class WordPattern {

	//解题思路：可以建立map对字符和字符串进行一一映射关系，保证不重复
	private static boolean wordPattern(String pattern, String str) {
		String[] strs = str.split(" ");
		if(pattern.length() != strs.length)
			return false;//pattern的长度应该和字符串的长度一致才能进行匹配，否则不匹配
		
		Map<Character, String> map = new HashMap<>();//char与String的映射
		Set<String> unique = new HashSet<>();//保存String，避免出现多对一的情况
		
		for(int i=0; i<pattern.length(); i++){
			char c = pattern.charAt(i);
			if(map.containsKey(c)){
				if(!map.get(c).equals(strs[i]))
					return false;
			}else{
				if(unique.contains(strs[i])) 
					return false;
				map.put(c, strs[i]);
				unique.add(strs[i]);
			}
		}		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pattern;
		String str;
		while(sc.hasNext()){
			pattern = sc.nextLine();
			str = sc.nextLine();
			System.out.println(wordPattern(pattern, str));
		}
	}
}
