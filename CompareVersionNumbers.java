import java.util.Scanner;

//�����������Ƚ������ַ���version1��version2�İ汾���汾�������ֺ�"."���
//version1>version2����1��version<version2����-1�����򷵻�0

public class CompareVersionNumbers {

	//����˼·���Ƚ������ַ������ַ��������ֺ�"."��ɣ������Ƚ��ַ���ͨ��split()ת��Ϊ�ַ����飬����λ�Ƚ�
	//���index=i���������ֱ�ӷ��أ�����Ƚ�index=i+1λ
	private static int compareVersion(String version1, String version2) {
		if(version1==null || version2==null)
			return 0;
		
		String[] str1 = version1.split("\\.");
		String[] str2 = version2.split("\\.");
		
		for(int i=0; i<str1.length || i<str2.length;){
			int n1 = i<str1.length ? Integer.parseInt(str1[i]) : 0;
			int n2 = i<str2.length ? Integer.parseInt(str2[i]) : 0;
			if(n1 > n2) return 1;
			else if(n1 < n2) return -1;
			else i++;			
		}
		
		return 0;
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str1 = sc.next();
			String str2 = sc.next();
			System.out.println(compareVersion(str1, str2));
		}
	}
	
}
