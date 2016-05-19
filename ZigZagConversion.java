import java.util.Arrays;
import java.util.Scanner;

//���������������ַ���������nRows�������ַ����������к󷵻��µ��ַ���������������£�
//�磺����"PAYPALISHIRING",nRows=3
//P   A   H   N
//A P L S I I G
//Y   I   R
//����"PAHNAPLSIIGYIR"

//�磬����"01234567891011121314151617181920",nRows=5
//0	 	 	 	8	 	 	 	16	 	 	 
//1	 	 	7	9	 	 	15	17	 	 	 
//2	 	6	 	10	 	14	 	18	 	 	 
//3	5	 	 	11	13	 	 	19	 	 	 
//4	 	 	 	12	 	 	 	20	
//Ȼ���з����µ��ַ���

public class ZigZagConversion {

	//����˼·һ�����ַ�������String[nRows]���洢ÿһ�У����ƴ�Ӿ������ս��
	//����һ��delta��ʾ�����Ƿ��򣬼��Ǵӵ�һ�������һ�л��Ǵ����һ������һ��
	private static String convert(String str, int nRows) {	
        if (str==null || str.length()<=0 || nRows <= 1) 
        	return str;
        
        String[] rows = new String[nRows];//ÿһ�е�Ԫ��
        Arrays.fill(rows, "");//ÿ���ַ���λ��ʼ��Ϊ�հ��ַ���
        int row = 0, delta = 1;//delta=1��ʾ����
        for (int i = 0; i < str.length(); i++) {//��ѭ������ԭ�ַ���������ַ�������String[nRows]
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
	
	//�ⷨ˼·����ÿ�е��ظ����ڶ���2*nRows-2���������Ⱥ�ĩ��֮����У���������ظ�һ�Σ�
	//�ظ�����һ�ξ��뱾������ʼ�ַ��ľ����� 2*nRows-2-2*i
	private static String convert1(String str, int nRows){
		if(str==null || str.length()<=0 || nRows<=1)
			return str;
		
		String result="";
		int period = 2*nRows-2;//ѭ������
		for(int i=0; i<nRows; i++){
			for(int j=i; j<str.length(); j+=period){
				result += str.charAt(j);
				if(i>0 && i<nRows-1){//��������Ҳ����β��
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
