import java.util.HashSet;
import java.util.Set;

//��Ŀ������һ�����ĸ���λ���ϵ�ƽ������1λ���������ܵõ�1��������HappyNumber
//���磺19 1^2+9^2=82,8^2+2^2=68,6^2+8^2=100,1^2+0^2+0^2=1  =>19ΪHappyNumber

public class HappyNumber {

	//����˼·�����ݿ������ļ��㷽�������Ǻ��������޲�����ȷ��һ�����Ƿ��ǿ���������ʹ���ų����Ļ���
	//���ǿ��Գ���ȷ��һ�������ǿ��������������⣬�������������ѭ����ʱ��Ͳ��ǿ���������������ѭ��
	//��˵����������ͬ�Ľ�������ж���ͬ���ֻҪ��Set������
	static boolean isHappy(int n){
		Set<Integer> set = new HashSet<>();
		while(n != 1){
			int sum = 0;
			while(n > 0){
				sum += (n%10)*(n%10);
				n = n/10;
			}
			if(set.contains(sum)){
				return false;
			}else{
				set.add(sum);
			}
			n= sum;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag = isHappy(19);
		if(flag) System.out.println(19 + " is a happy number!");
		else System.out.println(19 + "is not a happy number!");
	}

}
