//罗马字符与阿拉伯数字关系：
// I	V	X	L	C	D	M
// 1	5	10	50	100	500	1000

public class IntToRoman {
 
	static String intToRoman(int num){
		int number[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String symbol[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		
		String roman = "";
		for(int i=0; num>0; i++){
			int count = num/number[i];
			num %= number[i];
			for(; count>0; count--)
				roman += symbol[i];
		}
		return roman;
	}
	
    public static void main(String[] args) {
    	System.out.println(intToRoman(1990));
    }
}
