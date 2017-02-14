import java.util.Scanner;

//题意描述：（变态爬楼梯）共有N个台阶，第次可以爬1步、2步……N步，问共有多少种方法爬完楼梯

public class ClimbingStairsII {

	//解题思路一：观察规律发现
	//n=1 res=1;   
	//n=2 res=2;   
	//n=3 res=4(111,12,21,3);
	//n=4 res=8(1111,211,121,112,22,13,31,4);  
	//n=5 res=16(11111,1112,1121,1211,2111,122,212,221,23,32,311,131,113,14,41,5)
	//...
	//规律就是n个台阶，就是将n个1进行组合，看有多少种结果
	//也可以理解为：每个台阶都有跳与不跳两种情况（除了最后一个台阶），最后一个台阶必须跳. 所以共用2^(n-1)中情况
	private static int climbingStairsII(int n) {		
		return (int)Math.pow(2, n-1);
	}
	
	//解题思路二：分析如下:
	//f(1) = 1
	//f(2) = f(2-1) + f(2-2)         //f(2-2) 表示2阶一次跳2阶的次数。
	//f(3) = f(3-1) + f(3-2) + f(3-3) 
	//...
	//f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-(n-1)) + f(n-n) 
	 
	//说明： 
	//1) 这里的f(n) 代表的是n个台阶有一次1,2,...n阶的 跳法数。
	//2) n = 1时，只有1种跳法，f(1) = 1
	//3) n = 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2) 
	//4) n = 3时，会有三种跳得方式，1阶、2阶、3阶，
	//    那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3)
	//    因此结论是f(3) = f(3-1)+f(3-2)+f(3-3)
	//5) n = n时，会有n中跳的方式，1阶、2阶...n阶，得出结论：
	//    f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)
	//6) 由以上已经是一种结论，但是为了简单，我们可以继续简化：
	//    f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
	//    f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
	//    可以得出：
	//    f(n) = 2*f(n-1)
	//7) 得出最终结论,在n阶台阶，一次有1、2、...n阶的跳的方式时，总得跳法为：
	//             | 1       ,(n=0 ) 
	//f(n) =       | 1       ,(n=1 )
	//             | 2*f(n-1),(n>=2)
	private static int climbingStairsII2(int n){
		if(n <= 0)
			return -1;
		else if(n == 1)
			return 1;
		else return 2*climbingStairsII2(n-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(climbingStairsII(n) + " " + climbingStairsII2(n));
		}
	}
}
