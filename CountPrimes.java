import java.util.Scanner;

//问题描述：输入整数N，输出比N小的整数素数的个数

public class CountPrimes {

	//解题思路一：从1~N逐一判断是否为素数
	private static boolean IsPrimes(int n) {//判断数字N是否为素数
		if(n <= 1)
			return false;
		for(int i=2; i<=Math.sqrt(n); i++){
			if(n % i == 0)
				return false;
		}
		return true;
	}	
	private static int countPrimes(int n) {
		int count = 0;
		for(int i=2; i<n; i++){
			if(IsPrimes(i))
				++count;
		}
		
		return count;
	}
	
	//解题思路二：上面的解题方法明显有冗余计算（对于每一个数字都会从2开始计算），提交会得到超时错误
	//素数不能被比它小的数整除，所以可以用标记数组将小于N的非素数都删掉
	private static int CountPrimes1(int n){
		boolean[] flag = new boolean[n];
		for(int i=2; i*i<n; ++i){
			if(!flag[i]){
				for(int j=i; i*j<n; j++)
					flag[i*j] = true;
			}
		}
		
		int count = 0;
		for(int i=2; i<n; i++)
			if(flag[i] == false)
				++count;
		
		return count;
	}
	
	public static void main(String[] args) {			
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(countPrimes(n) + " " + CountPrimes1(n));
		}
	}

}
