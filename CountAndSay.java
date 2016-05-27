import java.util.Scanner;

//������������������n�����ص�n�����У��ַ�����
//(�ַ����ļӽ�������)1, 11, 21, 1211, 111221, ...
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.

public class CountAndSay {

	//����˼·�����Կ������ڸ��ַ����У���һ���ַ����Ƕ���һ���ַ����Ľ��.
	//���磺11--ǰһ���ַ�������1��1��ɣ�21--ǰһ���ַ�������2��1��ɣ�1211--ǰһ���ַ�������1��2��1��1���
	//111221--ǰһ���ַ�������1��1��1��2��2��1���
	private static String countAndSay(int n){
		String preString = "1";
		while(--n > 0){
			StringBuilder str = new StringBuilder();
			for(int i=0; i<preString.length(); i++){
				int count = 1;
				while((i+1)<preString.length() && preString.charAt(i)==preString.charAt(i+1)){
					++count;
					++i;
				}
				str.append(String.valueOf(count) + preString.charAt(i));
			}
			preString = str.toString();
		}
		
		return preString;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(countAndSay(n));
		}
	}

}
