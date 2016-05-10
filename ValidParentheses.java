import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

//�����������������ַ���ֻ����'(',')','[',']','{','}'���������ŵ�ƥ��
//���磺"()"��"()[]{}"ƥ�䶼Ϊ��ȷ�ģ���"(]"��"([)]"ƥ�䶼�Ǵ����

public class ValidParentheses {

	//����˼·һ�����ŵ�ƥ�䣬����ջ���������������뵱ǰջ�е�����ƥ��ʱ��ջ�������ջ
	//�������ջΪ���������ַ����Ϸ������򲻺Ϸ�
	private static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '(')
				stack.push(s.charAt(i));
			else if(s.charAt(i) == '[')
				stack.push(s.charAt(i));
			else if(s.charAt(i) == '{')
				stack.push(s.charAt(i));
			else if(stack.empty()) return false;
			else if(s.charAt(i) == ')'){
				if(stack.peek().equals('('))
					stack.pop();
				else stack.push(s.charAt(i));
			}else if(s.charAt(i) == ']'){
				if(stack.peek() == '[')
					stack.pop();
				else stack.push(s.charAt(i));
			}else if(s.charAt(i) == '}'){
				if(stack.peek() == '{')
					stack.pop();
				else stack.pop();
			}
		}
		return stack.empty();
	}
	
	//����˼·��������Ľ��ⷽ��̫�����д�ʦ���࣬������ƥ�����⣬���Կ����뵽��map���ݽṹ
	private static boolean isValid1(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
	 
		Stack<Character> stack = new Stack<Character>();
	 
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
	 
			if (map.keySet().contains(curr)) {
				stack.push(curr);
			} else if (map.values().contains(curr)) {
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
	 
		return stack.empty();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.next();
			System.out.println(isValid(str) + " " + isValid1(str) ) ;
		}
	}
}
