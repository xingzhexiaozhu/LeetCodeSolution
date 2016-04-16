
public class MoveZeroes {
		
	//方法一：如果当前元素为0则将与其后第一个不为0的元素交换位置
	//但当数组足够大时会超时
	static void moveZeroes(int[] nums){
		if(nums.length<1) return;
		for(int i=0; i<nums.length-1; i++){				
			if(nums[i] == 0){//如果当前元素为0，则将其与后面第一个不为0的元素交换位置
				for(int j=i+1; j<nums.length; j++){
					if(nums[j] != 0){
						int temp = nums[j];
						nums[j] = nums[i];
						nums[i] = temp;
						break;
					}
				}					
			}
			
			for(int k=0; k<nums.length; k++)
				System.out.print(nums[k] + " ");
			System.out.println();
		}
	}
	
	//方法二:将所有不为0的元素前移，循环结束后面元素全部置为0
	static void moveZeroes1(int[] nums){
		int count = 0;
		for(int i=0; i<nums.length; i++){
			if(nums[i] != 0){
				nums[count] = nums[i];
				count++;
			}			
		}
		for(; count<nums.length; count++)
			nums[count] = 0;
		
		for(int k=0; k<nums.length; k++)
			System.out.print(nums[k] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0, 1, 0, 3, 12};
		moveZeroes1(nums);	
		
		int[] a = {1,0,1};
		moveZeroes(a);
	}

}
