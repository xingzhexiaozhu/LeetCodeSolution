
/**
 * �Բ����㷨������
 * 1��˳����Һ��۰���ң�
 *  ��1��˳�����
 *  ��2���۰����
 *  ��3���ֿ����
 */

public class Search {

	//˳����ң������Ա��һ�˿�ʼ��������ؼ����Ƿ�����������
	//�ҵ�����������Ԫ�أ�����ҳɹ��������ҵ����Ա���һ����û������������Ԫ�أ������ʧ��
	static int SeqSearch(int[] nums, int key){
		for(int i=0; i<nums.length; i++)
			if(key == nums[i])
				return i;
		return -1;
	}
	
	//�۰���ң��������ֲ��ң������Ƚ�����ֵkey����м�λ��Ԫ�صĹؼ��ֱȽϣ��������ҳɹ�������Ԫ�صĴ洢λ�ã�
	//�����������Ԫ��λ�ù�ϵ�ڱ�ǰ�벿�ֻ��벿�ֽ�һ�����ң������ص����ҵ���ȷ������û�ж�ӦԪ��ֹͣ
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
		System.out.println(SeqSearch(nums, 8));//˳�����
		
		int[] nums1 = {6,8,11,21,22,24,31,32,54,61,72,78,83,88};
		System.out.println(BinarySearch(nums1, 24));
	}

}
