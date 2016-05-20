import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//题意描述：找出给定两个数组的交叉（公共）部分，重复的公共元素只出现一次
//比如：nums1=[1,2,2,1],nums2=[2,2],返回[2]

public class IntersectionOfTwoArrays {

	//解题思路：使用Set存入第一个数组的值，遍历第二个数组，如果第二个数组中的数字在Set中出现过，则为公共元素
	//同时保证重复元素在结果中只出现一次，需要动态删除Set中前面遍历过程中出现过的元素
	private static int[] intersection(int[] nums1, int[] nums2) {
		if(nums1==null || nums2==null)
			return null;
		
		HashSet<Integer> set = new HashSet<Integer>();
		List<Integer> resList = new ArrayList<Integer>();
		
		for(int i=0; i<nums1.length; i++){
			if(!set.contains(nums1[i]))//将数组一中的元素加入set中
				set.add(nums1[i]);
		}
		
		for(int i=0, count=0; i<nums2.length; i++){
			if(set.contains(nums2[i])){//如果数组二中的元素在set中出现过
				resList.add(nums2[i]);//则为公共元素
				set.remove(nums2[i]); //同时为避免后面重复出现，从set中删除该元素
			}
		}
		
		int[] res = new int[resList.size()];
		for(int i=0; i<resList.size(); i++)
			res[i] = resList.get(i);
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
