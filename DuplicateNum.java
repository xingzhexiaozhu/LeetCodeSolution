import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//题意描述：在一个长度为n的数组中所有数字都在0-(n-1)之间，数组中某些数字是重复的，但不知道几个数字重复了，也不知道重复了几次。
//请找出数组中任意一个重复的数字。例如如果输入长为7的数组{2,3,1,0,2,5,3}，那么对应输出的是重复的数字2或者3

public class DuplicateNum {
	//解题思路一：排序，然后遍历查找到第一个重复的数字【排序的时间复杂度最少为O(nlogn)，还有查找时间复杂度】
	private static int getDuplicateNum(int[] num) {	
		int res = -1;
				
		if(num == null || num.length <=0)
			return res;
			
		for(int i=0; i<num.length; i++)
			if(num[i] <0 || num[i] >= num.length)
				return res;
		
		Arrays.sort(num);
		
		for(int i=0; i<num.length-1; i++)
			if(num[i+1] == num[i])
				return num[i];
		
		return res;
	}
	
	//解题思路二：哈希表【时间复杂度为O(n)，但需要额外的空间】
	private static int getDuplicateNum2(int[] num) {		
		int res = -1;
		if(num == null || num.length <=0)
			return res;
		
		for(int i=0; i<num.length; i++)
			if(num[i] <0 || num[i] >= num.length)
				return res;
		
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<num.length; i++){
			if(set.contains(num[i]))
				return num[i];
			set.add(num[i]);
		}
		
		return -1;
	}
	
	//解题思路三：从头遍历数组，a[i]与i比，如果相等则下一位；如果不相等则index=a[i]然后a[i]与a[index]交换，至一趟结束就可以找到重复元素
	private static int getDuplicateNum3(int[] num) {		
		int res = -1;
		if(num == null || num.length <=0)
			return res;
		
		for(int i=0; i<num.length; i++)
			if(num[i] <0 || num[i] >= num.length)
				return res;
		
		for(int i=0; i<num.length; i++){
			while(num[i] != i){
				if(num[i] == num[num[i]])
					return num[i];
				
				int tmp = num[i];
				num[i] = num[num[i]];
				num[num[i]] = tmp;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int[] num = new int[n];
			for(int i=0; i<n; i++)
				num[i] = sc.nextInt();
			
			if(getDuplicateNum(num) != -1)
				System.out.println(getDuplicateNum(num) + "\t" + getDuplicateNum2(num) + "\t" + getDuplicateNum3(num));
			else
				System.out.println("Invalid input!");
		}
	}
}
