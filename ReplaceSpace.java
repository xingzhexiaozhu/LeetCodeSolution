package NewCoder;

import java.util.Scanner;

//������������ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
//���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��

public class ReplaceSpace {

	//����˼·һ������Java API�е�replaceAll����ֱ��ʵ���滻
	public static String replaceSpace(String str) {
		String regex = " ";
		return str.replaceAll(regex, "%20");
	}
	
	//����˼·���������ַ����������ո���滻
	public static String replaceSpace1(String str){
		StringBuilder sb = new StringBuilder(str);
		for(int i=0; i<sb.length(); i++){
			if(sb.charAt(i) == ' ')
				sb.replace(i, i+1, "%20");
		}
		return sb.toString();	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			System.out.println(replaceSpace(str) + "\t" + replaceSpace1(str));
		}
	}
}
