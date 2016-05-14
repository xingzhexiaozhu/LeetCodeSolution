import java.util.Scanner;

//��������������2Dƽ���ϵĵľ�������������������ص����֣���ÿ�����θ������½Ǻ����Ͻǵ�����

public class RectangleArea {

	//����˼·������Ŀ��֪������������ص����֣���Ҫô�ֿ��ۼ���ͣ�Ҫô���������ε����֮���ټ�ȥ�ص����ֵ����
	//�Աȷ����������֮���ټ�ȥ�ص����ֵ���������Ƚϼ򵥣����������ø÷���
	//����һ��(A,B),(C,D)�����ζ���(E,F),(G,H)
	
	//ʵ�����ⷢ����Ҫ���ǵ����⻹�ǱȽ�ȫ��ģ�
	//һ��������û���ص�(ovreRect = 0)
	//(1)����һ�����������ε����Ϊ0��
	//(2)��������Ҫô��rightA<leftB || topA<bottomB����
	//�������������ص�
	//(1)����A�����������B�������ص���
	//(2)����A�����������B�������ص���
	//(3)����A������B����

	private static int  computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int rect1 = (C-A) * (D-B);
		int rect2 = (G-E) * (H-F);
		
		//�����ص����Σ��õ����¡���������
		int overRectLeft = Math.max(A, E);
		int overRectBottom = Math.max(B, F);
		int overRectRight = Math.min(C, G);
		int overRectTop = Math.min(D, H);
		
		int overRect;//�ص����
		if(overRectRight<overRectLeft || overRectTop<overRectBottom){
			overRect = 0;//����¾��ε������������������С�������������ص�����
		}else{//�����������в����ص�
			overRect = (overRectRight - overRectLeft) * (overRectTop - overRectBottom);
		}
		
		return rect1 + rect2 - overRect;
	}
	
	public static void main(String[] args) {
		System.out.println(computeArea(-3,0,3,4,0,-1,9,2));//45 ���������ص�����
		System.out.println(computeArea(0,0,0,0,-1,-1,1,1));//4  һ���������Ϊ0
		System.out.println(computeArea(-2,-2,2,2,3,3,4,4));//17 ���������ص����֣���λ��Ϊ���Եģ�����&&���ң���ϵ����б�Խǹ�ϵ  
		System.out.println(computeArea(-1500000001,0,-1500000000,1,
				1500000000,0,1500000001,1));//2  ���������ص����֣���λ�ý�Ϊ�����£�||�����ң���ϵ����ƽ�й�ϵ  
	}

}
