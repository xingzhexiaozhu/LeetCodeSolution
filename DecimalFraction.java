import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//将一个小数分成整数部分和小数部分

public class DecimalFraction {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int num;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while((str = br.readLine()) != null){
			double temp = Double.parseDouble(str);
			int integer = (int)(temp);
			float decimal = (float)(temp - integer);
			System.out.println("Num=" + temp + "\tInteger=" + integer + "\tDecimal=" + decimal);
		}
	}

}
