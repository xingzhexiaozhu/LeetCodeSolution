
//题意描述：给定一个包含n个整数的数组，返回乘积数组（乘积数组第i处的元素表示原数组乘积中不包含i位置数的积）

public class ProductOfArrayExceptSelf {

	//解题思路一：先求出整个数组的乘积，然后计算当前位置的乘积时再除以当前数字就可以了
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
	
	//解题思路二：由于题目明确要求不用除法计算，所以上述解题方法不满足要求
	//整个计算过程分两次计算：
	//（1）从右向左计算，得到第i项右边所有元素的积，并存入res[i]；
	//（2）从左向右计算，temp表示第i项左边所有元素的积；
	//最后的结果就是当下的temp与res[i]的乘积
	private static int[] productExceptSelf2(int[] nums) {
		int[] res = new int[nums.length];//结果数组，存放最终结果
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
