import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

//题意描述：给定一个数组，数组只有一个元素出现了一次其他元素均出现三次，找出只出现一次的元素

public class singleNumberII {

	//解题思路：singleNumber的解法一
	private static int singleNumber(int[] nums) {
		int res = -1;
		if(nums==null || nums.length<=0)
			return res;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			if(!map.containsKey(nums[i]))
				map.put(nums[i], 1);
			else{
				int val = map.get(nums[i]);
				map.put(nums[i], val+1);
			}
		}		
		
		for(Map.Entry<Integer, Integer> entry:map.entrySet()){
			if(entry.getValue() == 1)
				res = entry.getKey();
		}
		
		return res;
	}	
	
	//解题思路二：用二进制模拟三进制运算
	private static int singleNumber2(int[] nums){
		int one=0, two=0, three=0;
//		for(Integer num : nums){
//			two |= (one & num);
//			one ^= num;
//			three = ~(one & two);
//			one &= three;
//			two &= three;
//		}
		
		return one;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,6,5,4,3,1};
		System.out.println(singleNumber(nums) + "\t" + singleNumber2(nums));
	}

}
