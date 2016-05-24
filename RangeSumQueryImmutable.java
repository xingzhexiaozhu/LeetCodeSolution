
//��������������һ�����飬������ָ���±�֮�������֮��
//�磺[-2, 0, 3, -5, 2, -1]
//sumRange(0, 2) -> 1
//sumRange(2, 5) -> -1
//sumRange(0, 5) -> -3

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);

public class RangeSumQueryImmutable {
	
	//����˼·��������֪����Ҫ���Լ�����������������飬Ȼ���Զ���ķ�ʽ��������
	//�����д洢����numbers[i]�д洢����0-i��Ԫ��֮��
	int[] numbers;
	public RangeSumQueryImmutable(int[] nums){
		numbers = new int[nums.length];
		System.arraycopy(nums, 0, numbers, 0, nums.length);
		
		for(int i=1; i<numbers.length; i++)
			numbers[i] += numbers[i-1];
	}
	
	public int sumRange(int i, int j){
		if(i>j || i<0 || j<0 || j>=numbers.length)
			return 0;
		return i==0?numbers[j]:(numbers[j]-numbers[i-1]);
	}
	
	public static void main(String[] args) {
		int[] nums = {-2,0,3,-5,2,-1};
		
		RangeSumQueryImmutable numArray = new RangeSumQueryImmutable(nums);
		System.out.println(numArray.sumRange(0, 2));
		System.out.println(numArray.sumRange(2, 5));
		System.out.println(numArray.sumRange(0, 5));
		
	}

}
