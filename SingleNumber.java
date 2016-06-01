import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

//题意描述：给定一个数组，数组只有一个元素出现了一次其他元素均出现两次，找出只出现一次的元素

public class SingleNumber {

	//解题思路：第一反应想到的是用HashMap数组结构，key是元素value是元素出现次数
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
	
	//解题思路二：可以用Set数据结构，每当元素出现第二次可以删除该元素，最后留下的即为所求
	private static int singleNumber2(int[] nums){
		int res = -1;
		if(nums==null || nums.length<=0)
			return res;
		
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<nums.length; i++){
			if(!set.contains(nums[i]))
				set.add(nums[i]);
			else
				set.remove(nums[i]);
		}
		
		if(set.isEmpty())
			return res;
		else{
			Iterator it = set.iterator();
			res = (int) it.next();
			return res;
		}
	}
	
	//解题思路三：以上两种方法提交后，成绩都不好，进一步思考有以下方法
	//异或运算的特点是同0异1，所以当出现相同数字就是抵消，最后留下的就是所求的数字
	private static int singleNumber3(int[] nums){
		int res = 0;	
		for(Integer num : nums)
			res ^= num;
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,5,4,2,1,3};
		System.out.println(singleNumber(nums) + "\t" + singleNumber2(nums) + "\t" + singleNumber3(nums));
	}

}
