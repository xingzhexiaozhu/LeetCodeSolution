
//题意描述：在上一个题目的基础上考虑到障碍问题，给定二维矩阵，赋值为0或1，当为1时代表障碍。问现在有多少路径？

public class UniquePathII {

	//解题思路：还是上一题的思路，只是如果遇到值为1的结点，那么到达该结点的途径赋值为0即可不影响后面子问题的计算
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
