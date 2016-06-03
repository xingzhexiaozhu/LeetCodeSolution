
//题意描述：用一个数组表示股票每天的价格，数组的第i个数表示股票在第i天的价格。
//允许进行多次交易，但在买入之前必须先卖掉之前的股票。求最大收益

public class BestTimeToBuyAndSellStockII {

	//解题思路：贪心法，本题和前面的BestTimeToBuyAndSellStock不同在于本题可以多次买卖股票，
	//贪心法就是锁定一个低价然后在价格升到局部最高点时卖出，然后再把下一天较低买入，即只要有获利空间就不断买入卖出赚钱
	private static int maxProfit(int[] prices) {
		if(prices.length == 0)
			return 0;
		
		int totalProfit = 0;
		for(int i=1; i<prices.length; i++)
			if(prices[i] > prices[i-1])
				totalProfit += prices[i]-prices[i-1];
		
		return totalProfit;
	}

	public static void main(String[] args) {
		int[] prices = {5,4,9,7,2,3,8};
        System.out.println(maxProfit(prices));
	}

}
