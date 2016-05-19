
//������������������һ����������ȡһ���ֵ��ϵķ��䣬Ψһ����ֹ����������ڷ����а�ȫϵͳ���Զ�����
//�ָ���һ��Ǹ�����������ÿ������Ľ�Ǯ�����������ڲ���������ϵͳ�������һ������ܵ�����Ǯ��

public class HouseRobber {

	//����˼·һ����������Ŀ�����ǿ��춯̬��������⡣���ڵ�n������͵�벻͵ȡ������һ����
	//�������͵����һ�������ǲ�͵������һ������dp[N]=num[i-1]+dpNonTake[N-1]��dp[N]��ʾ������N��Ԫ��ʱ������ֵ״̬
	//�����͵���� dp[N]=dp[N-1]���ɣ������ܶ���֮�����ܶ���֮Ϊ dp[N]=Math.max(dpNontake[N-1]+num[i],dp[N-1]);
	//������㷨Ϊ��
	//take = nonTake + num[i];  ͵
	//nonTake = maxProfit;    ��͵ 
	//maxProfit = Math.max(take,nonTake); ���������
	//ʱ�临�Ӷ�ΪO(n) �ռ�ΪO(1) �����еĴ���Ϊ��
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
	
	//��������洢�м�����ά���������飬һ���ǰ�����ǰ���һ������ֵ��һ���ǲ�������ǰ���һ������ֵ
	//���ϸ��£����շ���max(take[nums.length-1],nonTake[nums.length-1])
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
