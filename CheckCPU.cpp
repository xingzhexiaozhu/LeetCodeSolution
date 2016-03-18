// CheckCPU.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"

//д�����жϣ�����������BigEndian�򷵻�0����ΪLittleEndian�򷵻�1

#include<stdio.h>

//���ͣ�
//����������union�Ĵ��˳�������г�Ա���ӵ͵�ַ��ʼ��ţ����ø���
//�ԾͿ��Թ��ɵػ��CPU���ڴ����LittleEndian����BigEndianģʽ��д

//����һ��
int checkFunction() {
	union {
		int a;
		char b;
	}c;
	c.a = 1;
	return (c.b == 1);//���ģʽ�򷵻�0�����򷵻�false
}

//��������
bool checkFunction2() {
	short int test = 0x1234;
	if (*((char *)&test) == 0x12)
		return true;//������ģʽ�򷵻�true
	else return false;//���򷵻�false
}

int main()
{
	int flag = checkFunction();
	if(flag == 0)
		printf("CPU is BigEndian!\n");
	else printf("CPU is LittleEndian!\n");

	int flag2 = checkFunction2();
	if (flag2 == true)
		printf("CPU is BigEndian!\n");
	else printf("CPU is LittleEndian!\n");

    return 0;
}

