import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//题意描述：找出给定两个数组的交叉（公共）部分
//比如：nums1=[1,2,2,1],nums2=[2,2], 返回[2,2]
//可以看到每个元素出现的次数是其在两个数组中一共出现的次数

public class IntersectionOfTwoArraysII {

	//解题思路：借鉴IntersectionOfTwoArrays的解法，这里可以借用HashMap方法，先将一个数组中的元素放入，key为对应的元素，value为出现次数
	//然后遍历另一个数组，如果出现则加入List中，然后value减1，当value为0时可以删除该元素
	private static int[] intersection(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null)
			return null;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<nums1.length; i++){
			if(!map.containsKey(nums1[i]))
				map.put(nums1[i], 1);//如果该元素没有出现过则在map中加入该元素，<nums[i],1>
			else{//如果该元素出现过，则先得到已存在的value值，再赋值为value+1
				int value = map.get(nums1[i]);
				map.put(nums1[i], value+1);
			}
		}
		
		for(int i=0; i<nums2.length; i++){
			if(map.containsKey(nums2[i])){
				if(map.get(nums2[i]) == 1){
					list.add(nums2[i]);
					map.remove(nums2[i]);
				}else{
					list.add(nums2[i]);
					int value = map.get(nums2[i]);
					map.put(nums2[i], value-1);
				}
			}
		}
		
		int[] res = new int[list.size()];
		for(int i=0; i<list.size(); i++)
			res[i] = list.get(i);
		return res;
		
	}

	
	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		
		int[] result = intersection(nums1, nums2);
		for(int num:result)
			System.out.print(num + " ");
		System.out.println();
	}
	
}
