import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//��Ŀ:Write a program to find the n-th ugly number.

public class UglyNumberII {
	
	//����һ������UglyNumber��������ж�����n��UglyNumber
	static boolean isUgly(int num){
		if(num == 1) return true;		
		while((num >= 5) && (num%5 == 0)) num /= 5;
		while((num >= 3) && (num%3 == 0)) num /= 3;
		while((num >= 2) && (num%2 == 0)) num /= 2;			
		return num == 1;
	}
	public static int nthUglyNumber1(int n){
		int count = 0;//������i��UglyNumber
		int num = 1;//��1��ʼ�ж��Ƿ�ΪUglyNumber
		for(; count != n; num++){
			if(isUgly(num)) count++;
		}
		return num-1;
	}
	
	//�����������մ�UglyNumber��СUglyNumber��2��3��5��ɣ��������˼���ҵ���N��
	static int nthUglyNumber(int n){
		LinkedList<Integer> l1 = new LinkedList<Integer>(); 
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		l1.add(1);
		l2.add(1);
		l3.add(1);
		
		int theNumber = 0;
		
		for(int i=0; i<n; i++){
			theNumber = Math.min(Math.min(l1.get(0), l2.get(0)), l3.get(0));
			
			if(l1.get(0) == theNumber) l1.remove(0);
			if(l2.get(0) == theNumber) l2.remove(0);
			if(l3.get(0) == theNumber) l3.remove(0);
			
			l1.add(theNumber*2);
			l2.add(theNumber*3);
			l3.add(theNumber*5);
		}
		
		return theNumber;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while((str = br.readLine()) != null){
			System.out.println("The " + str +  "th ugly number is " + nthUglyNumber(Integer.parseInt(str)));			
		}
	}

}
