import java.util.Arrays;

public class MajorityElement {

	//因为题目说明是一定有主元的情况，所有可以考虑先排序，然后返回[length/2]位置上的元素
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
