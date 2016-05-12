import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//������������������k�����ص�K�е�����(ֻ��O(k)�Ŀռ�)������K=3��
//[1,3,3,1]

public class PascalTriangleII {

	//����˼·��������֪��0��Ϊ[1]����1��[1,1]����2��[1,2,1]����3��[1,3,3,1]
	private static List<Integer> getRow(int index) {
		List<Integer> list = new ArrayList<Integer>(index);
		if(index < 0) 
			return list;
	
		for(int i=0; i<=index; i++){
			list.add(1);
			for(int j=i-1; j>0; j--){
				list.set(j, list.get(j-1)+list.get(j));
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int k = sc.nextInt();
			System.out.println(getRow(k));
		}
	}
}
