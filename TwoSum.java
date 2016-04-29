import java.util.HashMap;

//��������������һ���������飬�ҳ�����������������ӵ���ָ��Ŀ������
//Given nums = [2, 7, 11, 15], target = 9,
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return[0, 1].

public class TwoSum {

	//�ⷨһ�����������˫��ѭ�������������������Ҫ�������
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
	
	//�ⷨ�������ڽⷨһ�ı����ⷨ��������������ʱ�临�Ӷ�O(n^2)�ͻ�ܴ�
	//�������￼�ǿռ任ʱ��ĸ�������ڲ���һ����Hash��Ƚϳ���
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
