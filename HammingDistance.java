import java.util.Scanner;

//The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
//Given two integers x and y, calculate the Hamming distance.

//Input: x = 1, y = 4
//Output: 2
//Explanation:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//The above arrows point to positions where the corresponding bits are different.

public class HammingDistance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(hammingDistance(x, y) + "\t" + hammingDistance1(x, y));
		}

	}

	//方法一：即两数异或(同0异1)的结果中1的个数
	private static int hammingDistance(int x, int y) {
		return Integer.bitCount(x^y);
	}

	//方法二：不用API中的Integer.bitCount()
	private static int hammingDistance1(int x, int y){
		int res = x ^ y;
		int count = 0;
		while(res != 0){
			count++;
			res = res & (res-1);
		}
		return count;
	}
}
