import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//�����������ַ����ַ�����ӳ�䣬һ���ַ���Ӧһ���ַ��������Ҷ�Ӧ��ϵ��һ��һ�Ĺ�ϵ
//Examples:
//1.pattern = "abba", str = "dog cat cat dog" should return true.
//2.pattern = "abba", str = "dog cat cat fish" should return false.
//3.pattern = "aaaa", str = "dog cat cat dog" should return false.
//4.pattern = "abba", str = "dog dog dog dog" should return false.

public class WordPattern {

	//����˼·�����Խ���map���ַ����ַ�������һһӳ���ϵ����֤���ظ�
	private static boolean wordPattern(String pattern, String str) {
		String[] strs = str.split(" ");
		if(pattern.length() != strs.length)
			return false;//pattern�ĳ���Ӧ�ú��ַ����ĳ���һ�²��ܽ���ƥ�䣬����ƥ��
		
		Map<Character, String> map = new HashMap<>();//char��String��ӳ��
		Set<String> unique = new HashSet<>();//����String��������ֶ��һ�����
		
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
