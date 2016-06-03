
//������������һ�������ʾ��Ʊÿ��ļ۸�����ĵ�i������ʾ��Ʊ�ڵ�i��ļ۸� ���ֻ�������һ�ν��ף�Ҳ����˵ֻ������һ֧��Ʊ������������������

public class BestTimeToBuyAndSellStock {

	//����˼·������ȷ���⣬�������Ʊ���������.
	//ע��:(1)��ɼ�ʱ�������ɼ�ʱ��ǰ�棻
	//(2)������ȡ��ĿǰΪֹ��С�ļۣ���������ȡ�������ʼ�ļۼ�ȥ�ѵõ���С���������Ϊ�������
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
