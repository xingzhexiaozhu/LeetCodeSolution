import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//�������������������ַ������ж������Ƿ�Ϊͬ���ַ��������£�
//Given "egg", "add", return true.
//Given "foo", "bar", return false.
//Given "paper", "title", return true.

public class IsomorphicStrings {

	//����˼·���൱�ڿ��������ַ�������ʽ�Ƿ���ͬ���뵽����map�������������ݽṹ��str1�е�ÿ���ַ���Ӧstr2�е�ÿ���ַ�
	//�ύʧ��"aa""ab"=>false���ǶԵģ�;"ab""aa"=>true�����󣩣����Է���Ӧ����֤�ַ�֮���һһ��Ӧ��ϵ
	//��֤�ַ�֮��һһ��Ӧ�Ĺ�ϵ������set
	private static boolean isIsomorphic(String s, String t) {
		if(s.length() != t.length())//���ַ������Ȳ����
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
