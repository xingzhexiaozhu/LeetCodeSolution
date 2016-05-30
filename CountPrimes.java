import java.util.Scanner;

//������������������N�������NС�����������ĸ���

public class CountPrimes {

	//����˼·һ����1~N��һ�ж��Ƿ�Ϊ����
	private static boolean IsPrimes(int n) {//�ж�����N�Ƿ�Ϊ����
		if(n <= 1)
			return false;
		for(int i=2; i<=Math.sqrt(n); i++){
			if(n % i == 0)
				return false;
		}
		return true;
	}	
	private static int countPrimes(int n) {
		int count = 0;
		for(int i=2; i<n; i++){
			if(IsPrimes(i))
				++count;
		}
		
		return count;
	}
	
	//����˼·��������Ľ��ⷽ��������������㣨����ÿһ�����ֶ����2��ʼ���㣩���ύ��õ���ʱ����
	//�������ܱ�����С�������������Կ����ñ�����齫С��N�ķ�������ɾ��
	private static int CountPrimes1(int n){
		boolean[] flag = new boolean[n];
		for(int i=2; i*i<n; ++i){
			if(!flag[i]){
				for(int j=i; i*j<n; j++)
					flag[i*j] = true;
			}
		}
		
		int count = 0;
		for(int i=2; i<n; i++)
			if(flag[i] == false)
				++count;
		
		return count;
	}
	
	public static void main(String[] args) {			
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(countPrimes(n) + " " + CountPrimes1(n));
		}
	}

}
