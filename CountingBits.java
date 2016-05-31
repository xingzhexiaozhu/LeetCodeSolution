import java.util.Scanner;

//题意描述：给定一个非负整数num，计算0<=i<=num这个范围中每个数字是由多少个1组成

public class CountingBits {

	//解题思路一：借鉴NumberOf1Bits解题思路，依次求得每个数字的1的个数，最后返回数组	
	private static int NumbersOf1Bits(int n) {
		int count = 0;
		while(n != 0){
			count++;
			n = n & (n-1);//把一个数字与该数字减去1后再与，就会将二进制形式的最后一位1转化为0，有多少个1进行多少次操作即可
		}
		return count;
	}
	private static int[] countBits(int num) {
		int[] result = new int[num+1];
		for(int i=0; i<result.length; i++)
			result[i] = NumbersOf1Bits(i);
		return result;
	}

	//解题思路二：解法一的思路对于数字num并没有运用数字num之前的结果进行求解，而是每个数字都单独计算
	//对于2^N的数，末尾N-1位的重复规律，正好等于前N-1个数的重复规律，而这时只需要加1即可
	private static int[] countBits1(int num){
		int[] result = new int[num+1];
		result[0] = 0;
		int base = 1;
		while(base <= num){
			int next = base * 2;
			for(int i=base; i<next && i<= num; i++)
				result[i] = result[i-base]+1;
			base = next;
		}
		return result;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int num = sc.nextInt();
			int[] res = countBits1(num);
			for(int i=0; i<res.length; i++)
				System.out.print(res[i] + " ");
			System.out.println();
		}
	}

}
