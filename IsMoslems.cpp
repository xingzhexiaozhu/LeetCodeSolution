#include<iostream>
using namespace std;
#include<string>

int test(string str,int start, int end);
 
int main()
{
	char str[100];

	cout<<"������һ���ַ���:"<<endl;
	cin>>str;

	int temp,n;
	n = strlen(str);
	temp = test(str,0,n-1);

	if(temp == 1) cout<<str<<"�ǻ���"<<endl;
	else cout<<str<<"���ǻ���"<<endl;

	return 0;
}

int test(string str,int start, int end)
{

	if(end - start <= 1) return 1;//����һ����0���ַ�ʱ�ͷ���1
	else 
	{
		if(str[start] != str[end])//���������ַ���ͬʱ�ͷ���0
			return 0;

		test(str,++start,--end);		
	}
}