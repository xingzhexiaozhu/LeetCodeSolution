import java.util.Scanner;

//题意描述：给定一个整数，判断它是否为2的N次

public class PowerOfTwo {

	//解题思路一：2的N次幂都只有各位上只有一个1，剩下的全为0，所以可以参考NumberOfOneBits的思路
	//如果只有1个位上有1，则为2的幂指数
//	private static boolean isPowerOfTwo(int n) {
//		int count = 0;
//		while(n != 0){
//			count += n&1;
//			n>>>=1;
//		}
//		return count == 1;//对负数不可使用
//	}
	private static boolean isPowerOfTwo(int n){
		int count = 0;
		while(n>0){
			count += (n&0x01);
			n>>=1;
		}
		return count==1;
	}
	
	//解题思路二：同上一个题目，调用Integer.bitCount()直接得到1的个数，为1则是2的倍数
	private static boolean isPowerOfTwo1(int n) {		
		return Integer.bitCount(n) == 1;//同上
	}
	
	
	//解题思路三：2的幂指数的特点是最高位为1剩下位全为0，所以将该数减1得到最高为0其他位全1
	//所以将该数与该数减1后二者执行“与”操作，结果为0则原数为2的幂指数
	private static boolean isPowerOfTwo2(int n){
		return (n>0)&&((n&(n-1))==0);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(isPowerOfTwo(n) + "\t" + isPowerOfTwo2(n));
		}
	}
}
