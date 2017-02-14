import java.util.Scanner;

//题意描述：Given a positive integer, output its complement number. 
//The complement strategy is to flip the bits of its binary representation.

//Example 1:
//Input: 5
//Output: 2
//Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

//Example 2:
//Input: 1
//Output: 0
//Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.


public class NumberComplement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int num = sc.nextInt();
			System.out.println(findComplement(num) + "\t" + findComplement2(num));
		}
	}

	//钥匙思路一：(2^x-1)正好大于n，则所求为(2^x-1-n)
	private static int findComplement(int n) {
//		return (int)Math.pow(2, log(n,2)+1) - 1 - n; //有问题，2147483647   应该返回0
		
//		int x = (int)Math.pow(2, log(n,2)+1) - 1;    //也有问题，2147483646 应该返回1
//		return ~n & x;

		return (int)Math.pow(2, log(n, 2)) - 1 - n;
	}
	private static int log(int value, int base){
		return (int)Math.ceil((Math.log(value)/Math.log(base)));
	}
	
	//解题思路二：
	private static int findComplement2(int n) {
		return ~n & ((Integer.highestOneBit(n) << 1) - 1);
	}

}
