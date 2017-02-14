import java.util.Scanner;

//����������ʵ��һ��������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ���'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ����ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
//���磺�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ��;����"aa.a"��"ab*a"����ƥ��

//����˼·��(�ݹ�ʵ��)�ֱ���str��pattern��ȡһ���ַ�����ƥ�䣬���ƥ����ƥ����һ���ַ������򷵻ز�ƥ��
//���pattern��ǰ�ַ���str��ǰ�ַ�ƥ�䣬������������������
//(1)pattern��ǰ�ַ���ƥ��str�е�0���ַ���match(str,pattern+2);
//(2)pattern��ǰ�ַ���ƥ��str�е�1���ַ���match(str+1,pattern+2);
//(3)pattern��ǰ�ַ���ƥ��str�еĶ�� �ַ�:match(str+1,pattern);
//���pattern��ǰ�ַ���str�ĵ�ǰ�ַ���ƥ�䣺
//pattern��ǰ�ַ���ƥ��str�е�0���ַ�:(str,pattern+1)�����ģʽƥ���ַ�����һ���ַ�����'*',�������ַ�ƥ�䣻
//����'.'������Ƚϼ򵥣���һ���ַ�ƥ��match(str+1,pattern+1)
//

public class MatchString {

	private static boolean isMatch(char[] str, char[] pattern) {
		if(str == null || pattern == null)
			return false;
		
		return matchCore(str, 0, pattern, 0);
	}

	private static boolean matchCore(char[] str, int s, char[] pattern, int p) {
		if(str.length <= s && pattern.length <= p)
			return true;//ƥ������
		
		if(str.length > s && pattern.length <= p)
			return false;//ģʽ�����ˣ��ַ�����û����
		
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
