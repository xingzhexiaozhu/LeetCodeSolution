
//题意描述：移除已排序数组内的相同元素，使得每个元素只出现一次，返回新的长度

//解题思路：

public class RemoveDuplicatesFromSortedArray {

	private static int removeDuplicates(int[] nums) {
		if(nums.length < 1)//当数组长度小于1时不可能有重复元素
			return nums.length;
		
		int index = 0;
		for(int i=1; i<nums.length; i++){
			if(nums[index] != nums[i]){
				nums[++index] = nums[i];
			}
		}
		
		return index+1;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,2};
		System.out.println(removeDuplicates(nums));
	}	
}
