
import java.util.Arrays;
import java.util.Comparator;

//�����㷨�������ĸ߼����Զ���һЩ�ṩ��C������qsort()������C++��sort()������java������Arrays��(����Array)������Щ����ʱ��������д�Լ����������

//1���Ի����������͵����������:
//(1)Arrays���е�sort()ʹ�õ��ǡ��������ŵĿ������򷨡�;
//(2)����int[]��double[]��char[]�Ȼ��������͵����飬Arrays��ֻ֮���ṩ��Ĭ�ϵ��������У�û���ṩ��Ӧ�Ľ������з�����
//(3)Ҫ�Ի������͵�������н���������Ҫ����Щ����ת��Ϊ��Ӧ�ķ�װ�����飬��Integer[]��Double[]��Character[]�ȣ�����Щ�������������(��ʵ�������Ƚ������������Լ���תΪ����)

//��Ĭ�ϵ��������������
// ����ԭ�ͣ�(1)static void sort(int[] a) ��ָ���� int �����鰴���������������
//		  (2)static void sort(int[] a, int fromIndex, int toIndex)��ָ�� int�������ָ����Χ�����������������

//public class JavaArraysSort {
//	public static void main(String[] args) {
//		int[] a = {1,4,-1,5,0};
//		Arrays.sort(a);
//		for(int i=0; i<a.length; i++)
//			System.out.print(a[i] + " ");//-1 0 1 4 5 
//		System.out.println();
//	}
//}


//2���Ը����������͵����ݵ�����
//����ԭ�ͣ�(1)public static<T> void sort(T[] a��Comparator c)����ָ���Ƚ���������˳���ָ�����������������
//����������(2)public static<T> void sort(T[] a��int fromIndex��int toIndex��Comparator c)����ָ���Ƚ���������˳���ָ�����������ָ����Χ�������򡣡�
class Point{
	int x;
	int y;
}

class MyComprator implements Comparator{
	@Override
	public int compare(Object arg0, Object arg1) {
		Point t1 = (Point)arg0;
		Point t2 = (Point)arg1;
		if(t1.x != t2.x)
			return t1.x > t2.x ? 1 : -1;
		else return t1.y > t2.y ? 1 : -1;
	}	 
}

public class JavaArraysSort{
	Point[] arr;
	
	JavaArraysSort(){
		arr = new Point[4];//�����������arr��������洢�Ŀռ�
		for(int i=0; i<4; i++)
			arr[i] = new Point();
	}
	
	public static void main(String[] args){
		JavaArraysSort sort = new JavaArraysSort();
		sort.arr[0].x = 2; sort.arr[0].y = 1;//��ʼ�������е�����
		sort.arr[1].x = 2; sort.arr[1].y = 2;
		sort.arr[2].x = 1; sort.arr[2].y = 2;
		sort.arr[3].x = 0; sort.arr[3].y = 1;
		
		Arrays.sort(sort.arr, new MyComprator());//ʹ��ָ��������������������
		for(int i=0; i<4; i++)//���������
			System.out.println("("+sort.arr[i].x+","+sort.arr[i].y+")");
//		(0,1)
//		(1,2)
//		(2,1)
//		(2,2)
	}
}