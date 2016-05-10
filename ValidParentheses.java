import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

//题意描述：给定的字符串只包含'(',')','[',']','{','}'，进行括号的匹配
//比如："()"、"()[]{}"匹配都为正确的，但"(]"、"([)]"匹配都是错误的

public class ValidParentheses {

	//解题思路一：括号的匹配，采用栈，当进来的括号与当前栈中的括号匹配时出栈，否则进栈
	//最终如果栈为空则输入字符串合法，否则不合法
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
	
	//解题思路二：上面的解题方法太代码有大师冗余，由于是匹配问题，所以可以想到用map数据结构
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
