import java.util.Scanner;

//题意描述：给定一个整数n，返回n!中0的个数

//解题思路：依次计算1~10的阶乘，可以发现规律---每逢一对2*5，最终的结果中便新增一个0
//而对于一个结果分解，2的个数一定远多于5的个数，所以转化为一个数能被多少个5整除。计算5的个数时, 最简单的方法是 SUM(N/5^1,  N/5^2, N/5^3...)
//因此只要计数5的个数就可以了。那么怎样计算n!的质因子中所有5的个数呢？一个简单的方法是计算floor(n/5)。
//例如，7!有一个5，10!有两个5。除此之外，还有一件事情要考虑。诸如25，125之类的数字有不止一个5。
//例如，如果我们考虑28!，我们得到一个额外的5，并且0的总数变成了6。处理这个问题也很简单，首先对n÷5，移除所有的单个5，然后÷25，移除额外的5，以此类推：
//n!后缀0的个数 = n!质因子中5的个数 = floor(n/5) + floor(n/25) + floor(n/125) + ....

public class FactorialTrailingZeroes {

	private static int trailingZeroes(int n) {
		if(n < 0) return 0;
		int count = 0;
		while(n/5 != 0){
			n = n/5;
			count += n;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(trailingZeroes(n));
		}
	}	
}
