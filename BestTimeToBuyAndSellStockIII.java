
//������������һ�������ʾ��Ʊÿ��ļ۸�����ĵ�i������ʾ��Ʊ�ڵ�i��ļ۸�
//��������������ν��ף���������֮ǰ����������֮ǰ�Ĺ�Ʊ�����������

public class BestTimeToBuyAndSellStockIII {
	
	//����˼·һ���Ե�i��Ϊ�ֽ��ߣ������i��֮ǰ����һ�ν��׵��������preProfit[i]��
	//�͵�i��֮�����һ�ν��׵��������postProfit[i]��������һ�飬
	//max{preProfit[i] + postProfit[i]} (0��i��n-1)����������档
	//��i��֮ǰ�͵�i��֮�����һ�ε����������ͬBest Time to Buy and Sell Stock I
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
	
	//����˼·������4������ά����Ϣ������һ֧��Ʊ��������һ֧��Ʊ����ʱ����ڶ�֧
	private static int maxProfit2(int[] prices) {
		if(prices == null || prices.length == 0)
			return 0;
		
		int firstBuy = Integer.MIN_VALUE, secondBuy = Integer.MIN_VALUE;
		int firstSell = 0, secondSell = 0;
		for(int curPrice : prices){
			if(firstBuy < -curPrice)//�����һ֧��Ʊʱ��������
				firstBuy = -curPrice;
			if(firstSell < firstBuy + curPrice)
				firstSell = firstBuy + curPrice;//������һ֧��Ʊ��������
			if(secondBuy < firstSell - curPrice)
				secondBuy = firstSell - curPrice;//����ڶ�֧��Ʊʱ��������
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
