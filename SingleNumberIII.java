import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

//题意描述：给定一个数组，数组只有两个元素出现了一次其他元素均出现两次，找出只出现一次的两个元素
//如{1,2,1,3,2,5}返回{3,5}

public class SingleNumberIII {

	//解题思路一：HashSet
	private static int[] singleNumber(int[] nums){
		int[] res = new int[2];
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<nums.length; i++){
			if(!set.contains(nums[i]))
				set.add(nums[i]);
			else
				set.remove(nums[i]);
		}
		
		Iterator it = set.iterator();
		int count = 0;
		while(it.hasNext()){
			res[count++] = (int) it.next();
		}
		
		return res;
	}
	
	//解题思路二：本题中有两个不同数字，那么再按照SingleNumber解题就不能得到最终结果了
	//因此，思路是将所有数字按一定规则分成两组，然后分别做异或运算，就可以得到两个不同的数，即为所求
	//按二进制的规则，如果两个数不同，则二进制表示中至少有一个二进制位是不同的（即一个是0另一个是1），因为按这个规则将所有数字分成两组
	private static int[] singleNumber2(int[] nums){		
		int diff = 0;
		for(int num : nums)
			diff ^= num;
		
		diff = Integer.highestOneBit(diff);
		int[] res = new int[2];
		Arrays.fill(res, 0);
		
		for(int num : nums){
			if((diff & num) == 0)
				res[0] ^= num;
			else res[1] ^= num;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,1,3,2,5};
		int[] res = singleNumber2(nums);
		for(Integer num : res)
			System.out.print(num + " ");
		System.out.println();
	}

}
