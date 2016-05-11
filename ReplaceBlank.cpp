// 3ReplaceSpace.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"

#include<iostream>
#include<string>
using namespace std;

//����������ʵ��һ���������ַ����е�ÿ���ո��滻�ɡ�20%��
//����:
//���롰we are happy��
//�����we%20are%20happy��

//����˼·�������ǰ��������������ո��ٽ��ַ�����ƶ����������O(n)���ո��ʱ��Ч�ʾ���O(n^2)��
//����Ż��Ľⷨ����һ���Ƶ�λ���ȱ���һ���ַ�������ͬʱ�õ��ַ����ĳ��Ⱥ��ַ����пո��������Ȼ�����1���ո��á�%20��3���ַ��滻��
//���Կ��Լ���������ַ���Ӧ���еĳ��ȣ�����ָ�룬һ��ָ�������ַ�����ĩβ��һ��ָ��ԭʼ�ַ�����ĩβ�����θ��ƣ����ո���滻������
//ָ���غϣ���ָ��ͬһλ�ã�����˵���ո��滻��ϡ��������ʱ��Ч�ʾ���O(n)

void replaceBlank(char string[], int length) {//lengthΪ�ַ������������
	if (string == NULL || length <= 0)
		return;

	int originalLength = 0;//�ַ�����ԭ����
	int numberOfBlank = 0; //�ո����
	int i = 0;
	while (string[i] != '\0') {
		originalLength++;
		if (string[i] == ' ')
			numberOfBlank++;
		i++;
	}

	int newLength = originalLength + numberOfBlank * 2;//���ַ����ĳ���
	if (newLength > length)
		return;

	int indexOfOriginal = originalLength;
	int indexOfNew = newLength;
	while (indexOfOriginal >= 0 && indexOfNew >= indexOfOriginal) {
		if (string[indexOfOriginal] == ' ') {
			string[indexOfNew--] = '0';
			string[indexOfNew--] = '2';
			string[indexOfNew--] = '%';
		}
		else {
			string[indexOfNew--] = string[indexOfOriginal];
		}
		indexOfOriginal--;
	}

	for (int i = 0; string[i] != '\0'; i++)
		cout << string[i];
	cout << endl;
}


int main()
{
	char ch[100] = { 'h','e','l','l','o',' ','w','o','r','l','d' };
	for (int i = 0; ch[i] != '\0'; i++)
		cout << ch[i];
	cout << endl;
	replaceBlank(ch, 100);
    return 0;
}

