import java.io.IOException;
import java.util.Scanner;

//��������������һ����������������ֶ�������ʽ��1�ĸ���

public class NumberOf1Bits {

	//����һ��unsigned int ��32λ���޷������ͣ���Java��û��unsigned int�����Կ��Բ�����λ�����
    public static int hammingWeight(int n) {
        int count = 0;
        while(n != 0){//��ΪJava��û���޷��ŵ�������������!=0���ж���ѧ�Ƿ�����ɶ�������>0�ж�
        	count += n & 1;//ȡ����һλ
        	n>>>=1;//��������һλ
        }
        return count;
    }
	
    //��������ֱ�ӵ���Java API��  Integer.bitCount()
	public static int hammingWeight1(int n){
		return Integer.bitCount(n);
	}
	
	//����˼·�������Ľⷨ������˸���������ѭ������ʽ����ѭ���Ĵ����������������Ƶ�λ��
	//��һ��������ȥ1�ٺ�ԭ�������������㣬��Ѹ��������ұ�һ��1���0����ôһ�������Ķ����Ʊ�ʾ�У��ж��ٸ�1���Ϳ��Խ��ж��ٴ������Ĳ���
	public static int hammingWeight2(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = (n - 1)&n;
		}
		return count;
	}
    
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);		
		while(sc.hasNext()){
			int n = sc.nextInt();
			System.out.println(hammingWeight(n) + "\t" + hammingWeight1(n) + "\t" + hammingWeight2(n));
			
			
		}		
	}

}
