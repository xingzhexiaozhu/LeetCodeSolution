import java.util.Scanner;

//�����������ж�һ�������Ƿ�Ϊ��������

public class PalindromeNumber {

	//����˼·һ��������ת��Ϊ�ַ������������ַ����ж��Ƿ�Ϊ���Ĵ�
	private static boolean isPalindrome(int x) {
		String str = Integer.toString(x);		
		return str.equals(new StringBuilder(str).reverse().toString());
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int x = sc.nextInt();
			System.out.println(isPalindrome(x));
		}
	}
}
