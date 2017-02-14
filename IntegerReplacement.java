import java.util.Scanner;

//��������������ż��n��ִ��n/2������������ִ��(n+1)��(n-1)���ʽ�һ��������ת��Ϊ1��Ҫ���ٲ���

//Input:
//8
//Output:
//3
//Explanation:
//8 -> 4 -> 2 -> 1

//Input:
//7
//Output:
//4
//Explanation:
//7 -> 8 -> 4 -> 2 -> 1
//or
//7 -> 6 -> 3 -> 2 -> 1

public class IntegerReplacement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(integerReplacement(n));
		}
	}

	private static int integerReplacement(int n) {
		int res = 0;
		if(n < 2) return res;
		
		long N = n;
		long small, big;
		while(N != 1){
			small = (N & (N-1));
			big = (N & (N+1));
			if((N & 1) == 0)
				N >>= 1;
			else if((small & (small - 1)) <= (big & (big - 1)))
				N = N -1;
			else N = N + 1;
			res++;
		}
		return res;
	}
	

}
