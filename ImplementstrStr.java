import java.util.Scanner;

//������������һ���ַ����Ƿ�����һ���ַ������Ӵ���������򷵻ص�һ�γ��ֵ��±꣬��������򷵻�-1

public class ImplementstrStr {

	//����˼·һ�����������뵽�ķ����������αȽ��Ե�ǰ�ַ���ʼ���ַ���1�����ַ���2�ĳ���Ϊ���ȵ��Ӵ�
	//���ַ���2�Ƿ���ȣ�����򷵻��±꣬�������������len1-lenλ��
	private static int strStr(String haystack, String needle) {
		if(haystack==null || needle==null)
			return -1;
		
		int len1 = haystack.length();
		int len2 = needle.length();
		
		if(len2 > len1)
			return -1;

		for(int i=0; i<=len1-len2; i++){//��Ҫ"<="
			if(haystack.subSequence(i, i+len2).equals(needle))
				return i;
		}
		
		return -1;
	}
	
	//����˼·����KMP�㷨
	private static int strStr1(String haystack, String needle){
		if(haystack==null || needle==null)
			return -1;
		
		int len1 = haystack.length();
		int len2 = needle.length();
		if(len2 > len1)
			return -1;
		
		int[] next = getNext(needle);
		
		int i = 0;
		while(i <= len1-len2){
			int success = 1;
			for(int j=0; j<len2; j++){
				if(needle.charAt(0) != haystack.charAt(i)){
					success = 0;
					i++;
					break;
				}else if(needle.charAt(j) != haystack.charAt(i+j)){
					success = 0;
					i = i+j-next[j-1];
					break;
				}
			}
			if(success == 1)
				return i;
		}
		return -1;
	}
	private static int[] getNext(String str){
		int[] next = new int[str.length()];
		next[0] = 0;
		for(int i=1; i<str.length(); i++){
			int index = next[i-1];
			while(index>0 && str.charAt(index)!=str.charAt(i))
				index = next[index-1];
			if(str.charAt(index) == str.charAt(i))
				next[i] = next[i-1] + 1;
			else next[i] = 0;
		}
		return next;
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String haystack = sc.next();
			String needle = sc.next();
			System.out.println(strStr(haystack, needle) + "\t" + strStr1(haystack, needle));
		}
	}

}
