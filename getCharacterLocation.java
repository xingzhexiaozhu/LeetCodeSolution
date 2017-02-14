import java.util.Scanner;

//题意描述：对给定的一个字符串，找出有重复的字符，并给出其位置

//输入例子:
//abcaaAB12ab12

//输出例子:
//a:0,a:3,a:4,a:9
//b:1,b:10
//1:7,1:11
//2:8,2:12

public class getCharacterLocation {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			getCharacterLocation(str);
		}
	}

	private static void getCharacterLocation(String str) {
		if(str == null)
			return ;
		
		int[] mark = new int[256];
		for(int i=0; i<str.length(); i++)
			mark[str.charAt(i)]++;//以字符作下标，内容是该字符出现次数
		for(int i=0; i<mark.length; i++)
			mark[i] = (mark[i] == 1) ? 0 : mark[i];//只出现一次的字符标记数组中次数置0
			
		
		for(int i=0; i<str.length(); i++){
			StringBuilder res = new StringBuilder("");//当前第一次出现的非重复的字符各位置统计
			if(mark[str.charAt(i)] != 0){
				mark[str.charAt(i)]--;
				res.append(str.charAt(i) + ":" + i);
				for(int j=i+1; mark[str.charAt(i)] != 0 && j<str.length();){
					int index = j + str.substring(j, str.length()).indexOf(str.charAt(i));
					mark[str.charAt(i)]--;
					res.append("," + str.charAt(i) + ":" + index);
					j = index+1;
				}
			}
			if(!res.toString().equals(""))
				System.out.println(res);
		}
	}
}
