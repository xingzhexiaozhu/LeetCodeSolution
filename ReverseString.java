import java.util.Scanner;

//�ַ�������:��������ַ�����ת

public class ReverseString {
	public static String reverse(String s){
		char[] ch = s.toCharArray();//���ִ�ת��Ϊ����
		s = "";
		for(int i=ch.length-1; i >= 0; i--)
			s += ch[i];
		return s;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("�������ַ���:");
		String str = in.nextLine();
		System.out.print("�ַ���������Ϊ:");
		System.out.println(reverse(str));
	}
}
