import java.util.Scanner;

//题目：Write a program to find the nth super ugly number.Super ugly numbers are positive numbers whose all prime 
//factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] 
//is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

//大意就是：给定长度为k的质因子正数列表，编写程序寻找第N个SuperUglyNumber。
//例如给定长度为4的质数序列primes=[2,7,13,19]，则前12个SuperUglyNumber序列为 [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32]

public class SuperUglyNumber {

	//解题思路：跟UglyNumberII思路一样，依次由小SuperUglyNumber乘给定的质数序列，生成新的SuperUglyNumber，至第N个为止
	private static int nthSuperUglyNumber(int n, int[] primes) {
		int[] superUglyNumbers = new int[n];//存放1-n个SuperUglyNumber
		superUglyNumbers[0] = 1;//第一个SuperUglyNumber是1
		int[] index = new int[primes.length];
		for(int i=0; i<index.length; i++)
			index[i] = 0;//初始化
		
		int counter = 1;
		while(counter < n){
			int min = Integer.MAX_VALUE;
			for(int i=0; i<primes.length; i++){
				int temp = superUglyNumbers[index[i]] * primes[i];
				min = min < temp ? min : temp;
			}
			
			for(int i=0; i<primes.length; i++)
				if(min == superUglyNumbers[index[i]] * primes[i])
					index[i]++;
			
			superUglyNumbers[counter++] = min;			
		}
		
//		for(int i=0; i<superUglyNumbers.length; i++)
//			System.out.print(superUglyNumbers[i] + " ");
//		System.out.println();
		
		return superUglyNumbers[n-1];		
	}
	
	
	public static void main(String[] args) {
		int n = 12;
		int[] primes = {2,7,13,19};
		System.out.println(nthSuperUglyNumber(n, primes));
	}
	
}
