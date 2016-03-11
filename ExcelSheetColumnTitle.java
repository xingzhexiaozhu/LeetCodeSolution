import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExcelSheetColumnTitle {

	public static String convertToTitle(int n){	
		String str = "";
		while(n > 0){
			str = (char)((n-1)%26 + 65) + str;
			n = (n-1)/26;
		}
		return str;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while((str=br.readLine()) != null){
			System.out.println(convertToTitle(Integer.parseInt(str)));
		}			
	}
}
