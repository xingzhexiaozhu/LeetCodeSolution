import java.util.ArrayList;

//ɾ��������ָ��Ԫ��,���������ճ���

public class RemoveElement {

	 //��������һ��list����ŷ�ָ��Ԫ�أ�����ٽ���ЩԪ�ظ��Ƶ������в����س���ֵ
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
