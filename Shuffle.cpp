// Shuffle.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"

#include<iostream>
using namespace std;

#define MAX 54

/*ȫ��ϴ�Ʒ���
1����������һ�����飬��СΪ54����ʼ��Ϊ1-54��
2����������1��54�𲽶�ÿһ�������ƽ���ϴ�ƣ���������һ������value=rand�������ƾͺ���������ƽ��н���
3����������54һ���ƾ�ϴ����
*/
void get_rand_number(int array[], int length) {
	int index;
	int value;
	int temp;

	if (NULL == array || 0 == length)
		return;

	//ÿ�η��Ƶ�ʱ��������������������
	for (int index = 0; index < length; index++) {
		value = rand() % length;

		temp = array[index];
		array[index] = array[value];
		array[value] = temp;
	}
}

/*�ֲ�ϴ�Ʒ���
��������ϴ���㷨������ÿ��ϴ��֮��ԭ��ϴ�õ��ƶ�����ж��β��������Կ��ԸĽ���
1��ͬ����������һ����СΪ54�����飬��������Ϊ1-54
2�������ƴ�1��ʼ��54��������һ��������ֻ��ʣ�»�û��ϴ���ƽ��н�����value=index+rand()%(54-index)
3���ȵ����е������ƶ�ϴ��֮��һ���ƾ�ϴ����
*/
void get_rand_number2(int array[], int length) {
	int index;
	int value;
	int temp;

	if (NULL == array || 0 == length)
		return;

	//���Ƶ�ʱ������Ѿ���������ݲ����޸�
	for (int index = 0; index < MAX; index++) {
		value = index + rand() % (length - index);

		temp = array[index];
		array[index] = array[value];
		array[value] = temp;
	}
}


int main()
{
	int array[MAX];
	for (int i = 0; i < MAX; i++) {
		array[i] = i + 1;
		cout << array[i] << " ";
	}
	cout << endl;

	//ȫ��ϴ�Ʒ�
	get_rand_number(array, MAX);
	for (int i = 0; i < MAX; i++) {
		cout << array[i] << " ";
	}
	cout << endl;

	//�ֲ�ϴ�Ʒ�
	get_rand_number2(array, MAX);
	for (int i = 0; i < MAX; i++) {
		cout << array[i] << " ";
	}
	cout << endl;

    return 0;
}

