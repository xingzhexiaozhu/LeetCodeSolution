
//�����������Ƴ������������ڵ���ͬԪ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������µĳ���

//����˼·��

public class RemoveDuplicatesFromSortedArray {

	private static int removeDuplicates(int[] nums) {
		if(nums.length < 1)//�����鳤��С��1ʱ���������ظ�Ԫ��
			return nums.length;
		
		int index = 0;
		for(int i=1; i<nums.length; i++){
			if(nums[index] != nums[i]){
				nums[++index] = nums[i];
			}
		}
		
		return index+1;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,2};
		System.out.println(removeDuplicates(nums));
	}	
}
