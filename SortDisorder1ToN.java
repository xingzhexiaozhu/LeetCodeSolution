
//��1,2,��,n�����������飬�������㷨������Ҫ��ʱ�临�Ӷ�ΪO(n)��
//�ռ临�Ӷ�O(1)��ʹ�ý���������һ��ֻ�ܽ���������

public class SortDisorder1ToN {

	public static void main(String[] args) {
		
		int[] array = {10,6,9,5,2,8,4,7,1,3};
		//System.out.println(array.length);//10
		System.out.print("������ԭ����Ϊ��");
		for(int i=0; i<array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
		
		int len = array.length;
		for(int i=0; i<len;){
			//���������ֱ����������λ����ֱ����������ѭ��
			if(array[i] == i+1){
				i++;
				continue;
			}
			int temp = array[array[i]-1];
			array[array[i]-1] = array[i];
			array[i] = temp;
		}
		
		System.out.print("�����е����������");
		for(int i=0; i<array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

}
