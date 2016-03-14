import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOf1Bits {

	//unsigned int ��32λ���޷������ͣ���Java��û��unsigned int�����Կ��Բ�����λ�����
    public static int hammingWeight(int n) {
        int count = 0;
        while(n != 0){//��ΪJava��û���޷��ŵ�������������!=0���ж���ѧ�Ƿ�����ɶ�������>0�ж�
        	count += n & 1;//ȡ����һλ
        	n>>>=1;//��������һλ
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
