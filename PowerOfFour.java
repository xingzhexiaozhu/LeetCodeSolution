import java.util.Scanner;

public class PowerOfFour {

	//����˼·һ��2��N���ݶ�ֻ�и�λ��ֻ��һ��1��ʣ�µ�ȫΪ0�����Կ��Բο�NumberOfOneBits��˼·
	//���ֻ��1��λ����1����Ϊ2����ָ��
	private static boolean isPowerOfFour(int n){
		int count0 = 0;
		int count1 = 0;
		while(n>0){
			if((n&0x01) == 0) count0++;
			count1 += (n&0x01);
			n>>=1;
		}
		return (count1==1)&&(count0%2==0);
	}
	
	//����˼·����ֱ������Log����
	private static boolean isPowerOfFour2(int n) {
		double res = Math.log(n)/Math.log(4);
		return Math.abs(res - Math.rint(res)) < 0.0000000001;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(isPowerOfFour(n) + "\t" + isPowerOfFour2(n));
		}
	}
}
