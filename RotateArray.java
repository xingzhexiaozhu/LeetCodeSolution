import java.util.Arrays;

//������������ת�ַ������ַ�����n���ַ���������תk�������磺array[1,2,3,4,5,6,7],n=7,k=3,��ת֮��Ϊ[5,6,7,1,2,3,4]
//����ʹ��3�ַ��������������

public class RotateArray {

	//����˼·һ��ת�����ַ�������ת�ַ������⡾��ʱ��
	private static void rotate(int[] nums, int k) {
		if(nums==null || nums.length==0 || k>nums.length)
			return;
		String str = "";
		for(int i=nums.length-k; i<nums.length; i++)
			str += Integer.toString(nums[i]);
		for(int i=0; i<nums.length-k; i++)
			str += Integer.toString(nums[i]);
		System.out.println(str);
	}
	
	//����˼·����������ð�����򣬿ռ临�Ӷ�ΪO(1)����ʱ��
	private static void rotate1(int[] nums, int k){
		if(nums==null || nums.length==0 || k>nums.length)
			return;
		
		for(int i=0; i<k; i++){
			for(int j=nums.length-1; j>0; j--){
				int temp = nums[j];
				nums[j] = nums[j-1];
				nums[j-1] = temp;
			}
		}
		
		for(Integer n:nums)
			System.out.print(n);
		System.out.println();		
	}
	
	//����˼·���������������ʱ���ܷ���һ��ʱ�临�Ӷ�ΪO(n)���ռ临�Ӷ�ΪO(1)�Ľⷨ
	//�������Ϊ�����֣�(nums.length-k~nums.length-1)��(0~nums.length-k-1)
	//�ֱ�ת���������飬Ȼ�������巴ת����
	private static void rotate2(int[] nums, int k){
		if(nums==null || nums.length==0)
			return;
		
		k = k%nums.length;//�ȽϹؼ�����Ϊk��ʾ����ת�������k>nums.lengthҲ�Ǳ������
		
		reverse(nums, 0, nums.length-k-1);
		reverse(nums, nums.length-k, nums.length-1);
		reverse(nums, 0, nums.length-1);
		
		for(Integer n:nums)
			System.out.print(n);
		System.out.println();
	}
	private static void reverse(int[] num, int start, int end){
		if(num==null || num.length == 1)
			return ;
		while(start<end){
			int temp = num[start];
			num[start] = num[end];
			num[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		//rotate(nums,3);
		//rotate1(nums,3);
		rotate2(nums,3);
	}
	
}
