import java.io.BufferedReader;
import java.util.Scanner;

//����������һ��������λ�洢��һ��int�����У�����˳��Ϊ�����λ��array[0] �����λ��[n-1]�����磺98���洢Ϊ��array[0]=9; array[1]=8;

//����˼·������������һλ��ʼ��1����Ҫ���ǽ�λ�������[0]λ֮����Ȼ�н�λ���ڣ���Ҫ�¿�һ������Ϊ(n.length + 1)�����飬����ԭ��������

public class PlusOne {

	private static int[] plusOne(int[] digits) {
		int carry = 1; // ��λ��־����һλ���Ľ�λ��־
        int tmp;
        for (int i = digits.length - 1; i >= 0; i--) {
            tmp = digits[i];
            digits[i] = (tmp + carry) % 10; // ���㵱ǰλ����ֵ
            carry = (tmp + carry) / 10; // �����µĽ�λ

            if (carry == 0) { // û�н�λ�˾Ϳ����˳���
                break;
            }
        }

        if (carry == 1) { // �����һ����λ
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
