import java.util.Arrays;

public class MajorityElement {

	//��Ϊ��Ŀ˵����һ������Ԫ����������п��Կ���������Ȼ�󷵻�[length/2]λ���ϵ�Ԫ��
	public static int majorityElement(int[] nums) {
        if(nums.length == 1)
        	return nums[0];
		Arrays.sort(nums);
        return nums[nums.length/2];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,2,3,4,5,6,1,1,1,1};
		System.out.println(majorityElement(nums));
	}

}
