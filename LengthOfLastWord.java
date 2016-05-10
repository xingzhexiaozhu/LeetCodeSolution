import java.util.Scanner;

//���������������ַ��������һ�����ʵĳ���

public class LengthOfLastWord {

	//����˼·һ������JavaAPI���ȷִ��ٷ������һ�����ʳ���
	private static int lengthOfLastWord(String s) {
		if(s.trim().equals("")||s.length()==0)//�ַ����п�
			return 0;
		String[] strs = s.split(" ");
		return strs[strs.length-1].length();
	}
	
	//����˼·��������Ľⷨ����ַ�������������˷�̫��Ŀռ䡣����������ֱ�Ӵ����һ���ǿո��ַ���ʼ������
	//������һ���ո�ʱ�������������صĳ��ȼ�Ϊ���һ�����ʵĳ���
	private static int lengthOfLastWord1(String s){
		if(s.trim().equals("")||s.length()==0)//�ַ����п�
			return 0;
		
		int len = 0;
		s = s.trim();//��Ԥ�����ַ���
		for(int i=s.length()-1;i>=0 && s.charAt(i)!=' '; i--)
			len++;
		
		return len;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		while(sc.hasNext()){
			String str = sc.nextLine();
			System.out.println(lengthOfLastWord(str) + " " + lengthOfLastWord1(str));
		}		
	}

}
