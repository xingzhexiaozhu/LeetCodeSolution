/*�㷨����о������P113
��ɸ�"��"��������Ϸ�����������һ��1~100֮�������x��
Ȼ������3������a��b��c��������x�ֱ����a��b��c������
��������ra��rb��rc�����������������x�����x��
*/
 #include<iostream>
using namespace std;

int gcd(int m,int n)//���Լ��
{
	int g;
 
	if(!n) g = m;
	else g = gcd(n,m%n);
	return g;
}
 
int dou(int x,int y)//��С������
{
	int l,h;
	l = gcd(x,y);
	h = (x/l)*(y/l)*l;
	return h;
}

int main()
{
	int a,b,c;
	int ra,rb,rc;

	cout<<"��������һ��1��100֮���������"<<endl;

	cout<<"��������������:"<<endl;
	cin>>a>>b>>c;
	cout<<"������ĳ���Ϊ:"<<a<<" "<<b<<" "<<c<<endl;

	cout<<"��������������:"<<endl;
	cin>>ra>>rb>>rc;
	cout<<"�����������Ϊ:"<<ra<<" "<<rb<<" "<<rc<<endl;

	
	/*����һ����ٷ�
	int temp = 0;
	for(int i = 0; i < 100; i++)
	{
		if(i%a==ra&&i%b==rb&&i%c==rc)
			temp = i;			
	}
	
	if(temp != 0)
		cout<<"��ĳ���Ϊ:"<<temp<<endl;
	else cout<<"û���ҵ�ѽ!!"<<endl;
	*/

	//����������ѧ��ʽ����
	int tempab,tempbc,tempca;//�ֱ�Ϊab,bc,ca��С������
	tempab = dou(a,b);
	tempbc = dou(b,c);
	tempca = dou(c,a);
	
	int raa,rbb,rcc,n;//�ֱ�Ϊra,rb,rcϵ��
	
	n = 1;
	while(n * tempab % c != 1)
		n++;
	rcc = n * tempab;

	n = 1;
	while(n * tempbc % a != 1)
		n++;
	raa = n * tempbc;

	n = 1;
	while(n * tempca % b != 1)
		n++;
	rbb = n * tempca;

	int number;//�����������
	number = raa*ra + rbb*rb + rcc*rc;
	while(number > a*b*c)
		number = number - a*b*c;
	cout<<"�������������:"<<number<<endl;

	return 0;
}