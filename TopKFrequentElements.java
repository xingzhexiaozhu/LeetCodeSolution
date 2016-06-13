import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//��������������һ���������������K�����������г�����Ƶ����K��Ԫ�ء��磺
//����[1,1,1,2,2,3]��K=2������[1,2]
//Ҫ��ʱ�临�Ӷ�ΪO(nlogn)


public class TopKFrequentElements {

	//����˼·һ��HashMap��keyΪԪ�أ�valueΪ���ִ������Խ����value���򣬷���ǰK�������value
	private static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : nums){
			Integer count = map.get(num);
			if(count == null)
				count = 0;
			map.put(num, count+1);
		}
		
		//��map�������valueֵ��������
		List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {     
		    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {        
		        //return (o1.getKey() - o2.getKey());//����key����  
		        return (o2.getValue() - o1.getValue());//����value����  
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
