import java.util.Scanner;

//��������������n�� ��y1=1!+3!+...m!(m��С�ڵ���n����������� y2=2!+4!+...p!(p��С�ڵ���n�����ż��)

public class GetJieCheng {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int oddRes = getOdd(n);//�����׳�
            int evenRes = getEven(n);//ż���׳�       
            System.out.println(oddRes + " " + evenRes);
        }
	}

	private static int getOdd(int n) {//�����׳˵Ľ��
		if(n == 0 || n == 1)
			return n;
		
		int max = n;
		if(n % 2 == 0)
			max = n-1;
		
		int res = 0, tmp = 1;
		for(int i=1; i<=max; i+=2){
			res += tmp;
			tmp = tmp * (i+1) * (i+2);
		}
		
		return res;
	}

	private static int getEven(int n) {//ż���׳˵Ľ��
		if(n == 0 || n == 1)
			return 0;
		
		int max = n;
		if(n % 2 == 1)
			max = n-1;
		
		int res = 0, tmp = 2;
		for(int i=2; i<=max; i+=2){
			res += tmp;
			tmp = tmp * (i+1) * (i+2);
		}
		
		return res;
	}

}
