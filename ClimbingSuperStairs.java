import java.util.Scanner;

//������������һ¥�ݹ�m�����տ�ʼʱ���ڵ�һ������ÿ��ֻ�ܿ���һ�����߶�����Ҫ����m�������ж����߷���ע���涨��һ����һ����0���߷���
//����һ��������int n���뷵��һ������������¥�ķ�ʽ������֤nС�ڵ���100��Ϊ�˷�ֹ������뷵�ؽ��Mod 1000000007��ֵ��
//����������
//���룺3
//���أ�2

public class ClimbingSuperStairs {

	private static int countWays(int n) {
		int[] res = new int[n];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        for(int i=3; i<n; i++)
            res[i] = (res[i-1] + res[i-2]) % 1000000007;
         
        return res[n-1];
	}
	
	private static int countWays2(int n){
		int res=0, a=0, b=1;
		for(int i=1; i<n; i++){
			res = (a + b) % 1000000007;
			a = b;
			b = res;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(countWays(n) + " " + countWays2(n));
		}
	}

}
