//��ĿΪ��Given num=38, the process is like:3+8=11, 1+1=2. Since 2 has only one digit, return it.
//��ĿҪ����ѭ���͵ݹ飬����ʱ�临�Ӷ�Ϊ1

public class AddDigits {
	
	//����˼·һ��������⣬��������λ��ӣ���ѭ������������һλ����Ϊ������
	static int solution1(int n){//����getSum���жϷ���ֵ�������һλ����������getSum���
		int result = getSum(n);
		while(result > 9){
			result = getSum(result);
		}
		return result;
	}
	static int getSum(int n){//��һ�����ĸ�λ�����֮��
		int sum = 0;
		while(n > 0){
			sum += (n%10);
			n = n/10;
		}
		return sum;
	}
	
	//����˼·������Ϊ (x+y)%z=(x%z+y%z)%z������Ϊ x%z%z=x%z����˽��Ϊ (num-1)%9+1��
	//ֻģ��9һ�Σ�����ģ����Ľ����һ����
	static int solution2(int n){
		return (n-1)%9 + 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution1(38));
		System.out.println(solution2(38));
		
		System.out.println(solution1(100));
		System.out.println(solution2(100));
	}
}
