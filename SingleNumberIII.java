import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

//��������������һ�����飬����ֻ������Ԫ�س�����һ������Ԫ�ؾ��������Σ��ҳ�ֻ����һ�ε�����Ԫ��
//��{1,2,1,3,2,5}����{3,5}

public class SingleNumberIII {

	//����˼·һ��HashSet
	private static int[] singleNumber(int[] nums){
		int[] res = new int[2];
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<nums.length; i++){
			if(!set.contains(nums[i]))
				set.add(nums[i]);
			else
				set.remove(nums[i]);
		}
		
		Iterator it = set.iterator();
		int count = 0;
		while(it.hasNext()){
			res[count++] = (int) it.next();
		}
		
		return res;
	}
	
	//����˼·������������������ͬ���֣���ô�ٰ���SingleNumber����Ͳ��ܵõ����ս����
	//��ˣ�˼·�ǽ��������ְ�һ������ֳ����飬Ȼ��ֱ���������㣬�Ϳ��Եõ�������ͬ��������Ϊ����
	//�������ƵĹ��������������ͬ��������Ʊ�ʾ��������һ��������λ�ǲ�ͬ�ģ���һ����0��һ����1������Ϊ����������������ֳַ�����
	private static int[] singleNumber2(int[] nums){		
		int diff = 0;
		for(int num : nums)
			diff ^= num;
		
		diff = Integer.highestOneBit(diff);
		int[] res = new int[2];
		Arrays.fill(res, 0);
		
		for(int num : nums){
			if((diff & num) == 0)
				res[0] ^= num;
			else res[1] ^= num;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,1,3,2,5};
		int[] res = singleNumber2(nums);
		for(Integer num : res)
			System.out.print(num + " ");
		System.out.println();
	}

}
