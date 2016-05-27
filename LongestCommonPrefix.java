import java.util.Scanner;

//�����������ҳ������ַ����������ǰ׺

public class LongestCommonPrefix {

	//����˼·һ������Ƚϣ������ַ�����һ�Ƚϣ��������ַ��������ǰ׺ʱ�������ǰ׺���ȿ϶�������ڽ϶��ַ����ĳ���
	//ͬ�����ڶ���ַ����ȱȽ�ǰ�����ַ����õ��Ĺ�����������һ�����󹫹�����
	//����ַ������鳤��Ϊ0��������Ϊnull��
	//�������һ���ַ�������Ϊ0���򹫹�������Ϊnull��
	private static String longestCommonPrefix(String[] strs) {		
		if(strs == null )//�����ַ�������Ϊ��
			return null;
		
		if(strs.length==0 || strs[0].length()==0)//�ַ�������Ϊ���ַ���
			return "";
		
		String commonPrefix = strs[0];		
		
		for(int i=1; i<strs.length; i++){
			int len = Math.min(commonPrefix.length(), strs[i].length());
			
			if(len <= 0)
				return "";
			
			int index = 0;
			while(index < len){
				if(commonPrefix.charAt(index) != strs[i].charAt(index))
					break;
				++index;
			}
			
			commonPrefix = commonPrefix.substring(0, index);
		}
		
		return commonPrefix;
	}
	
	//����˼·����������Ƚϣ���n���ַ����ģ���index=0��ʼ�Ƚϣ����в�һ�����ַ�ʱ�ͷ���ǰ���ѱȽϹ���ͬ���ַ�
	private static String longestCommonPrefix1(String[] strs){
		if(strs.length == 0)
			return "";
		
		for(int i=0; i<strs[0].length(); i++){
			for(int j=1; j<strs.length; j++){
				if(strs[j].length()<=i || strs[0].charAt(i) != strs[j].charAt(i))
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] strs = {"", "", ""};
		while(sc.hasNext()){
			for(int i=0; i<3; i++)
				strs[i] = sc.next();
			System.out.println(longestCommonPrefix(strs) + "\t" + longestCommonPrefix1(strs));
		}
	}	

}
