import java.util.HashMap;

//题意描述：给定一个整数数组，找出其中两个数满足相加等于指定目标数字
//Given nums = [2, 7, 11, 15], target = 9,
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return[0, 1].

public class TwoSum {

	//解法一：暴力解决，双层循环遍历，依次求出满足要求的数字
	private static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		
		for(int i=0; i<nums.length-1; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[i] + nums[j] == target){
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		
		return result;
	}
	
	//解法二：由于解法一的暴力解法当输入的数组过大，时间复杂度O(n^2)就会很大
	//所以这里考虑空间换时间的概念，而对于查找一般用Hash表比较常用
	private static int[] twoSum1(int[] nums, int target){
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<nums.length; i++){
			if(!map.containsKey(nums[i]))
				map.put(target-nums[i], i);
			else{
				result[0] = map.get(nums[i]);
				result[1] = i;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 18;
		
		int[] result = twoSum(nums, target);
		System.out.println(nums[result[0]] + " " + nums[result[1]]);
		
		int[] result1 = twoSum1(nums, target);
		System.out.println(nums[result1[0]] + " " + nums[result1[1]]);
	}

}
