
//��������������һ������n�����������飬���س˻����飨�˻������i����Ԫ�ر�ʾԭ����˻��в�����iλ�����Ļ���

public class ProductOfArrayExceptSelf {

	//����˼·һ���������������ĳ˻���Ȼ����㵱ǰλ�õĳ˻�ʱ�ٳ��Ե�ǰ���־Ϳ�����
	private static int[] productExceptSelf(int[] nums) {
		int totalProduct = 1;
		for(int num : nums)
			totalProduct *= num;

		int[] res = new int[nums.length];
		for(int i=0; i<nums.length; i++){
			res[i] = totalProduct / nums[i];
		}
		
		return res;
	}
	
	//����˼·����������Ŀ��ȷҪ���ó������㣬�����������ⷽ��������Ҫ��
	//����������̷����μ��㣺
	//��1������������㣬�õ���i���ұ�����Ԫ�صĻ���������res[i]��
	//��2���������Ҽ��㣬temp��ʾ��i���������Ԫ�صĻ���
	//���Ľ�����ǵ��µ�temp��res[i]�ĳ˻�
	private static int[] productExceptSelf2(int[] nums) {
		int[] res = new int[nums.length];//������飬������ս��
		res[nums.length-1] = 1;
		for(int i=nums.length-2; i>=0; i--)
			res[i] = res[i+1] * nums[i+1];		
		
		int temp = 1;
		for(int i=0; i<nums.length; i++){
			res[i] *= temp;
			temp *= nums[i];
		}

		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] res = productExceptSelf2(nums);
		for(int num : res)
			System.out.print(num + " ");
		System.out.println();
	}

}
