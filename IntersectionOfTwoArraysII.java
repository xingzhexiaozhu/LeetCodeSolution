import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//�����������ҳ�������������Ľ��棨����������
//���磺nums1=[1,2,2,1],nums2=[2,2], ����[2,2]
//���Կ���ÿ��Ԫ�س��ֵĴ�������������������һ�����ֵĴ���

public class IntersectionOfTwoArraysII {

	//����˼·�����IntersectionOfTwoArrays�Ľⷨ��������Խ���HashMap�������Ƚ�һ�������е�Ԫ�ط��룬keyΪ��Ӧ��Ԫ�أ�valueΪ���ִ���
	//Ȼ�������һ�����飬������������List�У�Ȼ��value��1����valueΪ0ʱ����ɾ����Ԫ��
	private static int[] intersection(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null)
			return null;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<nums1.length; i++){
			if(!map.containsKey(nums1[i]))
				map.put(nums1[i], 1);//�����Ԫ��û�г��ֹ�����map�м����Ԫ�أ�<nums[i],1>
			else{//�����Ԫ�س��ֹ������ȵõ��Ѵ��ڵ�valueֵ���ٸ�ֵΪvalue+1
				int value = map.get(nums1[i]);
				map.put(nums1[i], value+1);
			}
		}
		
		for(int i=0; i<nums2.length; i++){
			if(map.containsKey(nums2[i])){
				if(map.get(nums2[i]) == 1){
					list.add(nums2[i]);
					map.remove(nums2[i]);
				}else{
					list.add(nums2[i]);
					int value = map.get(nums2[i]);
					map.put(nums2[i], value-1);
				}
			}
		}
		
		int[] res = new int[list.size()];
		for(int i=0; i<list.size(); i++)
			res[i] = list.get(i);
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
