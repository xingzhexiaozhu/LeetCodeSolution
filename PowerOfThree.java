import java.util.Scanner;

//�����������ж�һ�������Ƿ�Ϊ3����ָ��

public class PowerOfThree {

	//����˼·һ�����õݹ顣����3��9��27��81�������Է��֣�ÿ�γ�3���ս����Ϊ1��Ϊ3�ı�����������3�ı���
	private static boolean isPowerOfThree(int n) {
		if(n == 1) return true;
		else if(n == 0) return false;
		else if(n%3 == 0)
			return isPowerOfThree(n/3);
		else return false;
	}
	//����˼·��������ѭ��
	private static boolean isPowerOfThree1(int n){
		while(n >= 1){
			if(n ==1 || n == 3)
				return true;
			else {
				if((n%3) != 0) break;
				n = n/3;
			}			
		}
		return false;
	}
	
	//����˼·����ֱ������Log����
	private static boolean isPowerOfThree2(int n){
		double res = Math.log(n)/Math.log(3);
		return Math.abs(res - Math.rint(res)) < 0.0000000001;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(isPowerOfThree(n) + "\t" + isPowerOfThree1(n) + "\t" + isPowerOfThree2(n));
		}
	}	
}
