import java.util.Scanner;

//��������������n�����ݣ���ʼ��ȫΪoff����һ��ȫ�ʲ�on���ڶ��˽�ÿ�ڶ���off�������˽�ÿ��������ת������n�˽���n����ת
//��󷵻ص��ݴ���on����Ŀ������������
//Given n = 3��
//At first, the three bulbs are [off, off, off].
//After first round, the three bulbs are [on, on, on].
//After second round, the three bulbs are [on, off, on].
//After third round, the three bulbs are [on, off, off]. 
//So you should return 1, because there is only one bulb is on.

public class BulbSwitcher {

	//����˼·һ�����Է��ֵ�n=1,2,3ʱ����1����4��ʼ�������жϵ�ǰ���Ƿ�����������������1
	private static int bulbSwitcher(int n) {
		if(n <= 0)
			return 0;
		int res = 1;
		for(int i=4; i<=n; i++){
			if(isOn(i))
				res++;
		}
		return res;
	}
	private static boolean isOn(int k){//�жϵ�k�����Ƿ�����
		//�жϵķ������Ǵ�2����ǰ��k���������k�����ӣ�����״̬��תһ��
		boolean flag = true;
		for(int i=2; i<=k; i++){
			if(k % i == 0)
				flag = !flag;
		}
		return flag;
	}
	
	//����˼·��������Ľ���˼·û���õ�������n�뷴ת�����Ĺ�ϵ���Ӷ������˵�n����ʱ���г�ʱ
	//�۲��������еĽ����[1,3]---1;  [4,8]---2;  [9,15]---3;  [16,24]---4;  [25,35]---5
	//���ִ�[i,i*(i+2)]---i
	private static int bulbSwitcher2(int n){
		if(n <= 0)
			return 0;
		else
			return (int)Math.sqrt(n);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int n;
		while(sc.hasNext()){
			n = sc.nextInt();
			System.out.println(bulbSwitcher(n) + "\t" + bulbSwitcher2(n));
		}
	}

}
