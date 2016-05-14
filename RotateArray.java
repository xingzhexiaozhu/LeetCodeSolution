import java.util.Arrays;

//题意描述：旋转字符串，字符串有n个字符，向右旋转k步。比如：array[1,2,3,4,5,6,7],n=7,k=3,旋转之后为[5,6,7,1,2,3,4]
//至少使用3种方法解决以上问题

public class RotateArray {

	//解题思路一：转换成字符串，旋转字符串问题【超时】
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
	
	//解题思路二：类似于冒泡排序，空间复杂度为O(1)【超时】
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
	
	//解题思路三：上面的做都超时，能否有一个时间复杂度为O(n)、空间复杂度为O(1)的解法
	//将数组分为两部分，(nums.length-k~nums.length-1)，(0~nums.length-k-1)
	//分别反转两个子数组，然后再整体反转即可
	private static void rotate2(int[] nums, int k){
		if(nums==null || nums.length==0)
			return;
		
		k = k%nums.length;//比较关键，因为k表示向旋转步，如果k>nums.length也是被允许的
		
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
