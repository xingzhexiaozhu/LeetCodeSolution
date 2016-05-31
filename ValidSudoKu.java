import java.util.Arrays;

//�����������жϾ����Ƿ���һ����������
//��ν�������������9*9�ľ���ÿһ��һ��Ԫ��ֻ����һ�Ρ�ÿһ��һ��Ԫ��ֻ����һ�Σ�����������һ��С������һ��Ԫ��ֻ����һ��
//������˵��Ԫ��ָ0-9��Ÿ�����

public class ValidSudoKu {

	//����˼·��ע����Ŀ��˵����ֻҪ��ǰ�Ѿ����������ǺϷ��ľͿ��ԣ���һ��Ҫ����������н��
	//�����ж��Ѹ����ľ���ÿһ�С�ÿһ�С��Լ�ÿ��С�������Ƿ������ظ����ּ���
	//���û���ظ������������������󣬷���Ϊ��������
	public boolean isValid(boolean[] visited, char ch){//�жϵ�ǰλ���Ƿ�Ϊ'.'�����Ƿ񱻷��ʹ�
		if(ch == '.')//�����ǰλ��Ϊ'.'�򷵻�true
			return true;
		
		int num = ch - '0';
		if(num < 1 || num > 9 || visited[num-1])//�����ǰλ�÷��ʹ��򷵻�false
			return false;
		
		visited[num-1] = true;//��������ֱ��Ϊtrue,��ʾ�������ѷ��ʹ�
		return true;
	}
	public boolean isValidSudoku(char[][] board){		
		boolean[] visited = new boolean[9];
		//�ж�ÿһ���Ƿ����ظ�����
		for(int i=0; i<9; i++){
			Arrays.fill(visited, false);
			for(int j=0; j<9; j++){
				if(!isValid(visited, board[i][j]))
					return false;
			}
		}
		//�ж�ÿһ���Ƿ����ظ�����
		for(int i=0; i<9; i++){
			Arrays.fill(visited, false);
			for(int j=0; j<9; j++){
				if(!isValid(visited, board[j][i]))
					return false;
			}
		}
		//�ж�ÿ���Ӿ����Ƿ����ظ�����
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
