import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOf1Bits {

	//unsigned int 是32位的无符号整型，而Java中没有unsigned int，所以可以采用移位运算符
    public static int hammingWeight(int n) {
        int count = 0;
        while(n != 0){//因为Java中没有无符号的整数，所以用!=0来判断数学是否处理完成而不能用>0判断
        	count += n & 1;//取出第一位
        	n>>>=1;//数字右移一位
        }
        return count;
    }
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while((str=br.readLine())!=null){
			System.out.println(hammingWeight(Integer.parseInt(str)));
		}		
	}

}
