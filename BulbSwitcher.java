import java.util.Scanner;

//题意描述：给定n个灯泡，初始化全为off，第一趟全问部on，第二趟将每第二个off，第三趟将每第三个反转……第n趟将第n个反转
//最后返回灯泡处于on的数目。如下描述：
//Given n = 3：
//At first, the three bulbs are [off, off, off].
//After first round, the three bulbs are [on, on, on].
//After second round, the three bulbs are [on, off, on].
//After third round, the three bulbs are [on, off, off]. 
//So you should return 1, because there is only one bulb is on.

public class BulbSwitcher {

	//解题思路一：可以发现当n=1,2,3时返回1；从4开始，依次判断当前灯是否亮，如果亮则计数加1
	private static int bulbSwitcher(int n) {
		if(n <= 0)
			return 0;
		int res = 1;
		for(int i=4; i<=n; i++){
			if(isOn(i))
				res++;
		}
		return res;
	}
	private static boolean isOn(int k){//判断第k个灯是否亮着
		//判断的方法就是从2到当前数k，如果出现k的因子，则其状态反转一次
		boolean flag = true;
		for(int i=2; i<=k; i++){
			if(k % i == 0)
				flag = !flag;
		}
		return flag;
	}
	
	//解题思路二：上面的解题思路没有用到灯泡数n与反转次数的关系，从而导致了当n过大时运行超时
	//观察上面运行的结果：[1,3]---1;  [4,8]---2;  [9,15]---3;  [16,24]---4;  [25,35]---5
	//发现从[i,i*(i+2)]---i
	private static int bulbSwitcher2(int n){
		if(n <= 0)
			return 0;
		else
			return (int)Math.sqrt(n);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int n;
		while(sc.hasNext()){
			n = sc.nextInt();
			System.out.println(bulbSwitcher(n) + "\t" + bulbSwitcher2(n));
		}
	}

}
