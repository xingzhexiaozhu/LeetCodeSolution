
//有1,2,…,n的数无序数组，求排序算法，并且要求时间复杂度为O(n)，
//空间复杂度O(1)，使用交换，而且一次只能交换两个数

public class SortDisorder1ToN {

	public static void main(String[] args) {
		
		int[] array = {10,6,9,5,2,8,4,7,1,3};
		//System.out.println(array.length);//10
		System.out.print("数组中原数据为：");
		for(int i=0; i<array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
		
		int len = array.length;
		for(int i=0; i<len;){
			//如果这个数字本来就在这个位置则直接跳过本次循环
			if(array[i] == i+1){
				i++;
				continue;
			}
			int temp = array[array[i]-1];
			array[array[i]-1] = array[i];
			array[i] = temp;
		}
		
		System.out.print("数组中的数据排序后：");
		for(int i=0; i<array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

}
