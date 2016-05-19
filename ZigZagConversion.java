import java.util.Arrays;
import java.util.Scanner;

//题意描述：给定字符串和数字nRows，将该字符串重新排列后返回新的字符串，具体规则如下：
//如：给定"PAYPALISHIRING",nRows=3
//P   A   H   N
//A P L S I I G
//Y   I   R
//返回"PAHNAPLSIIGYIR"

//如，给定"01234567891011121314151617181920",nRows=5
//0	 	 	 	8	 	 	 	16	 	 	 
//1	 	 	7	9	 	 	15	17	 	 	 
//2	 	6	 	10	 	14	 	18	 	 	 
//3	5	 	 	11	13	 	 	19	 	 	 
//4	 	 	 	12	 	 	 	20	
//然后按行返回新的字符串

public class ZigZagConversion {

	//解题思路一：用字符串数组String[nRows]来存储每一行，最后拼接就是最终结果
	//并用一个delta表示正向还是反向，即是从第一行往最后一行还是从最后一行往第一行
	private static String convert(String str, int nRows) {	
        if (str==null || str.length()<=0 || nRows <= 1) 
        	return str;
        
        String[] rows = new String[nRows];//每一行的元素
        Arrays.fill(rows, "");//每个字符单位初始化为空白字符串
        int row = 0, delta = 1;//delta=1表示向下
        for (int i = 0; i < str.length(); i++) {//该循环遍历原字符串，填充字符串数组String[nRows]
            rows[row] += str.charAt(i);
            row += delta;
            if (row >= nRows) {
                row = nRows-2;
                delta = -1;
            }
            if (row < 0) {
                row = 1;
                delta = 1;
            }
        }
        
        String result = "";
        for (int i = 0; i < nRows; i++) {
            result += rows[i];
        }
        
        return result;
	}
	
	//解法思路二：每行的重复周期都是2*nRows-2，对于首先和末行之间的行，还会额外重复一次；
	//重复的这一次距离本周期起始字符的距离是 2*nRows-2-2*i
	private static String convert1(String str, int nRows){
		if(str==null || str.length()<=0 || nRows<=1)
			return str;
		
		String result="";
		int period = 2*nRows-2;//循环周期
		for(int i=0; i<nRows; i++){
			for(int j=i; j<str.length(); j+=period){
				result += str.charAt(j);
				if(i>0 && i<nRows-1){//不是首行也不是尾行
					int k = j+period-2*i;
					if(k<str.length())
						result += str.charAt(k);
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.next();
			int nRows = sc.nextInt();
			System.out.println(convert(str, nRows) + " " + convert1(str, nRows));
		}
	}

}
