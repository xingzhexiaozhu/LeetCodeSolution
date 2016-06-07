import java.util.Scanner;
import java.util.Stack;

//��������������һ��ֻ����Сд��ĸ���ַ�����ɾ���ַ������ظ����ַ���Ȼ�󷵻��µ��ַ������ֵ�˳��������С�ģ����ܴ�����ԭ�������λ�ã�
//�磺���� "bcabc"������ "abc"
//  ���� "cbacdcbc"������ "acdb"

public class RemoveDuplicateLetters {

	//����˼·������char[26]�������ͱ��1�������1����ַ���
	//����Ľⷨ��ȥ���ظ�����ĸ����ȫ�������򣨲������⣩
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

	//����˼·������ͳ�Ƴ�ÿ���ַ����ֵĴ�������visited��������һ����ĸ�Ƿ񱻷��ʹ���������ʹ���˵������ĸ�ڽ���ַ����е�λ���Ѱ��Ų�����ѭ����
	//���û�з��ʹ������Ǻͽ�������һ����ĸ�Ƚϣ��������ĸ��ASCII��С������е����һ����ĸ��ͳ�������е�ֵ��Ϊ0��˵�����滹����������ĸ����
	//��ô���Ǵ�ʱ��Ҫ�ڽ����ɾȥ���һ����ĸ�ҽ�����Ϊδ���ʣ�Ȼ����ϵ�ǰ����������ĸ������ ������Ϊ�ѷ��ʣ��Դ�����ֱ�����������ַ���
	//�ԡ�bcabc��Ϊ����
	//���ڵ�һ���ַ�b����Ϊb��һ�γ��֣�����������res="b";
	//���ڵڶ����ַ�c����Ϊc��һ�γ��֣����ұ�b������������res="bc"
	//���ڵ������ַ�a����Ϊa��һ�γ��֣�����Ӧ�ñ�������a��b��c��С�����Ϊ���������
	//	�����ԭ�ַ����У�a���滹��b��Ӧ�ð�b�Ƴ������a����c�ĺ���,res="ca"����cʱͬ��res="a";
	//	�����ԭ�ַ����У�a����û��b��c����ֻ�ܰ�a����bc���棬res="bca"
	private static String removeDuplicateLetters(String str){
		if(str==null)
			return null;
		
		int[] count = new int[26];//ͳ��ÿ���ַ����ִ���
		for(int i=0; i<str.length(); i++)
			count[str.charAt(i)-'a']++;		
		
		Stack<Character> stack = new Stack<>();
		boolean[] visited  = new boolean[26];//������飬���ÿ���ַ��Ƿ񱻷��ʹ���Ĭ�ϳ�ʼ��Ϊfalse
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
	
	//����˼·�����ݹ�ⷨ���ȼ�¼ÿ����ĸ���ִ������ٱ����������ַ������ҳ���С����ĸ��ÿ�Ƚ�һ����ĸ����ͳ��������ֵ�ͼ�1��
	//�����ʱΪ0�˾Ͳ����������ˣ���ʱ���Ǽ�¼��һ��λ�ã����ַ���str����ߵ�����ĸȫɾ�����ұ������ٳ��ֵĸ���ĸҲɾ��
	//�ݹ���ô˺���
	private static String removeDuplicateLetters2(String str){
		int[] count = new int[26];		
		for(int i=0; i<str.length(); i++)
			count[str.charAt(i)-'a']++;//ͳ��ÿ���ַ����ִ���
		
		int pos = 0;
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) < str.charAt(pos))
				pos = i;
			if(--count[str.charAt(i)-'a'] == 0)
				break;//��һ���ַ�������0ʱ����ʾ���ַ��������
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
