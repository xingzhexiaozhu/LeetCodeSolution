import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExcelSheetColumnNumber {

	public static int titleToNumber(String str){
		int num = 0;
		for(int i=0; i<str.length(); i++)
			num = num * 26 + (str.charAt(i)-64);
		return num;
	}
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while((str=br.readLine()) != null){
			System.out.println(titleToNumber(str));
		}
	}

}
