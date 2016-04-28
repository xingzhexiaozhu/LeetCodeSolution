import java.io.BufferedReader;
import java.util.Scanner;

//题意描述：一个整数按位存储于一个int数组中，排列顺序为：最高位在array[0] ，最低位在[n-1]，例如：98，存储为：array[0]=9; array[1]=8;

//解题思路：从数组的最后一位开始加1，需要考虑进位，如果到[0]位之后仍然有进位存在，需要新开一个长度为(n.length + 1)的数组，拷贝原来的数组

public class PlusOne {

	private static int[] plusOne(int[] digits) {
		int carry = 1; // 进位标志，下一位来的进位标志
        int tmp;
        for (int i = digits.length - 1; i >= 0; i--) {
            tmp = digits[i];
            digits[i] = (tmp + carry) % 10; // 计算当前位的新值
            carry = (tmp + carry) / 10; // 计算新的进位

            if (carry == 0) { // 没有进位了就可以退出了
                break;
            }
        }

        if (carry == 1) { // 最后还有一个进位
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = carry;;
            return result;
        } else {
            return digits;
        }
    }
	
	public static void main(String[] args) {
		int[] num = {1,2,3,4,5,6,7,8,9};
		int[] newNum = plusOne(num);
		for(int i=0; i<newNum.length; i++)
			System.out.print(newNum[i]);
		System.out.println();
	}
}
