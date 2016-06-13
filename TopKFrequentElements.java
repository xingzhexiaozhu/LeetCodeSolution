import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//题意描述：给定一个整数数组和数字K，返回数组中出现最频繁的K个元素。如：
//输入[1,1,1,2,2,3]，K=2，返回[1,2]
//要求时间复杂度为O(nlogn)


public class TopKFrequentElements {

	//解题思路一：HashMap的key为元素，value为出现次数。对结果按value排序，返回前K个结果的value
	private static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : nums){
			Integer count = map.get(num);
			if(count == null)
				count = 0;
			map.put(num, count+1);
		}
		
		//对map结果根据value值进行排序
		List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {     
		    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {        
		        //return (o1.getKey() - o2.getKey());//根据key排序  
		        return (o2.getValue() - o1.getValue());//根据value排序  
		        //return (o1.getKey()).toString().compareTo(o2.getKey());  
		    }  
		});  
		
		int[] res = new int[k];
		for (int i = 0; i < entryList.size() && i<k; i++) {  
		   System.out.println(entryList.get(i));  
		   res[i] = entryList.get(i).getKey();
		}  
		
		return res;
	}

	
	public static void main(String[] args) {
		int[] nums = {1,3,3,2,2,3};
		int[] res = topKFrequent(nums, 2);
		for(int n : res)
			System.out.print(n + " ");
		System.out.println();
	}

}
