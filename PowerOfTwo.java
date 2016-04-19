import java.util.Scanner;

//��������������һ���������ж����Ƿ�Ϊ2��N��

public class PowerOfTwo {

	//����˼·һ��2��N���ݶ�ֻ�и�λ��ֻ��һ��1��ʣ�µ�ȫΪ0�����Կ��Բο�NumberOfOneBits��˼·
	//���ֻ��1��λ����1����Ϊ2����ָ��
//	private static boolean isPowerOfTwo(int n) {
//		int count = 0;
//		while(n != 0){
//			count += n&1;
//			n>>>=1;
//		}
//		return count == 1;//�Ը�������ʹ��
//	}
	private static boolean isPowerOfTwo(int n){
		int count = 0;
		while(n>0){
			count += (n&0x01);
			n>>=1;
		}
		return count==1;
	}
	
	//����˼·����ͬ��һ����Ŀ������Integer.bitCount()ֱ�ӵõ�1�ĸ�����Ϊ1����2�ı���
	private static boolean isPowerOfTwo1(int n) {		
		return Integer.bitCount(n) == 1;//ͬ��
	}
	
	
	//����˼·����2����ָ�����ص������λΪ1ʣ��λȫΪ0�����Խ�������1�õ����Ϊ0����λȫ1
	//���Խ������������1�����ִ�С��롱���������Ϊ0��ԭ��Ϊ2����ָ��
	private static boolean isPowerOfTwo2(int n){
		return (n>0)&&((n&(n-1))==0);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(isPowerOfTwo(n) + "\t" + isPowerOfTwo2(n));
		}
	}
}
