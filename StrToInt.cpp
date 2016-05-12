// StrToInt.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"

//���ַ���ת��Ϊ����

#include<iostream>
#include<string>
using namespace std;

//������������������ַ���ת��Ϊ�����������ĿҪ�������������������û����ȷ˵����Щ������ܽ������������
//1. ����ǰ��Ŀո����
//2. Ȼ������������ţ�ע��ֻȡһ��������ж�������ţ���ô˵����ַ������޷�ת���ģ�����0�����������������и���+-2������
//3. �ַ������԰���0~9������ַ�����������������ַ�����ôֻȡ���ַ�֮ǰ�Ĳ��֣��硰-00123a66������Ϊ��-123����
//4. �������int�ķ�Χ�����ر߽�ֵ��2147483647��-2147483648��



int strToInt(string str) {
	int len = str.length();//�ַ�������
	int i = 0;
	bool overFlow = false;//�Ƿ����λ
	int sign = 1;//����λ
	int result = 0;//���ս��

	while (i < len && (str[i] == ' ' || str[i] == '\n' || str[i] == '\t'))//�ַ���Ϊ��
		++i;
	if (i == len)
		return 0;

	if (str[i] == '-') {
		i++;
		sign = -1;
	}
	else if (str[i] == '+')
		i++;

	while (i < len) {
		if (!isdigit(str[i]))
			break;
		if (sign == 1 && result>(INT_MAX - (str[i] - '0')) / 10 ||
			(sign == -1 && -result < (INT_MIN + (str[i] - '0')) / 10)) {
			overFlow = true;
			break;
		} 
		result = result * 10 + (str[i] - '0');
		i++;
	}
	if (overFlow)
		result = (sign == 1) ? INT_MAX : INT_MIN;
	else result = sign*result;

	return result;
}

int main()
{
	string str = "123";
	while (cin >> str) {
		cout << strToInt(str) << endl;
	}	

    return 0;
}

