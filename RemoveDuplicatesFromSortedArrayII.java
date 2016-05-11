
//题意描述：移除已排序数组中相同的元素，这里每个元素最多允许出现两次

public class RemoveDuplicatesFromSortedArrayII {

	//跟上一题思路一样，但这里从i=j=2开始，因为是排序好的数组，所以如果a[j]=a[i-2]，j++，否则用后一个元素覆盖前一个元素
	//则说明该元素出现次数超过了2次，则用下一个元素覆盖该元素
	private static int removeDuplicates(int[] nums) {
		if(nums.length < 2)
			return nums.length;
		
		int index = 2;
		for(int i=2; i<nums.length; i++){
			if(nums[i] != nums[index-2])
				nums[index++] = nums[i];
		}

		return index;
	}	

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		System.out.println(removeDuplicates(nums));			
	}

}
