
//题意描述：假设你是一个盗贼，盗取一条街道上的房间，唯一能阻止你的是两相邻房间有安全系统会自动报警
//现给定一组非负的整数代表每个房间的金钱数量，请问在不触发警报系统的情况下一晚最多能盗多少钱？

public class HouseRobber {

	//解题思路一：这样的题目明显是考察动态规则的问题。对于第n个房间偷与不偷取决于上一步：
	//如果决定偷则上一步必须是不偷，则这一步就是dp[N]=num[i-1]+dpNonTake[N-1]，dp[N]表示的是有N个元素时候的最大值状态
	//如果不偷，则 dp[N]=dp[N-1]即可，所以总而言之所以总而言之为 dp[N]=Math.max(dpNontake[N-1]+num[i],dp[N-1]);
	//则迭代算法为：
	//take = nonTake + num[i];  偷
	//nonTake = maxProfit;    不偷 
	//maxProfit = Math.max(take,nonTake); 求最大利润
	//时间复杂度为O(n) 空间为O(1) 能运行的代码为：
	public static int rob(int[] nums){
		if(nums==null || nums.length==0)
			return 0;
		
		int take = 0;
		int maxProfit = 0;
		int nonTake = 0;
		for(int i=0; i<nums.length; i++){
			take = nonTake + nums[i];
			nonTake = maxProfit;
			maxProfit = Math.max(take, nonTake);
		}
		return maxProfit;
	}
	
	//或用数组存储中间结果：维持两个数组，一个是包含当前最后一项的最大值，一个是不包含当前最后一项的最大值
	//不断更新，最终返回max(take[nums.length-1],nonTake[nums.length-1])
	public static int rob1(int[] nums){
		if(nums==null || nums.length==0)
			return 0;
		
		int[] take = new int[nums.length];
		int[] nonTake = new int[nums.length];
		
		take[0] = nums[0];
		nonTake[0] = 0;
		for(int i=1; i<nums.length; i++){
			take[i] = nonTake[i-1] + nums[i];
			nonTake[i] = Math.max(take[i-1], nonTake[i-1]);
		}
		return Math.max(take[nums.length-1], nonTake[nums.length-1]);
	}
	
	public static void main(String[] args) {
		int[] nums = {8, 3, 6, 15, 4, 9, 7, 10};
		System.out.println(rob(nums) + " " + rob1(nums));
	}

}
