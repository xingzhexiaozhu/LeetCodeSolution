#include<iostream>
using namespace std;
#include<string>

int test(string str,int start, int end);
 
int main()
{
	char str[100];

	cout<<"请输入一个字符串:"<<endl;
	cin>>str;

	int temp,n;
	n = strlen(str);
	temp = test(str,0,n-1);

	if(temp == 1) cout<<str<<"是回文"<<endl;
	else cout<<str<<"不是回文"<<endl;

	return 0;
}

int test(string str,int start, int end)
{

	if(end - start <= 1) return 1;//中有一个或0个字符时就返回1
	else 
	{
		if(str[start] != str[end])//当有两个字符不同时就返回0
			return 0;

		test(str,++start,--end);		
	}
}