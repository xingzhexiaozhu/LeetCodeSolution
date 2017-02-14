
/**
 * 对查找算法的整理
 * 1、顺序查找和折半查找：
 *  （1）顺序查找
 *  （2）折半查找
 *  （3）分块查找
 */

public class Search {

	//顺序查找：从线性表的一端开始，逐个检查关键字是否满足条件。
	//找到满足条件的元素，则查找成功；若查找到线性表另一端仍没有满足条件的元素，则查找失败
	static int SeqSearch(int[] nums, int key){
		for(int i=0; i<nums.length; i++)
			if(key == nums[i])
				return i;
		return -1;
	}
	
	//折半查找（又名二分查找）：首先将给定值key与表中间位置元素的关键字比较，相等则查找成功并返回元素的存储位置，
	//若不等则根据元素位置关系在表前半部分或后半部分进一步查找，不断重得至找到或确定表中没有对应元素停止
	static int BinarySearch(int[] nums, int key){
		int low = 0, high = nums.length-1, mid;
		while(low <= high){
			mid = (low + high) / 2; 
			if(key == nums[mid])
				return mid;
			else if(key > nums[mid])
				low = mid+1;
			else high = mid-1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = {88,24,72,61,21,6,32,11,8,31,22,83,78,54};		
		System.out.println(SeqSearch(nums, 8));//顺序查找
		
		int[] nums1 = {6,8,11,21,22,24,31,32,54,61,72,78,83,88};
		System.out.println(BinarySearch(nums1, 24));
	}

}
