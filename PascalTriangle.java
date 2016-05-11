import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//��������������������������˹�������Ρ�����numRows=5
//[
//[1],
//[1,1],
//[1,2,1],
//[1,3,3,1],
//[1,4,6,4,1]
//]

public class PascalTriangle {

	//����˼·��������д��������ʽ�����Է��ֵ�row=col��col=0ʱ��λ��Ԫ��ȡ1���������������һ���row[i-1]+row[i]֮��
	public static List<List<Integer>> generate(int numRows){		
		List<List<Integer>> results = new ArrayList<List<Integer>>();
				
		if(numRows <= 0) 
			return results;		
		
		List<Integer> preRow = new ArrayList<Integer>();
		preRow.add(1);//�����һ��
		results.add(preRow);
		
		for(int i=1; i<numRows; i++){//numRows��			
			List<Integer> row = new ArrayList<Integer>();
			
			row.add(1);//���е�һ��λ��Ԫ��Ϊ1	
			
			for(int j=1; j<i; j++){				
				row.add(preRow.get(j-1) + preRow.get(j));		
			}
			
			row.add(1);//�������һ��λ��Ԫ��Ϊ1
			
			results.add(row);
			preRow = row;
		}
		
		return results;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int num = sc.nextInt();
			System.out.println(generate(num));			
		}
	}
}
