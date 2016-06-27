import java.util.Scanner;

//题意描述：给定一个非负数n，计算0<=x<10^n数字的个数，排除各位相同的数字
//如：n=2,返回91（排除[11,22,33,44,55,66,77,88,99]）

public class CountNumbersWithUniqueDigits {

	//解题思路一：数字的基本元素是[0,1,2,3,4,5,6,7,8,9]共10个数字，则有以下结论：
	//n=0	---		1[0]
	//n=1	---		1+9=10[0;1,2,3,4,5,6,7,8,9]
	//n=2	---		10+81[0;1...9;10...98(除去11,22...99)],1+9+9*9
	//n=3	---		10+9*9+9*9*8
	//...
	//n=10	---		10+9*9+9*9*8+...+9*9*8*...1（最多能达10位数）
	//f(k) = 9*9*...*(9-k+2)
	private static int countNumbersWithUniqueDigits(int n){
		if(n == 0)
			return 1;
		int res = 10;
		int base = 9;
		for(int i=2; i<=n && i<=10; i++){
			base = base * (9 - i + 2);
			res += base;
		}
		return res;
	}	
	
	//解题思路二：回溯
	//题目提示中所说的回溯的方法，我们需要一个变量used，其二进制第i位为1表示数字i出现过，刚开始我们遍历1到9，
	//对于每个遍历到的数字，现在used中标记已经出现过，然后在调用递归函数。在递归函数中，如果这个数字小于最大值，
	//则结果res自增1，否则返回res。然后遍历0到9，如果当前数字没有在used中出现过，此时在used中标记，然后给
	//当前数字乘以10加上i，再继续调用递归函数，这样我们可以遍历到所有的情况，参见代码如下：
	private static int countNumberWithUniqueDigits2(int n){
		if (n > 10) {
            return countNumberWithUniqueDigits2(10);
        }
        int count = 1; // x == 0
        long max = (long) Math.pow(10, n);

        boolean[] used = new boolean[10];

        for (int i = 1; i < 10; i++) {
            used[i] = true;
            count += search(i, max, used);
            used[i] = false;
        }

        return count;
	}
	 private static int search(long prev, long max, boolean[] used) {
        int count = 0;
        if (prev < max) {
            count += 1;
        } else {
            return count;
        }

        for (int i = 0; i < 10; i++) {
            if (!used[i]) {
                used[i] = true;
                long cur = 10 * prev + i;
                count += search(cur, max, used);
                used[i] = false;
            }
        }

        return count;
	 }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while(sc.hasNext()){
			n = sc.nextInt();
			System.out.println(countNumbersWithUniqueDigits(n) + "\t" + countNumberWithUniqueDigits2(n));
		}
	}

}
