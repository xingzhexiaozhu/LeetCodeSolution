import java.util.Scanner;

//题意描述：找到数字序列中的第n个数字，如1,2,3,4,5,6,7,8,9,10,11...
//输入n=3,返回3； 输入n=11,返回0

public class NthDigit {

	//解题思路：1~9，每位1位数，共9个数字；10~99，每位2位数，共2*90个数字；
	//100~999，每位3位数，共3*900个数字；...
	//因此要找第n个数字，可以先确定是在哪个区间，然后在该区间下再找
	private static int findNthDigit(int n) {
		if(n <= 0)
			return 0;
		
		long count = 9;
		int start = 1;//每个区间第一个数
		int len = 1;
		
		while(n > len * count){
			n -= len*count;
			len++;
			start *= 10;
			count *= 10;		
		}
		start += (n-1)/len;
		
		return String.valueOf(start).charAt((n-1)%len)-'0';
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(findNthDigit(n));
		}
	}

}
