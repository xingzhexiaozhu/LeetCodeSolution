import java.util.Scanner;

//��������������һ���ַ�����ȷ�����Ƿ��ǻ��ģ�ֻ������ĸ�������ַ��ͺ��Դ�Сд���磺
//"A man, a plan, a canal: Panama" ��һ�����Ĵ�
//"race a car" ����һ�����Ĵ�

public class ValidPalindrome {

	private static boolean isAlphanumeric(char ch){
		if((ch>='a' && ch<='z') || (ch>='0'&&ch<='9'))
			return true;
		return false;
	}
	
	//����˼·һ�������֮ǰ����Ŀ�ж��ַ����Ƿ�Ϊ���ĵ�������Ǹ���Ŀ�����˿ո�ȱ����ţ�
	//��˽���˼·Ϊ��ԭ�ַ����е����ֺ���ĸɸѡ��������´������ж��Ƿ�Ϊ����
	private static boolean isPalindrome(String str) {
		if(str==null || str.length()<=0)
			return true;
		
		str = str.toLowerCase().trim();
		String s = "";
		for(int i=0; i<str.length(); i++){
			if(isAlphanumeric(str.charAt(i)))
				s += str.charAt(i);
		}

		return new StringBuilder(s).reverse().toString().equals(s);
	}

	//����˼·�����ֱ�����˿�ʼ��λ�ж�
	private static boolean isPalindrome1(String str) {		
		if(str == null || str.length() <= 0)
			return true;
		
		str = str.toLowerCase().trim();
		
		for(int i=0,j=str.length()-1; i<j; i++, j--){
			while(!isAlphanumeric(str.charAt(i)) && i<j)
				i++;
			while(!isAlphanumeric(str.charAt(j)) && i<j)
				j--;
			if(str.charAt(i) != str.charAt(j))
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			System.out.println(isPalindrome(str) + " " + isPalindrome1(str));
		}
	}
	
}
