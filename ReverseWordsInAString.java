import java.util.Scanner;

//��������������һ���ַ��������ط�ת����ַ���
//For example,
//Given s = "the sky is blue",
//return "blue is sky the".

public class ReverseWordsInAString {

	//����˼·���Ƚ��ַ�������Ϊ�ַ����飬Ȼ��ƴ��
	private static String reverseWords(String s) {
		String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder("");
        for(int i=str.length-1; i>=0; i--){
        	if(!str[i].equals(""))
        		sb.append(str[i]).append(" ");
        }
            
        return sb.toString().trim();
	}	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			System.out.println(reverseWords(str));
		}
	}

}
