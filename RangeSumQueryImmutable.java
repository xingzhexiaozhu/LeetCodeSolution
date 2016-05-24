
//题意描述：给定一个数组，求任意指定下标之间的数字之和
//如：[-2, 0, 3, -5, 2, -1]
//sumRange(0, 2) -> 1
//sumRange(2, 5) -> -1
//sumRange(0, 5) -> -3

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);

public class RangeSumQueryImmutable {
	
	//解题思路：由题意知，需要在自己定义的类中声明数组，然后以对象的方式操作数组
	//数组中存储的是numbers[i]中存储的是0-i的元素之和
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
