import java.util.Scanner;

//题意描述：比较两个字符串version1和version2的版本，版本号由数字和"."组成
//version1>version2返回1、version<version2返回-1、否则返回0

public class CompareVersionNumbers {

	//解题思路：比较两个字符串，字符串由数字和"."组成，所以先将字符串通过split()转化为字符数组，再逐位比较
	//如果index=i区别出来了直接返回，否则比较index=i+1位
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
