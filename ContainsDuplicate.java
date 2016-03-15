import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	//Contains Duplicate方法一：蛮力法
	public static boolean containsDuplicate(int[] nums){
		if(nums.length <= 1) return false;
		for(int i=0; i<nums.length-1; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[i] == nums[j])
					return true;
			}
		}
		return false;
	}
	
	//Contains Duplicate方法二：set
	public static boolean containsDuplicate1(int[] nums){
		Set<Integer> appearedNum = new HashSet<Integer>();		
		for(int i=0; i<nums.length; i++){
			if(!appearedNum.contains(nums[i])){
				appearedNum.add(nums[i]);				
			}else{
				return true;
			}
		}
		return false;
	}
	
	//Contains Duplicate II方法
	public static boolean containsDuplicate2(int[] nums, int k){
		Set<Integer> appearedNum = new HashSet<Integer>();
		int start = 0, end = 0;
		for(int i=0; i<nums.length; i++){
			if(!appearedNum.contains(nums[i])){
				appearedNum.add(nums[i]);
				end++;
			}else{
				return true;
			}
			if(end - start > k){
				appearedNum.remove(nums[start]);
				start++;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,3,4,5,6};
		int[] b = {1,2,3,4,5,5,6};
		System.out.println(containsDuplicate(a));
		System.out.println(containsDuplicate(b));
		System.out.println(containsDuplicate1(a));
		System.out.println(containsDuplicate1(b));
		System.out.println(containsDuplicate2(a, 2));
		System.out.println(containsDuplicate2(b, 2));
	}
}
