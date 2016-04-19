import java.util.Arrays;

public class MergeTwoSortedArray {

	private static void merge(int[] nums1, int m, int[] nums2, int n){

		int i=m-1;
		int j= n-1;
		int k=m+n-1;
		
		while(i>=0 && j>=0){
			nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
		}
		while(j>=0){
			nums1[k--] = nums2[j--];
		}
		
		for(int t=0; t<nums1.length; t++)
			System.out.print(nums1[t] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[] num1 = new int[20];
		for(int i=0; i<7; i++)
			num1[i] = 2*i+1;
		int[] num2 = {2,4,6,8,10};
		merge(num1,7,num2,5);
		
	}
}
