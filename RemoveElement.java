import java.util.ArrayList;

//删除数组中指定元素,并返回最终长度

public class RemoveElement {

	 //方法：用一个list来存放非指定元素，最后再将这些元素复制到数组中并返回长度值
	static int removeElement(int[] nums, int val){
		ArrayList<Integer> list = new ArrayList<Integer>();
	    for (int i = 0; i < nums.length; i++) {
	      if (nums[i] == val)
	        continue;
	      list.add(nums[i]);
	    }
	    for (int i = 0; i < list.size(); i++)
	      nums[i] = list.get(i);
	    return list.size();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9, 9};
		System.out.println(removeElement(nums, 2));		
	}

}
