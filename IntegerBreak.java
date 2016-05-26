import java.util.Scanner;

//������������һ�������ֽ��������������֮�͵���ʽ����������������ӳ˻����ķֽ⣬�����ظ����˻�
//���磺n=2,����1��2=1+1���� n=10,����36��10=3+3+4��

public class IntegerBreak {

	//����˼·�����ҹ���4=2+2,return 4;     5=3+2,return 6;     6=3+3,return 9     7=4+3,return 12
	// 8=3+3+2,return 18     9=3+3+3,return 27     10=3+3+4,return 36     11=3+3+3+2,return 54
	//��1�����Է�����Ϊ4���Էֽ�Ϊ2*2����2*2�Ļ�����4�����Կ������ַֽ⵽4�Ͳ�����ϸ�֣�
	//��2���ֽ�����ȫΪ2��3ʱ�˻����ͬʱҪ�����ܶ��3��
	//��3����n%3==0ʱ������ȫΪ3��3�ĸ���Ϊ(n/3)�˻���󣻵�n%3==1ʱ������3�ĸ���Ϊ(n/3)-1�˻���󣻵�n%3==2ʱ������3�ĸ���Ϊ(n/3)
//	private static int integerBreak(int n) {
//		if(n < 2) return 0;
//		else if(n == 2) 
//			return 1;
//		else if(n == 3)
//			return 2;
//		
//		int mod = n % 3;//�ȵõ�ģ3������
//		int product = 1;//���յĳ˻�
//		int count = 0;  //����3�ĸ���
//		if(mod == 1)
//			count = n/3 - 1;
//		else count = n/3;
//		
//		while(count > 0){
//			product *= 3;
//			--count;
//		}
//		
//		if(mod == 1) product *= 4;
//		else if(mod == 2) product *= 2;
//			
//		return product;
//	}
	private static int integerBreak(int n) {
		if(n < 0)
			return 0;
		if(n < 4)
			return n-1;
		
		int product = 1;
		while(n > 4){
			product *= 3;
			n -= 3;
		}
		return product * n;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(integerBreak(n));
		}
	}

}
