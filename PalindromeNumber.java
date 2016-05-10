import java.util.Scanner;

//�����������ж�һ�������Ƿ�Ϊ��������

public class PalindromeNumber {

	//����˼·һ��������ת��Ϊ�ַ������������ַ����ж��Ƿ�Ϊ���Ĵ�
	private static boolean isPalindrome(int x) {
		String str = Integer.toString(x);		
		return str.equals(new StringBuilder(str).reverse().toString());
	}
	
	//����˼·�����������֣����ȸ������ǻ������֣���η�ת����λ��������任��������ԭ���������˵���ǻ���
	private static boolean isPalindrome1(int x){
		if(x < 0)
			return false;
		int num = 0;
		int temp= x;
		while(temp != 0){
			num = num*10 + (temp%10);
			temp = temp/10;
		}
		return num==x;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int x = sc.nextInt();
			System.out.println(isPalindrome(x) + " " + isPalindrome1(x));
		}
	}
}
