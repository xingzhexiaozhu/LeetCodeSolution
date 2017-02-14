import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//������������һ������Ϊn���������������ֶ���0-(n-1)֮�䣬������ĳЩ�������ظ��ģ�����֪�����������ظ��ˣ�Ҳ��֪���ظ��˼��Ρ�
//���ҳ�����������һ���ظ������֡�����������볤Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ��������ظ�������2����3

public class DuplicateNum {
	//����˼·һ������Ȼ��������ҵ���һ���ظ������֡������ʱ�临�Ӷ�����ΪO(nlogn)�����в���ʱ�临�Ӷȡ�
	private static int getDuplicateNum(int[] num) {	
		int res = -1;
				
		if(num == null || num.length <=0)
			return res;
			
		for(int i=0; i<num.length; i++)
			if(num[i] <0 || num[i] >= num.length)
				return res;
		
		Arrays.sort(num);
		
		for(int i=0; i<num.length-1; i++)
			if(num[i+1] == num[i])
				return num[i];
		
		return res;
	}
	
	//����˼·������ϣ��ʱ�临�Ӷ�ΪO(n)������Ҫ����Ŀռ䡿
	private static int getDuplicateNum2(int[] num) {		
		int res = -1;
		if(num == null || num.length <=0)
			return res;
		
		for(int i=0; i<num.length; i++)
			if(num[i] <0 || num[i] >= num.length)
				return res;
		
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<num.length; i++){
			if(set.contains(num[i]))
				return num[i];
			set.add(num[i]);
		}
		
		return -1;
	}
	
	//����˼·������ͷ�������飬a[i]��i�ȣ�����������һλ������������index=a[i]Ȼ��a[i]��a[index]��������һ�˽����Ϳ����ҵ��ظ�Ԫ��
	private static int getDuplicateNum3(int[] num) {		
		int res = -1;
		if(num == null || num.length <=0)
			return res;
		
		for(int i=0; i<num.length; i++)
			if(num[i] <0 || num[i] >= num.length)
				return res;
		
		for(int i=0; i<num.length; i++){
			while(num[i] != i){
				if(num[i] == num[num[i]])
					return num[i];
				
				int tmp = num[i];
				num[i] = num[num[i]];
				num[num[i]] = tmp;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int[] num = new int[n];
			for(int i=0; i<n; i++)
				num[i] = sc.nextInt();
			
			if(getDuplicateNum(num) != -1)
				System.out.println(getDuplicateNum(num) + "\t" + getDuplicateNum2(num) + "\t" + getDuplicateNum3(num));
			else
				System.out.println("Invalid input!");
		}
	}
}
