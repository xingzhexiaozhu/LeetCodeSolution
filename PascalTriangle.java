import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//题意描述：给定行数，生成帕斯卡三角形。如下numRows=5
//[
//[1],
//[1,1],
//[1,2,1],
//[1,3,3,1],
//[1,4,6,4,1]
//]

public class PascalTriangle {

	//解题思路：将例子写成如上形式，可以发现当row=col或col=0时该位置元素取1，其他情况就是上一层的row[i-1]+row[i]之和
	public static List<List<Integer>> generate(int numRows){		
		List<List<Integer>> results = new ArrayList<List<Integer>>();
				
		if(numRows <= 0) 
			return results;		
		
		List<Integer> preRow = new ArrayList<Integer>();
		preRow.add(1);//加入第一行
		results.add(preRow);
		
		for(int i=1; i<numRows; i++){//numRows行			
			List<Integer> row = new ArrayList<Integer>();
			
			row.add(1);//该行第一个位置元素为1	
			
			for(int j=1; j<i; j++){				
				row.add(preRow.get(j-1) + preRow.get(j));		
			}
			
			row.add(1);//该行最后一个位置元素为1
			
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
