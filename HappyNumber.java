import java.util.HashSet;
import java.util.Set;

//题目：计算一个数的各个位置上的平方和至1位数，最终能得到1的数就是HappyNumber
//比如：19 1^2+9^2=82,8^2+2^2=68,6^2+8^2=100,1^2+0^2+0^2=1  =>19为HappyNumber

public class HappyNumber {

	//解题思路：根据快乐数的计算方法，我们很难在有限步骤内确定一个数是否是快乐数，但使用排除法的话，
	//我们可以尝试确定一个数不是快乐数。根据题意，当计算出现无限循环的时候就不是快乐数。出现无限循环
	//的说明产生了相同的结果，而判断相同结果只要用Set就行了
	static boolean isHappy(int n){
		Set<Integer> set = new HashSet<>();
		while(n != 1){
			int sum = 0;
			while(n > 0){
				sum += (n%10)*(n%10);
				n = n/10;
			}
			if(set.contains(sum)){
				return false;
			}else{
				set.add(sum);
			}
			n= sum;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag = isHappy(19);
		if(flag) System.out.println(19 + " is a happy number!");
		else System.out.println(19 + "is not a happy number!");
	}

}
