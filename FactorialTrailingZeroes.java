import java.util.Scanner;

//��������������һ������n������n!��0�ĸ���

//����˼·�����μ���1~10�Ľ׳ˣ����Է��ֹ���---ÿ��һ��2*5�����յĽ���б�����һ��0
//������һ������ֽ⣬2�ĸ���һ��Զ����5�ĸ���������ת��Ϊһ�����ܱ����ٸ�5����������5�ĸ���ʱ, ��򵥵ķ����� SUM(N/5^1,  N/5^2, N/5^3...)
//���ֻҪ����5�ĸ����Ϳ����ˡ���ô��������n!��������������5�ĸ����أ�һ���򵥵ķ����Ǽ���floor(n/5)��
//���磬7!��һ��5��10!������5������֮�⣬����һ������Ҫ���ǡ�����25��125֮��������в�ֹһ��5��
//���磬������ǿ���28!�����ǵõ�һ�������5������0�����������6�������������Ҳ�ܼ򵥣����ȶ�n��5���Ƴ����еĵ���5��Ȼ���25���Ƴ������5���Դ����ƣ�
//n!��׺0�ĸ��� = n!��������5�ĸ��� = floor(n/5) + floor(n/25) + floor(n/125) + ....

public class FactorialTrailingZeroes {

	private static int trailingZeroes(int n) {
		if(n < 0) return 0;
		int count = 0;
		while(n/5 != 0){
			n = n/5;
			count += n;
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(trailingZeroes(n));
		}
	}	
}
