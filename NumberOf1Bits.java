import java.io.IOException;
import java.util.Scanner;

//题意描述：输入一个整数，输出该数字二进制形式中1的个数

public class NumberOf1Bits {

	//方法一：unsigned int 是32位的无符号整型，而Java中没有unsigned int，所以可以采用移位运算符
    public static int hammingWeight(int n) {
        int count = 0;
        while(n != 0){//因为Java中没有无符号的整数，所以用!=0来判断数学是否处理完成而不能用>0判断
        	count += n & 1;//取出第一位
        	n>>>=1;//数字右移一位
        }
        return count;
    }
	
    //方法二、直接调用Java API：  Integer.bitCount()
	public static int hammingWeight1(int n){
		return Integer.bitCount(n);
	}
	
	//解题思路三：二的解法虽避免了负数出现死循环的形式，但循环的次数等于整数二进制的位数
	//把一个整数减去1再和原来整数做与运算，会把该整数最右边一个1变成0，那么一个整数的二进制表示中，有多少个1，就可以进行多少次这样的操作
	public static int hammingWeight2(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = (n - 1)&n;
		}
		return count;
	}
    
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);		
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(hammingWeight(n) + "\t" + hammingWeight1(n) + "\t" + hammingWeight2(n));
			
			
		}		
	}

}
