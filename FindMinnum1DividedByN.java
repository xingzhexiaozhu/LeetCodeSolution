import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//�ҵ���С��ȫ����1��ɵ��ܱ�n��������

//����˼·��1+10+100+...���������ÿһλ�ϵ�1ģȥ���������n�������֮���Կ��Ա�n��������

public class FindMinnum1DividedByN {

	static int FindMinnum1(int n){
		int num = 1;//�Ӹ�λ��ʼ��1��10��100...
		int countNum = 1;//����1��λ��
		int curModLeft = 0;//��ǰλģn�������
		int totalModLeft = 1;//ÿһλģn�������֮��	
		
		while((totalModLeft%n) != 0){//ѭ����������TotalModLeft��������n
			num = num * 10;
			curModLeft = num % n;
			totalModLeft += curModLeft;
			countNum++;
		}
		
		return countNum;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		while(str != null){
			System.out.println(str + " can divided by " + FindMinnum1(Integer.parseInt(str)) + " 1");
			str = br.readLine();
		}
	}

}
