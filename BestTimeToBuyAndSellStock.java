
//题意描述：用一个数组表示股票每天的价格，数组的第i个数表示股票在第i天的价格。 如果只允许进行一次交易，也就是说只允许买一支股票并卖掉，求最大的收益

public class BestTimeToBuyAndSellStock {

	//解题思路：先明确题意，即求买股票的最大利润.
	//注意:(1)买股价时间在卖股价时间前面；
	//(2)买入是取到目前为止最小的价，卖出则是取从买入后开始的价减去已得的最小价中最大差价为最大利润；
	private static int maxProfit(int[] prices) {
		if(prices==null||prices.length==0){
			return 0;
		}
		
		int curMin=Integer.MAX_VALUE;
		int profit = 0;
		for(int i=0; i<prices.length; i++){
			//curMin = prices[i] < curMin ? prices[i] : curMin;
			//profit = (prices[i] - curMin) > profit ? (prices[i]-curMin) : profit;
			curMin = Math.min(curMin, prices[i]);
			profit = Math.max(prices[i]-curMin, profit);
		}
		return profit;
	}

	
	public static void main(String[] args) {
		int[] prices = {5,4,9,7,2,3,8};
		System.out.println(maxProfit(prices));
	}
	
}
