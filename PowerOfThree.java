import java.util.Scanner;

//题意描述：判断一个数是是否为3的幂指数

public class PowerOfThree {

	//解题思路一：采用递归。对于3，9，27，81……可以发现，每次除3最终结果若为1则为3的倍数，否则不是3的倍数
	private static boolean isPowerOfThree(int n) {
		if(n == 1) return true;
		else if(n == 0) return false;
		else if(n%3 == 0)
			return isPowerOfThree(n/3);
		else return false;
	}
	//解题思路二：采用循环
	private static boolean isPowerOfThree1(int n){
		while(n >= 1){
			if(n ==1 || n == 3)
				return true;
			else {
				if((n%3) != 0) break;
				n = n/3;
			}			
		}
		return false;
	}
	
	//解题思路三：直接利用Log函数
	private static boolean isPowerOfThree2(int n){
		double res = Math.log(n)/Math.log(3);
		return Math.abs(res - Math.rint(res)) < 0.0000000001;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(isPowerOfThree(n) + "\t" + isPowerOfThree1(n) + "\t" + isPowerOfThree2(n));
		}
	}	
}
