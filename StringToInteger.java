import java.util.Scanner;

//������������������ַ���ת��Ϊ�����������ĿҪ�������������������û����ȷ˵����Щ������ܽ������������
//1. ����ǰ��Ŀո�
//2. Ȼ������������ţ�ע��ֻȡһ��������ж�������ţ���ô˵����ַ������޷�ת���ģ�����0�����������������и���+-2������
//3. �ַ������԰���0~9������ַ�����������������ַ�����ôֻȡ���ַ�֮ǰ�Ĳ��֣��硰-00123a66������Ϊ��-123����
//4. �������int�ķ�Χ�����ر߽�ֵ��2147483647��-2147483648��


public class StringToInteger {
	
	private static int myAtoi(String str) {
		str = str.trim();//ɾ���ַ����еĿհ׷�
		
		if(str==null||str.length()==0)
			return 0;//�ַ���Ϊ�ջ�null�����		
		
		boolean sign = true;//����λ
		int i = 0;
		if(str.charAt(i) == '+')
			i++;
		else if(str.charAt(i) == '-'){
			sign = false;
			i++;
		}
		
		double result = 0;
		for(; i<str.length(); i++){
			int temp = str.charAt(i) - '0';
			if(temp<0||temp>9)
				break;
			if(sign){
				result = result * 10 + temp;
				if(result > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
			}else{
				result = result * 10 - temp;
				if(result < Integer.MIN_VALUE)
					return Integer.MIN_VALUE;
			}
		}
		
		return (int)result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			System.out.println(myAtoi(str));
		}
	}	
}
