import java.util.Scanner;

//You are climbing a stair case. It takes n steps to reach to the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class ClimbingStairs {

	//解题思路一：递归
	//给定一个数n有两种途径到达n:(1)从n-1到n;(2)从n-2到n.
//	public static int climbStairs(int n){
//		if(n == 1) return 1;
//		if(n == 2) return 2;
//		return climbStairs(n-1) + climbStairs(n-2);
//	}	
	
	//解题思路二：裴波那契数列(0,1,1,2,3,5,8,13,21,34,55...)
	//由于递归解题当n大到一定程度时递归层数太多而导致需要内存指数级递增，而裴波那契数列每一项就是到第n个阶梯时爬的种类数
	public static int climbStairs(int n){
		int a = 0;
		int b = 1;
		int sum = 0;
		for(int i=0; i<n; i++){
			sum = a + b;
			a = b;
			b = sum;
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while((n = sc.nextInt()) != -1){
			System.out.println(climbStairs(n));
		}
	}

}
