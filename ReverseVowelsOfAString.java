import java.util.Scanner;

//���������������ַ����е�Ԫ���ַ�����hello => "holle"; "leetcode" => "leotcede"

//����˼·���������⣬���ַ���������Ҫ�ж�Ԫ���ַ������ַ������˿�ʼ���ֱ��ҵ���Ӧλ�õ�Ԫ���ַ��󽻻�λ��

public class ReverseVowelsOfAString {
	
	private static boolean isVowel(char ch){
		if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'||ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
			return true;
		else return false;
	}
	
	private static String reverseVowels(String s){
		StringBuilder str = new StringBuilder(s);
		for(int i=0,j=str.length()-1-i; i<j; i++, j--){
			while(!isVowel(str.charAt(i)) && i<j)
				i++;
			while(!isVowel(str.charAt(j)) && j>i)
				j--;
			
			if(isVowel(str.charAt(i))&&isVowel(str.charAt(j))){
			    char temp = str.charAt(i);
			    str.setCharAt(i, str.charAt(j));
		    	str.setCharAt(j, temp);
			}
		}
		return str.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		while(sc.hasNext()){
			str = sc.nextLine();
			System.out.println(reverseVowels(str));
		}
	}


}
