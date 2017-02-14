
//题意描述：用一个数组表示股票每天的价格，数组的第i个数表示股票在第i天的价格。
//至多允许进行两次交易，但在买入之前必须先卖掉之前的股票。求最大收益

public class BestTimeToBuyAndSellStockIII {
	
	//解题思路一：以第i天为分界线，计算第i天之前进行一次交易的最大收益preProfit[i]，
	//和第i天之后进行一次交易的最大收益postProfit[i]，最后遍历一遍，
	//max{preProfit[i] + postProfit[i]} (0≤i≤n-1)就是最大收益。
	//第i天之前和第i天之后进行一次的最大收益求法同Best Time to Buy and Sell Stock I
	private static int maxProfit(int[] prices){
		if(prices.length < 2)
			return 0;
		
		int n = prices.length;
        int[] preProfit = new int[n];
        int[] postProfit = new int[n];
        
        int curMin = prices[0];
        for (int i = 1; i < n; i++) {
            curMin = Math.min(curMin, prices[i]);
            preProfit[i] = Math.max(preProfit[i - 1], prices[i] - curMin);
        }
        
        int curMax = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            curMax = Math.max(curMax, prices[i]);
            postProfit[i] = Math.max(postProfit[i + 1], curMax - prices[i]);
        }
        
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, preProfit[i] + postProfit[i]);
        }
        
        return  maxProfit;
	}
	
	//解题思路二：用4个变量维护信息。先买一支股票，当将第一支股票卖掉时再买第二支
	private static int maxProfit2(int[] prices) {
		if(prices == null || prices.length == 0)
			return 0;
		
		int firstBuy = Integer.MIN_VALUE, secondBuy = Integer.MIN_VALUE;
		int firstSell = 0, secondSell = 0;
		for(int curPrice : prices){
			if(firstBuy < -curPrice)//买入第一支股票时所获利润
				firstBuy = -curPrice;
			if(firstSell < firstBuy + curPrice)
				firstSell = firstBuy + curPrice;//卖掉第一支股票所获利润
			if(secondBuy < firstSell - curPrice)
				secondBuy = firstSell - curPrice;//买入第二支股票时所获利润
			if(secondSell < secondBuy + curPrice)
				secondSell = secondBuy + curPrice;
		}		
		return secondSell;
	}
	
	

	public static void main(String[] args) {
		int[] prices = {5,4,9,7,2,3,8};
        System.out.println(maxProfit(prices));
	}
}
