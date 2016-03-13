import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//题目:Write a program to find the n-th ugly number.

public class UglyNumberII {
	
	//方法一：借助UglyNumber方法逐个判断至第n个UglyNumber
	static boolean isUgly(int num){
		if(num == 1) return true;		
		while((num >= 5) && (num%5 == 0)) num /= 5;
		while((num >= 3) && (num%3 == 0)) num /= 3;
		while((num >= 2) && (num%2 == 0)) num /= 2;			
		return num == 1;
	}
	public static int nthUglyNumber1(int n){
		int count = 0;//计数第i个UglyNumber
		int num = 1;//从1开始判断是否为UglyNumber
		for(; count != n; num++){
			if(isUgly(num)) count++;
		}
		return num-1;
	}
	
	//方法二：依照大UglyNumber由小UglyNumber乘2、3或5组成，借助这个思想找到第N个
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
