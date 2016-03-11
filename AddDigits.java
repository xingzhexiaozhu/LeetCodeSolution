//题目为：Given num=38, the process is like:3+8=11, 1+1=2. Since 2 has only one digit, return it.
//题目要求不用循环和递归，并且时间复杂度为1

public class AddDigits {
	
	//解题思路一：蛮力求解，将数字逐位相加，并循环这样做，至一位数即为所求结果
	static int solution1(int n){//调用getSum，判断返回值如果不是一位数继续调用getSum求和
		int result = getSum(n);
		while(result > 9){
			result = getSum(result);
		}
		return result;
	}
	static int getSum(int n){//求一个数的各位数相加之和
		int sum = 0;
		while(n > 0){
			sum += (n%10);
			n = n/10;
		}
		return sum;
	}
	
	//解题思路二：因为 (x+y)%z=(x%z+y%z)%z，又因为 x%z%z=x%z，因此结果为 (num-1)%9+1，
	//只模除9一次，并将模除后的结果加一返回
	static int solution2(int n){
		return (n-1)%9 + 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution1(38));
		System.out.println(solution2(38));
		
		System.out.println(solution1(100));
		System.out.println(solution2(100));
	}
}
