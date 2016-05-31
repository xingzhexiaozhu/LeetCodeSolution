import java.util.Scanner;

//��������������һ���Ǹ�����num������0<=i<=num�����Χ��ÿ���������ɶ��ٸ�1���

public class CountingBits {

	//����˼·һ�����NumberOf1Bits����˼·���������ÿ�����ֵ�1�ĸ�������󷵻�����	
	private static int NumbersOf1Bits(int n) {
		int count = 0;
		while(n != 0){
			count++;
			n = n & (n-1);//��һ������������ּ�ȥ1�����룬�ͻὫ��������ʽ�����һλ1ת��Ϊ0���ж��ٸ�1���ж��ٴβ�������
		}
		return count;
	}
	private static int[] countBits(int num) {
		int[] result = new int[num+1];
		for(int i=0; i<result.length; i++)
			result[i] = NumbersOf1Bits(i);
		return result;
	}

	//����˼·�����ⷨһ��˼·��������num��û����������num֮ǰ�Ľ��������⣬����ÿ�����ֶ���������
	//����2^N������ĩβN-1λ���ظ����ɣ����õ���ǰN-1�������ظ����ɣ�����ʱֻ��Ҫ��1����
	private static int[] countBits1(int num){
		int[] result = new int[num+1];
		result[0] = 0;
		int base = 1;
		while(base <= num){
			int next = base * 2;
			for(int i=base; i<next && i<= num; i++)
				result[i] = result[i-base]+1;
			base = next;
		}
		return result;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int num = sc.nextInt();
			int[] res = countBits1(num);
			for(int i=0; i<res.length; i++)
				System.out.print(res[i] + " ");
			System.out.println();
		}
	}

}
