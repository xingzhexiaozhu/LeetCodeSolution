import java.util.Scanner;

//��������������һ�������ַ�������ת����λ�ϵ�����.���磺
//x = 123, return 321
//x = -123, return -321


public class ReverseInteger {

	//����˼·��ֻ�迼�����ֵ�������Ȼ��ͳһ���������������յĽ���ٳ˷���λ
	private static int reverse(int num) {
		int sign = 1;
		if(num<0) sign = -1;
		
		int temp = Math.abs(num);
		double result = 0;		
		
		while(temp > 0){
			int bit = temp%10;
			result = result * 10 + bit;		
			if(result > Integer.MAX_VALUE)
				return 0;
			temp = temp/10;
		}					
		
		return (int) ((int)sign*result);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int num = sc.nextInt();
			System.out.println(reverse(num));
		}

	}
}
