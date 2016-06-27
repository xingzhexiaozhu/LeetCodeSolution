import java.util.Scanner;

//��������������һ���Ǹ���n������0<=x<10^n���ֵĸ������ų���λ��ͬ������
//�磺n=2,����91���ų�[11,22,33,44,55,66,77,88,99]��

public class CountNumbersWithUniqueDigits {

	//����˼·һ�����ֵĻ���Ԫ����[0,1,2,3,4,5,6,7,8,9]��10�����֣��������½��ۣ�
	//n=0	---		1[0]
	//n=1	---		1+9=10[0;1,2,3,4,5,6,7,8,9]
	//n=2	---		10+81[0;1...9;10...98(��ȥ11,22...99)],1+9+9*9
	//n=3	---		10+9*9+9*9*8
	//...
	//n=10	---		10+9*9+9*9*8+...+9*9*8*...1������ܴ�10λ����
	//f(k) = 9*9*...*(9-k+2)
	private static int countNumbersWithUniqueDigits(int n){
		if(n == 0)
			return 1;
		int res = 10;
		int base = 9;
		for(int i=2; i<=n && i<=10; i++){
			base = base * (9 - i + 2);
			res += base;
		}
		return res;
	}	
	
	//����˼·��������
	//��Ŀ��ʾ����˵�Ļ��ݵķ�����������Ҫһ������used��������Ƶ�iλΪ1��ʾ����i���ֹ����տ�ʼ���Ǳ���1��9��
	//����ÿ�������������֣�����used�б���Ѿ����ֹ���Ȼ���ڵ��õݹ麯�����ڵݹ麯���У�����������С�����ֵ��
	//����res����1�����򷵻�res��Ȼ�����0��9�������ǰ����û����used�г��ֹ�����ʱ��used�б�ǣ�Ȼ���
	//��ǰ���ֳ���10����i���ټ������õݹ麯�����������ǿ��Ա��������е�������μ��������£�
	private static int countNumberWithUniqueDigits2(int n){
		if (n > 10) {
            return countNumberWithUniqueDigits2(10);
        }
        int count = 1; // x == 0
        long max = (long) Math.pow(10, n);

        boolean[] used = new boolean[10];

        for (int i = 1; i < 10; i++) {
            used[i] = true;
            count += search(i, max, used);
            used[i] = false;
        }

        return count;
	}
	 private static int search(long prev, long max, boolean[] used) {
        int count = 0;
        if (prev < max) {
            count += 1;
        } else {
            return count;
        }

        for (int i = 0; i < 10; i++) {
            if (!used[i]) {
                used[i] = true;
                long cur = 10 * prev + i;
                count += search(cur, max, used);
                used[i] = false;
            }
        }

        return count;
	 }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while(sc.hasNext()){
			n = sc.nextInt();
			System.out.println(countNumbersWithUniqueDigits(n) + "\t" + countNumberWithUniqueDigits2(n));
		}
	}

}
