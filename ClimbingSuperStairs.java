import java.util.Scanner;

//题意描述：有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或者二级，要走上m级，共有多少走法？注：规定从一级到一级有0种走法。
//给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100。为了防止溢出，请返回结果Mod 1000000007的值。
//测试样例：
//输入：3
//返回：2

public class ClimbingSuperStairs {

	private static int countWays(int n) {
		int[] res = new int[n];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        for(int i=3; i<n; i++)
            res[i] = (res[i-1] + res[i-2]) % 1000000007;
         
        return res[n-1];
	}
	
	private static int countWays2(int n){
		int res=0, a=0, b=1;
		for(int i=1; i<n; i++){
			res = (a + b) % 1000000007;
			a = b;
			b = res;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(countWays(n) + " " + countWays2(n));
		}
	}

}
