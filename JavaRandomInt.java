import java.security.SecureRandom;
import java.util.Random;

public class JavaRandomInt {

	public static void main(String[] args) {
		//Math.random()����
		for(int i=0; i<10; i++)
			System.out.print((int)(Math.random()*100) + " ");
		System.out.println();
		
		//�������ӣ�ÿ���������ͬ
		Random rand = new Random();
		for(int i=0; i<10; i++)
			System.out.print(rand.nextInt(100) + " ");
		System.out.println();
		
		//�����ӣ�ÿ���������ͬ
		Random rand2 = new Random(10);
		for(int i=0; i<10; i++)
			System.out.print(rand2.nextInt(100) + " ");
		System.out.println();
		
		//������ȫ���ظ��������
		SecureRandom random = new SecureRandom();
		for(int i=0; i<10; i++)
			System.out.print(random.nextInt(100) + " ");
	}

}
