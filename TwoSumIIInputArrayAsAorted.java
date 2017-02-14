import java.util.HashMap;
import java.util.Scanner;

//��������������һ������������飬�ҵ��������ֵĺ͵��ڸ�����һ��Ŀ�����֣��������������ֵ��±ꡣ
//�ٶ�ÿһ�����붼��������һ���������
//Input:numbers={2,7,11,15},target=9
//Output:index1=1,index2=2

public class TwoSumIIInputArrayAsAorted {

	//����˼·һ����twoSum��Ŀһ���������ƽ�
	private static int[] twoSum(int[] numbers, int target) {		
		int[] res = new int[2];
//		if(numbers.length < 2)
//			return res;
//		
//		if(numbers.length == 2){
//			if(numbers[0] + numbers[1] == target){
//				res[0] = 1;
//				res[1] = 2;
//			}
//			return res;
//		}
		
		for(int i=0; i<numbers.length-1; i++){
			for(int j=i+1; j<numbers.length; j++){
				if(numbers[i] + numbers[j] == target){
					res[0] = i+1;
					res[1] = j+1;
				}
			}
		}
		
		return res;
	}

	//����˼·���������ƽ�ʼ�ղ������㷨����ĺ÷��������￼�ǿռ任ʱ�䡣��������Ҫ���������±꣬�����Ƿ��Ͻⷨ�����֣����Կ���HashSet�ṹ������������ѡ��HashMap��������
	//��num[index1]+num[index2]==target�����ȷ���<target-num[index1], index1>��Ȼ��������Ӧ��target-num[index1]�ͷ���index2��index1
	private static int[] twoSum2(int[] numbers, int target){
		int[] res = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<numbers.length; i++){
			if(!map.containsKey(numbers[i])){
				int expectNum = target - numbers[i];
				map.put(expectNum, i);
			}else{
				res[1] = i+1;
				res[0] = map.get(numbers[i]) + 1;
			}
		}
		return res;
	}
	
	//����˼·�����ύ�����Լ�������㷨����ʱ����ô�ͣ����У����������½ⷨ������
	//��ĿΪʲôҪǿ���������أ�����õĻ������Ժܷ�����ֲ��Ұ������Դӵ�һ�����ֺܷ���ĵõ��ڶ������֣�Ȼ��Եڶ������ֽ��ж��ֲ��ң��ҵ��ͷ�������ַ���Ҳ�����Ѱ����һ����һ������
	private static int[] twoSum3(int[] numbers, int target){
		int[] res = new int[2];
		for(int i=0; i<numbers.length; i++){
			int expectedNum = target - numbers[i];
			
			int low = i+1, high=numbers.length-1, mid;
			while(low <= high){
				mid = (high - low)/2 + low;
				if(numbers[mid] == expectedNum){
					res[0] = i+1;
					res[1] = mid+1;
					return res;
				}else if(numbers[mid] < expectedNum)
					low = mid+1;
				else high = mid-1;
			}
		}
		
		return res;
	}
	
	//����˼·�ģ�Ϊʲô�ύ������Ч�����ǲ����룡����
	//��ĿΪʲôҪǿ���������أ����Ǻ������˿�ʼ���ң������Ƿ���Ŀ������ƥ��
	private static int[] twoSum4(int[] numbers, int target){
		int[] res = new int[2];
		int low = 0, high = numbers.length-1;
		while(low < high){
			if(numbers[low] + numbers[high] > target)
				high--;
			else if(numbers[low] + numbers[high] < target)
				low++;
			else{
				res[0] = low+1;
				res[1] = high+1;
				return res;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
//		int[] nums = {2,7,11,15};
		int[] nums = {1,2,3,4,4,9,56,90};
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int target = sc.nextInt();
			int[] res = twoSum4(nums, target);
			for(int n : res)
				System.out.print(n + " ");
			System.out.println();
		}
	}

}
