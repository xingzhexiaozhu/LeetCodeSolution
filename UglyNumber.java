import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//ÌâÄ¿£ºWrite a program to check whether a given number is an ugly number
//Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
//For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
//Note that 1 is typically treated as an ugly number.

public class UglyNumber {

	static boolean isUgly(int num){
		if(num == 1) return true;
		
//		while((num >= 5) && (num%5 == 0)) num /= 5;
//		while((num >= 3) && (num%3 == 0)) num /= 3;
//		while((num >= 2) && (num%2 == 0)) num /= 2;		
		while(num%5 == 0) num /= 5;
		while(num%3 == 0) num /= 3;
		while(num%2 == 0) num /= 2;
		
		return num == 1;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while((str = br.readLine()) != null){
			System.out.println(str + " is ugly number --- " + isUgly(Integer.parseInt(str)));			
		}
	}

}
