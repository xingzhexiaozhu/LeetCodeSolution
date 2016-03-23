/*算法设计中经余猜数P113
完成给"余"猜数的游戏：心里先想好一个1~100之间的整数x，
然后输入3个除数a、b、c，再输入x分别除以a、b、c后所得
到的余数ra、rb、rc，计算机能求出这个数x并输出x。
*/
 #include<iostream>
using namespace std;

int gcd(int m,int n)//最大公约数
{
	int g;
 
	if(!n) g = m;
	else g = gcd(n,m%n);
	return g;
}
 
int dou(int x,int y)//最小公倍数
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

	cout<<"请你先想一个1到100之间的数……"<<endl;

	cout<<"请输入三个除数:"<<endl;
	cin>>a>>b>>c;
	cout<<"您输入的除数为:"<<a<<" "<<b<<" "<<c<<endl;

	cout<<"请输入三个余数:"<<endl;
	cin>>ra>>rb>>rc;
	cout<<"您输入的余数为:"<<ra<<" "<<rb<<" "<<rc<<endl;

	
	/*方法一：穷举法
	int temp = 0;
	for(int i = 0; i < 100; i++)
	{
		if(i%a==ra&&i%b==rb&&i%c==rc)
			temp = i;			
	}
	
	if(temp != 0)
		cout<<"你的除数为:"<<temp<<endl;
	else cout<<"没有找到呀!!"<<endl;
	*/

	//方法二：数学公式技巧
	int tempab,tempbc,tempca;//分别为ab,bc,ca最小公倍数
	tempab = dou(a,b);
	tempbc = dou(b,c);
	tempca = dou(c,a);
	
	int raa,rbb,rcc,n;//分别为ra,rb,rc系数
	
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

	int number;//你所想的数字
	number = raa*ra + rbb*rb + rcc*rc;
	while(number > a*b*c)
		number = number - a*b*c;
	cout<<"你所想的数字是:"<<number<<endl;

	return 0;
}