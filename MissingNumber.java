import java.util.HashSet;
import java.util.Set;

//������������������n����������֣�����ȡ��[0,1,2,...,n]���ҵ�ȱʧ����һ������
//�磺����nums=[0,1,3]����2

public class MissingNumber {

	//����˼·һ����Ȼ�뵽�ķ���һ�����ȶ������������Ȼ�����ֵ���±��Ӧ�Ĺ�ϵ�����������value=index+1
	//�򷵻�(index+1)��Ϊ����
	private static int missingNumber(int[] nums) {
		if(nums==null || nums.length<=0)
			return -1;
		
		for(int i=0; i<nums.length-1; i++){
			boolean flag = false;//��־λ
			for(int j=nums.length-1; j>i; j--){
				if(nums[j] < nums[j-1]){
					int temp = nums[j];
					nums[j] = nums[j-1];
					nums[j-1] = temp;
					flag = true;
				}
			}
			if(flag == false)
				break;
		}
		int value = 0;
		for(int i=0; i<nums.length; i++){
			if(nums[i] != i){
				value = i;
				break;
			}
		}
		return value;
	}
	
	//����˼·����������ĿҪ��������ʱ�临�Ӷ�����ɣ������������Ҳ��O(nlogn)���������Ľⷨ����������
	//�뵽����set���ϣ��Ƚ����ִ浽set�У�Ȼ��������������set���򷵻ظ�����
	private static int missingNumber2(int[] nums){
		if(nums==null || nums.length<=0)
			return -1;
		
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<nums.length; i++)
			set.add(nums[i]);
		int value = -1;
		for(int i=0; i<=nums.length; i++){
			if(!set.contains(i)){
				value = i;
				break;
			}
		}
		return value;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,1,3};
		System.out.println(missingNumber(nums) + "\t" + missingNumber2(nums));
		
		int[] nums2 = {0,2,5,3,1};
		System.out.println(missingNumber(nums2) + "\t" + missingNumber2(nums2));
	}

}