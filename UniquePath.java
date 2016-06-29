import java.util.Scanner;

//��������������һ��������󣬻����˴����Ͻǳ��������½ǣ�ÿ��ѡ��ֻ�����һ������ߡ����ж����ֲ�ͬ��·����
//�����磺3*3��4*7�ȵ�

public class UniquePath {
	
	//����˼·��˼��ʱ�������յ�����������½���һ���;�������֣������ϸ񣩣�������ǰ���ƣ����ֶ���ÿһ������ĵ��ﵱǰ����ķ���ֻ�����֣�
	//��������ߺ��ϱߵı߽�񣬵������ĸ�ֻ��һ��;������˱��뵽״̬���̣�res[i][j] = res[i-1][j] + res[i][j-1]
	private static int uniquePath(int m, int n){
		if(m==0 || n==0)
			return 0;
		int[][] res = new int[m][n];
		for(int i=0; i<m; i++)
			res[i][0] = 1;
		for(int j=0; j<n; j++)
			res[0][j] = 1;
		
		for(int i=1; i<m; i++)
			for(int j=1; j<n; j++)
				res[i][j] = res[i-1][j] + res[i][j-1];
		
		return res[m-1][n-1];
	}

	//����˼·��������ά�����Ż�Ϊһά����
	private static int uniquePath2(int m, int n){
		if(m==0 || n==0)
			return 0;
		
		int[] res = new int[n];
		res[0] = 1;
		for(int i=0; i<m; i++)
			for(int j=1; j<n; j++)
				res[j] += res[j-1];
		
		return res[n-1];
	}
	
	//����˼·����û��������������
	private static int uniquePath3(int m, int n){
		return choose(m+n-2, n-1);
	}
	private static int choose(int n, int k){
		if(k > n-k)
			k = n-k;
		double res = 1;
		for(int i=1; i<=k; i++){
			res *= n-i+1;
			res /= i;
		}
		return (int)res;
	}
	
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int m=0, n=0;
			while(sc.hasNext()){
				m = sc.nextInt();
				n = sc.nextInt();
				System.out.println(uniquePath(m,n) + "\t" + uniquePath2(m,n) + "\t" + uniquePath3(m,n));
			}
	}

}
