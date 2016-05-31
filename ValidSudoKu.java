import java.util.Arrays;

//题意描述：判断矩阵是否是一个数独矩阵
//所谓的数独矩阵就是9*9的矩阵，每一行一个元素只出现一次、每一列一个元素只出现一次，并且在任意一个小矩阵中一个元素只出现一次
//上面所说的元素指0-9这九个数字

public class ValidSudoKu {

	//解题思路：注意题目中说的是只要当前已经填充的数字是合法的就可以，不一定要这个数独是有解的
	//依次判断已给定的矩阵每一行、每一列、以及每个小矩阵上是否是有重复数字即可
	//如果没有重复的数字则是数独矩阵，否则不为数独矩阵
	public boolean isValid(boolean[] visited, char ch){//判断当前位置是否为'.'，或是否被访问过
		if(ch == '.')//如果当前位置为'.'则返回true
			return true;
		
		int num = ch - '0';
		if(num < 1 || num > 9 || visited[num-1])//如果当前位置访问过则返回false
			return false;
		
		visited[num-1] = true;//将标记数字标记为true,表示该数字已访问过
		return true;
	}
	public boolean isValidSudoku(char[][] board){		
		boolean[] visited = new boolean[9];
		//判断每一行是否有重复数字
		for(int i=0; i<9; i++){
			Arrays.fill(visited, false);
			for(int j=0; j<9; j++){
				if(!isValid(visited, board[i][j]))
					return false;
			}
		}
		//判断每一列是否有重复数字
		for(int i=0; i<9; i++){
			Arrays.fill(visited, false);
			for(int j=0; j<9; j++){
				if(!isValid(visited, board[j][i]))
					return false;
			}
		}
		//判断每个子矩阵是否有重复数字
		for(int i=0; i<9; i+=3){
			for(int j=0; j<9; j+=3){
				Arrays.fill(visited, false);
				for(int k=0; k<9; k++){
					if(!isValid(visited, board[i+k/3][j+k%3]))
						return false;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {

	}

}
