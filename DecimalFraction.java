import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//��һ��С���ֳ��������ֺ�С������

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
