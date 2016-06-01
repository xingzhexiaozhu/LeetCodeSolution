import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

//��������������һ�����飬����ֻ��һ��Ԫ�س�����һ������Ԫ�ؾ��������Σ��ҳ�ֻ����һ�ε�Ԫ��

public class SingleNumber {

	//����˼·����һ��Ӧ�뵽������HashMap����ṹ��key��Ԫ��value��Ԫ�س��ִ���
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
	
	//����˼·����������Set���ݽṹ��ÿ��Ԫ�س��ֵڶ��ο���ɾ����Ԫ�أ�������µļ�Ϊ����
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
	
	//����˼·�����������ַ����ύ�󣬳ɼ������ã���һ��˼�������·���
	//���������ص���ͬ0��1�����Ե�������ͬ���־��ǵ�����������µľ������������
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
