import java.util.HashMap;
import java.util.Scanner;

//题意描述：给定一个已排序的数组，找到两个数字的和等于给定的一个目标数字，返回这两个数字的下标。
//假定每一个输入都有正好有一个解决方案
//Input:numbers={2,7,11,15},target=9
//Output:index1=1,index2=2

public class TwoSumIIInputArrayAsAorted {

	//解题思路一：跟twoSum题目一样，暴力破解
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

	//解题思路二：暴力破解始终不属于算法解题的好方法，这里考虑空间换时间。由于这里要返回两个下标，而不是符合解法的数字（可以考虑HashSet结构），所以这里选择HashMap这种数据
	//如num[index1]+num[index2]==target，首先放入<target-num[index1], index1>，然后当遇到对应的target-num[index1]就返回index2和index1
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
	
	//解题思路三：提交看着自己上面的算法运行时间这么低，不行！得重新想新解法！！！
	//题目为什么要强调已排序呢？排序好的话，可以很方便二分查找啊，可以从第一个数字很方便的得到第二个数字，然后对第二个数字进行二分查找，找到就返回两地址，找不到就寻找下一个第一个数字
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
	
	//解题思路四：为什么提交后运行效果还是不理想！！！
	//题目为什么要强调已排序呢？于是乎从两端开始查找，看和是否与目标数字匹配
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
