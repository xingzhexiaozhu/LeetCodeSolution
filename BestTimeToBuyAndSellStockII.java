
//������������һ�������ʾ��Ʊÿ��ļ۸�����ĵ�i������ʾ��Ʊ�ڵ�i��ļ۸�
//������ж�ν��ף���������֮ǰ����������֮ǰ�Ĺ�Ʊ�����������

public class BestTimeToBuyAndSellStockII {

	//����˼·��̰�ķ��������ǰ���BestTimeToBuyAndSellStock��ͬ���ڱ�����Զ��������Ʊ��
	//̰�ķ���������һ���ͼ�Ȼ���ڼ۸������ֲ���ߵ�ʱ������Ȼ���ٰ���һ��ϵ����룬��ֻҪ�л����ռ�Ͳ�����������׬Ǯ
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
