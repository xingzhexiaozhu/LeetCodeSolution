
//�����������Ƴ���������������ͬ��Ԫ�أ�����ÿ��Ԫ����������������

public class RemoveDuplicatesFromSortedArrayII {

	//����һ��˼·һ�����������i=j=2��ʼ����Ϊ������õ����飬�������a[j]=a[i-2]��j++�������ú�һ��Ԫ�ظ���ǰһ��Ԫ��
	//��˵����Ԫ�س��ִ���������2�Σ�������һ��Ԫ�ظ��Ǹ�Ԫ��
	private static int removeDuplicates(int[] nums) {
		if(nums.length < 2)
			return nums.length;
		
		int index = 2;
		for(int i=2; i<nums.length; i++){
			if(nums[i] != nums[index-2])
				nums[index++] = nums[i];
		}

		return index;
	}	

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		System.out.println(removeDuplicates(nums));			
	}

}
