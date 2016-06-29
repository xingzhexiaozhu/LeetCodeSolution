
//��������������һ����Ŀ�Ļ����Ͽ��ǵ��ϰ����⣬������ά���󣬸�ֵΪ0��1����Ϊ1ʱ�����ϰ����������ж���·����

public class UniquePathII {

	//����˼·��������һ���˼·��ֻ���������ֵΪ1�Ľ�㣬��ô����ý���;����ֵΪ0���ɲ�Ӱ�����������ļ���
	private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
		
		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;
		int[][] paths = new int[n][m];
		
		for(int i=0; i<n; i++){
			if(obstacleGrid[i][0] != 1)
				paths[i][0] = 1;
			else break;
		}
		for(int j=0; j<m; j++){
			if(obstacleGrid[0][j] != 1)
				paths[0][j] = 1;
			else break;
		}
			
		for(int i=1; i<n; i++){
			for(int j=1; j<m; j++){
				if(obstacleGrid[i][j] != 1)
					paths[i][j] = paths[i-1][j] + paths[i][j-1];
				else paths[i][j] = 0;
			}
		}
		
		return paths[n-1][m-1];
    }
	
	public static void main(String[] args) {
		int[][] num = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(uniquePathsWithObstacles(num));
	}

}
