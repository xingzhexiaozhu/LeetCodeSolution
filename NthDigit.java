import java.util.Scanner;

//�����������ҵ����������еĵ�n�����֣���1,2,3,4,5,6,7,8,9,10,11...
//����n=3,����3�� ����n=11,����0

public class NthDigit {

	//����˼·��1~9��ÿλ1λ������9�����֣�10~99��ÿλ2λ������2*90�����֣�
	//100~999��ÿλ3λ������3*900�����֣�...
	//���Ҫ�ҵ�n�����֣�������ȷ�������ĸ����䣬Ȼ���ڸ�����������
	private static int findNthDigit(int n) {
		if(n <= 0)
			return 0;
		
		long count = 9;
		int start = 1;//ÿ�������һ����
		int len = 1;
		
		while(n > len * count){
			n -= len*count;
			len++;
			start *= 10;
			count *= 10;		
		}
		start += (n-1)/len;
		
		return String.valueOf(start).charAt((n-1)%len)-'0';
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(findNthDigit(n));
		}
	}

}
