import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//找到最小的全部由1组成的能被n整除的数

//解题思路：1+10+100+...，则可以求每一位上的1模去输入的数字n后的余数之和仍可以被n整除即可

public class FindMinnum1DividedByN {

	static int FindMinnum1(int n){
		int num = 1;//从个位开始：1，10，100...
		int countNum = 1;//计算1的位数
		int curModLeft = 0;//当前位模n后的余数
		int totalModLeft = 1;//每一位模n后的余数之和	
		
		while((totalModLeft%n) != 0){//循环条件就是TotalModLeft不能整除n
			num = num * 10;
			curModLeft = num % n;
			totalModLeft += curModLeft;
			countNum++;
		}
		
		return countNum;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		while(str != null){
			System.out.println(str + " can divided by " + FindMinnum1(Integer.parseInt(str)) + " 1");
			str = br.readLine();
		}
	}

}
