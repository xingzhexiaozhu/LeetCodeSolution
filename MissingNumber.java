import java.util.HashSet;
import java.util.Set;

//题意描述：给定包含n个数组的数字，数字取自[0,1,2,...,n]，找到缺失的那一个数字
//如：给定nums=[0,1,3]返回2

public class MissingNumber {

	//解题思路一：自然想到的方法一就是先对数组进行排序，然后查找值与下标对应的关系，如果不满足value=index+1
	//则返回(index+1)即为所求
	private static int missingNumber(int[] nums) {
		if(nums==null || nums.length<=0)
			return -1;
		
		for(int i=0; i<nums.length-1; i++){
			boolean flag = false;//标志位
			for(int j=nums.length-1; j>i; j--){
				if(nums[j] < nums[j-1]){
					int temp = nums[j];
					nums[j] = nums[j-1];
					nums[j-1] = temp;
					flag = true;
				}
			}
			if(flag == false)
				break;
		}
		int value = 0;
		for(int i=0; i<nums.length; i++){
			if(nums[i] != i){
				value = i;
				break;
			}
		}
		return value;
	}
	
	//解题思路二：由于题目要求在线性时间复杂度内完成，而排序后最优也得O(nlogn)，因此上面的解法不满足题意
	//想到借助set集合，先将数字存到set中，然后遍历，如果不在set中则返回该数字
	private static int missingNumber2(int[] nums){
		if(nums==null || nums.length<=0)
			return -1;
		
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<nums.length; i++)
			set.add(nums[i]);
		int value = -1;
		for(int i=0; i<=nums.length; i++){
			if(!set.contains(i)){
				value = i;
				break;
			}
		}
		return value;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,1,3};
		System.out.println(missingNumber(nums) + "\t" + missingNumber2(nums));
		
		int[] nums2 = {0,2,5,3,1};
		System.out.println(missingNumber(nums2) + "\t" + missingNumber2(nums2));
	}

}