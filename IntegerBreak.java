import java.util.Scanner;

//题意描述：将一个整数分解成至少两个数字之和的形式，求所有组合中因子乘积最大的分解，并返回该最大乘积
//比如：n=2,返回1（2=1+1）； n=10,返回36（10=3+3+4）

public class IntegerBreak {

	//解题思路：先找规律4=2+2,return 4;     5=3+2,return 6;     6=3+3,return 9     7=4+3,return 12
	// 8=3+3+2,return 18     9=3+3+3,return 27     10=3+3+4,return 36     11=3+3+3+2,return 54
	//（1）可以发现因为4可以分解为2*2，而2*2的积又是4，所以可以数字分解到4就不必再细分；
	//（2）分解因子全为2和3时乘积最大，同时要尽可能多的3；
	//（3）当n%3==0时，因子全为3且3的个数为(n/3)乘积最大；当n%3==1时，因子3的个数为(n/3)-1乘积最大；当n%3==2时，因子3的个数为(n/3)
//	private static int integerBreak(int n) {
//		if(n < 2) return 0;
//		else if(n == 2) 
//			return 1;
//		else if(n == 3)
//			return 2;
//		
//		int mod = n % 3;//先得到模3的余数
//		int product = 1;//最终的乘积
//		int count = 0;  //因子3的个数
//		if(mod == 1)
//			count = n/3 - 1;
//		else count = n/3;
//		
//		while(count > 0){
//			product *= 3;
//			--count;
//		}
//		
//		if(mod == 1) product *= 4;
//		else if(mod == 2) product *= 2;
//			
//		return product;
//	}
	private static int integerBreak(int n) {
		if(n < 0)
			return 0;
		if(n < 4)
			return n-1;
		
		int product = 1;
		while(n > 4){
			product *= 3;
			n -= 3;
		}
		return product * n;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(integerBreak(n));
		}
	}

}
