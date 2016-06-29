import java.util.Scanner;

//题意描述：给定一个方格矩阵，机器人从左上角出发到右下角，每次选择只能向右或向下走。问有多少种不同的路径？
//方格如：3*3，4*7等等

public class UniquePath {
	
	//解题思路：思考时从最后的终点出发，到右下角那一格的途径有两种（左格或上格），依次向前递推，发现对于每一个方格的到达当前方格的方法只有两种，
	//而对于左边和上边的边界格，到这样的格只有一种途径，因此便想到状态方程：res[i][j] = res[i-1][j] + res[i][j-1]
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

	//解题思路二：将二维数组优化为一维数组
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
	
	//解题思路三：没看懂？？？待看
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
