import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//�����������ҳ�������������Ľ��棨���������֣��ظ��Ĺ���Ԫ��ֻ����һ��
//���磺nums1=[1,2,2,1],nums2=[2,2],����[2]

public class IntersectionOfTwoArrays {

	//����˼·��ʹ��Set�����һ�������ֵ�������ڶ������飬����ڶ��������е�������Set�г��ֹ�����Ϊ����Ԫ��
	//ͬʱ��֤�ظ�Ԫ���ڽ����ֻ����һ�Σ���Ҫ��̬ɾ��Set��ǰ����������г��ֹ���Ԫ��
	private static int[] intersection(int[] nums1, int[] nums2) {
		if(nums1==null || nums2==null)
			return null;
		
		HashSet<Integer> set = new HashSet<Integer>();
		List<Integer> resList = new ArrayList<Integer>();
		
		for(int i=0; i<nums1.length; i++){
			if(!set.contains(nums1[i]))//������һ�е�Ԫ�ؼ���set��
				set.add(nums1[i]);
		}
		
		for(int i=0, count=0; i<nums2.length; i++){
			if(set.contains(nums2[i])){//���������е�Ԫ����set�г��ֹ�
				resList.add(nums2[i]);//��Ϊ����Ԫ��
				set.remove(nums2[i]); //ͬʱΪ��������ظ����֣���set��ɾ����Ԫ��
			}
		}
		
		int[] res = new int[resList.size()];
		for(int i=0; i<resList.size(); i++)
			res[i] = resList.get(i);
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		
		int[] result = intersection(nums1, nums2);
		for(int num:result)
			System.out.print(num + " ");
		System.out.println();
	}

}
