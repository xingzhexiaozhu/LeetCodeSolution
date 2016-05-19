import java.util.Scanner;

//�������������������������ַ����������ַ�����������ͺ���ַ���
//�磺str1="11",str2="1",����"100"

public class AddBinary {

	//����˼·һ�����ַ���ת��Ϊ���ͣ���Ӻ�ת��Ϊ�������ַ�������
	private static String addBinary(String str1, String str2) {
		int num1 = Integer.parseInt(str1,2);//�������ַ���תʮ����
		int num2 = Integer.parseInt(str2,2);
		
		return Integer.toBinaryString(num1 + num2);
	}

	//����Ľ��ⷽ�����ַ���������������糬��int��ʾ�ķ�Χ���ͻ�ʧЧ
	//����˼·������������ַ�������ʽ���ӵ�λ��ʼ��λ��ӣ�carry���λ
	private static String addBinary1(String str1, String str2){
		int index1 = str1.length()-1;
		int index2 = str2.length()-1;
		int carry = 0;      //��λ
		String result = ""; //���

		while(index1>=0 && index2>=0){//���������ַ����������Ȳ���
			int bitSum = (str1.charAt(index1)-'0') + (str2.charAt(index2)-'0') + carry;
			carry = bitSum/2;
			bitSum = bitSum%2;
			
			result = (char)(bitSum+'0') + result;			
			--index1;
			--index2;
		}
		
		//����ϳ����ַ���
		while(index1>=0){
			int bitSum = (str1.charAt(index1)-'0') + carry;
			carry = bitSum/2;
			bitSum = bitSum%2;
			
			result = (char)(bitSum+'0') + result;
			--index1;
		}
		while(index2>=0){
			int bitSum = (str2.charAt(index2)-'0') + carry;
			carry = bitSum/2;
			bitSum = bitSum%2;
			
			result = (char)(bitSum+'0') + result;
			--index2;
		}
		
		return (carry==0) ? result : "1"+result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str1 = sc.next();
			String str2 = sc.next();
			System.out.println(addBinary(str1,str2) + " " + addBinary1(str1, str2));
		}
	}

}
