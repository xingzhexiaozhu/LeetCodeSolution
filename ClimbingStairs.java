import java.util.Scanner;

//You are climbing a stair case. It takes n steps to reach to the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class ClimbingStairs {

	//����˼·һ���ݹ�
	//����һ����n������;������n:(1)��n-1��n;(2)��n-2��n.
//	public static int climbStairs(int n){
//		if(n == 1) return 1;
//		if(n == 2) return 2;
//		return climbStairs(n-1) + climbStairs(n-2);
//	}	
	
	//����˼·�����Შ��������(0,1,1,2,3,5,8,13,21,34,55...)
	//���ڵݹ���⵱n��һ���̶�ʱ�ݹ����̫���������Ҫ�ڴ�ָ�������������Შ��������ÿһ����ǵ���n������ʱ����������
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
